package org.example.Module.Servicio;

import org.example.Module.Dao.RecetaDao;
import org.example.Module.Receta;

import java.time.LocalDate;

public class DespachoService {

    private final RecetaDao recetaDao;

    public DespachoService(RecetaDao recetaDao) {
        this.recetaDao = recetaDao;
    }

    public void iniciarDespacho(String idReceta) {
        Receta receta = recetaDao.findById(idReceta).orElseThrow(() ->
                new IllegalArgumentException("Receta no encontrada")
        );

        LocalDate hoy = LocalDate.now();
        if (receta.getFechaRetiro() == null ||
                receta.getFechaRetiro().isBefore(hoy.minusDays(3)) ||
                receta.getFechaRetiro().isAfter(hoy.plusDays(3))) {
            throw new IllegalStateException("La receta no está en la ventana de retiro permitida");
        }

        if (!"confeccionada".equalsIgnoreCase(receta.getEstado())) {
            throw new IllegalStateException("La receta debe estar en estado 'confeccionada' para iniciar el despacho");
        }

        receta.setEstado("proceso");
        recetaDao.update(receta);
    }

    public void alistarReceta(String idReceta) {
        Receta receta = recetaDao.findById(idReceta).orElseThrow(() ->
                new IllegalArgumentException("Receta no encontrada")
        );

        if (!"proceso".equalsIgnoreCase(receta.getEstado())) {
            throw new IllegalStateException("La receta debe estar en estado 'proceso' para ser alistada");
        }

        receta.setEstado("lista");
        recetaDao.update(receta);
    }


    public void entregarReceta(String idReceta) {
        Receta receta = recetaDao.findById(idReceta).orElseThrow(() ->
                new IllegalArgumentException("Receta no encontrada")
        );

        if (!"lista".equalsIgnoreCase(receta.getEstado())) {
            throw new IllegalStateException("La receta debe estar en estado 'lista' para poder entregarse");
        }

        receta.setEstado("entregada");
        recetaDao.update(receta);
    }
}