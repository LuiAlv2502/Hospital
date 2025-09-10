package org.example.Module.Servicio;

import org.example.Module.Dao.MedicamentoDao;
import org.example.Module.Receta;
import org.example.Module.DetalleMedicamento;
import org.example.Module.Paciente;
import org.example.Module.Dao.RecetaDao;
import org.example.Module.Dao.PacienteDao;
import org.example.Module.Dao.MedicoDao;

import java.time.LocalDate;
import java.util.Optional;

public class PrescripcionService {

    private final PacienteDao pacienteDao;
    private final MedicoDao medicoDao;
    private final RecetaDao recetaDao;
    private final MedicamentoDao medicamentoDao;

    public PrescripcionService(PacienteDao pacienteDao, MedicoDao medicoDao, RecetaDao recetaDao, MedicamentoDao medicamentoDao) {
        this.pacienteDao = pacienteDao;
        this.medicoDao = medicoDao;
        this.recetaDao = recetaDao;
        this.medicamentoDao = medicamentoDao;
    }

    // Inicia una nueva receta para un paciente por un médico
    public Receta iniciarReceta(String idPaciente) {
        Paciente paciente = pacienteDao.searchPacienteById(idPaciente);
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente no encontrado con ID: " + idPaciente);
        }

        Receta receta = new Receta(paciente);
        receta.setFechaConfeccion(LocalDate.now());
        receta.setEstado("en_proceso");

        return recetaDao.saveNew(receta);
    }

    // Agrega un medicamento a la receta
    public void agregarMedicamento(String idReceta, String codigoMedicamento, int cantidad, String indicaciones, int duracionDias) {
        Receta receta = recetaDao.findById(idReceta).orElseThrow(() ->
                new IllegalArgumentException("Receta no encontrada")
        );

        var medicamento = medicamentoDao.findByCodigo(codigoMedicamento)
                .orElseThrow(() -> new IllegalArgumentException("Medicamento no encontrado con código: " + codigoMedicamento));

        // Asocia el medicamento real al detalle
        DetalleMedicamento detalle = new DetalleMedicamento(
                medicamento.getCodigo(),
                cantidad,
                indicaciones,
                duracionDias
        );

        receta.agregarMedicamento(detalle);
        recetaDao.update(receta);
    }

    // Elimina un medicamento de la receta
    public void eliminarMedicamento(String idReceta, String detalle) {
        Receta receta = recetaDao.findById(idReceta).orElseThrow(() ->
                new IllegalArgumentException("Receta no encontrada")
        );

        receta.eliminarMedicamento(detalle);
        recetaDao.update(receta);
    }

    // Registra la receta definitiva con fecha de retiro
    public void registrarReceta(String idReceta, LocalDate fechaRetiro) {
        Receta receta = recetaDao.findById(idReceta).orElseThrow(() ->
                new IllegalArgumentException("Receta no encontrada")
        );

        if (receta.getMedicamentos().isEmpty()) {
            throw new IllegalStateException("No se puede registrar una receta sin medicamentos");
        }

        receta.registrar(fechaRetiro);
        recetaDao.update(receta);
    }

    // Obtener receta por ID
    public Optional<Receta> obtenerReceta(String idReceta) {
        return recetaDao.findById(idReceta);
    }

    public Receta buscarRecetaPorId(String idReceta) {
        return recetaDao.findById(idReceta).orElse(null);
    }
}