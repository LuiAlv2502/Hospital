package org.example.Control;

import org.example.Module.Receta;
import org.example.Module.Service.PrescripcionService;
import org.example.View.prescribir;

import java.time.LocalDate;

public class PrescripcionController {

    private final prescribir view;
    private final PrescripcionService service;
    private Receta recetaActual;

    public PrescripcionController(prescribir view, PrescripcionService service) {
        this.view = view;
        this.service = service;
        initController();
    }

    // Inicializar eventos
    private void initController() {
        view.getBtnBuscarPaciente().addActionListener(e -> buscarPaciente());
        view.getBtnAgregar().addActionListener(e -> agregarMedicamento());
        view.getBtnEliminar().addActionListener(e -> eliminarMedicamento());
        view.getBtnRegistrar().addActionListener(e -> registrarReceta());
    }

    private void buscarPaciente() {
        String idPaciente = view.getTxtPaciente().getText().trim();
        if (idPaciente.isEmpty()) {
            view.showMessage("Ingrese el ID del paciente");
            return;
        }

        try {
            recetaActual = service.iniciarReceta(idPaciente);
            view.setTableModel(recetaActual.getMedicamentos());
            view.showMessage("Receta iniciada para paciente: " + idPaciente);
        } catch (Exception ex) {
            view.showMessage("Error: " + ex.getMessage());
        }
    }

    private void agregarMedicamento() {
        if (recetaActual == null) {
            view.showMessage("Primero selecciona un paciente");
            return;
        }

        try {
            String codigo = view.getTxtMedicamento().getText().trim();
            int cantidad = Integer.parseInt(view.getTxtCantidad().getText().trim());
            String indicaciones = view.getTxtIndicaciones().getText().trim();
            int dias = Integer.parseInt(view.getTxtDias().getText().trim());

            service.agregarMedicamento(recetaActual.getIdReceta(), codigo, cantidad, indicaciones, dias);

            // refrescar tabla
            recetaActual = service.buscarRecetaPorId(recetaActual.getIdReceta());
            view.updateTable(recetaActual.getMedicamentos());

        } catch (NumberFormatException e) {
            view.showMessage("Cantidad y días deben ser números");
        } catch (Exception e) {
            view.showMessage("Error: " + e.getMessage());
        }
    }

    private void eliminarMedicamento() {
        if (recetaActual == null) {
            view.showMessage("Primero selecciona un paciente");
            return;
        }

        int fila = view.getTblMedicamentos().getSelectedRow();
        if (fila == -1) {
            view.showMessage("Seleccione un medicamento de la tabla");
            return;
        }

        String codigo = (String) view.getTblMedicamentos().getValueAt(fila, 0);

        try {
            service.eliminarMedicamento(recetaActual.getIdReceta(), codigo);

            recetaActual = service.buscarRecetaPorId(recetaActual.getIdReceta());
            view.updateTable(recetaActual.getMedicamentos());

            view.showMessage("Medicamento eliminado correctamente");
        } catch (Exception e) {
            view.showMessage("Error: " + e.getMessage());
        }
    }

    private void registrarReceta() {
        if (recetaActual == null) {
            view.showMessage("No hay receta iniciada");
            return;
        }

        try {
            LocalDate fechaRetiro = LocalDate.now().plusDays(2); // ejemplo de fecha de retiro
            service.registrarReceta(recetaActual.getIdReceta(), fechaRetiro);
            view.showMessage("Receta registrada correctamente");
        } catch (Exception e) {
            view.showMessage("Error: " + e.getMessage());
        }
    }
}