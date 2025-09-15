package org.example.Control;

import org.example.Module.Receta;
import org.example.Module.Servicio.DespachoService;
import org.example.View.DespachoView;
import org.example.Module.Dao.RecetaDao;

import javax.swing.*;
import java.util.List;

public class DespachoController {
    private final DespachoView view;
    private final DespachoService service;
    private final RecetaDao recetaDao;

    public DespachoController(DespachoView view, DespachoService service, RecetaDao recetaDao) {
        this.view = view;
        this.service = service;
        this.recetaDao = recetaDao;

        // Cargar recetas en comboBox desde RecetaDao
        List<Receta> recetas = recetaDao.loadRecetas().getRecetas();
        for (Receta receta : recetas) {
            view.getComboRecetas().addItem(receta.getIdReceta());
        }

        initController();
    }

    private void initController() {
        view.getBtnIniciar().addActionListener(e -> iniciarDespacho());
        view.getBtnAlistar().addActionListener(e -> alistarReceta());
        view.getBtnEntregar().addActionListener(e -> entregarReceta());
    }

    private String getRecetaSeleccionada() {
        return (String) view.getComboRecetas().getSelectedItem();
    }

    private void iniciarDespacho() {
        String id = getRecetaSeleccionada();
        try {
            service.iniciarDespacho(id);
            log("Receta " + id + " puesta en estado 'proceso'.");
        } catch (Exception ex) {
            error(ex.getMessage());
        }
    }

    private void alistarReceta() {
        String id = getRecetaSeleccionada();
        try {
            service.alistarReceta(id);
            log("Receta " + id + " puesta en estado 'lista'.");
        } catch (Exception ex) {
            error(ex.getMessage());
        }
    }

    private void entregarReceta() {
        String id = getRecetaSeleccionada();
        try {
            service.entregarReceta(id);
            log("Receta " + id + " puesta en estado 'entregada'.");
        } catch (Exception ex) {
            error(ex.getMessage());
        }
    }

    private void log(String msg) {
        view.getAreaEstado().append(msg + "\n");
    }

    private void error(String msg) {
        JOptionPane.showMessageDialog(view, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}