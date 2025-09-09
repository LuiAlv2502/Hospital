package org.example.Control;

import org.example.Module.Paciente;
import org.example.Module.wrappers.PacientesWrapper;
import org.example.View.PacienteView;
import org.example.Module.Dao.PacienteDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacienteController {
    private PacienteView view;
    private PacienteDao dao;

    public PacienteController() {
        this.view = new PacienteView();
        this.dao = new PacienteDao();

        cargarPacientes();
        view.addListener(new ButtonListener());
    }

    public PacienteView getView() {
        return view;
    }

    private void cargarPacientes() {
        PacientesWrapper wrapper = dao.loadPacientes();
        for (Paciente p : wrapper.getPacientes()) {
            Object[] row = { p.getId(), p.getName(), p.getFechaNacimiento(), p.getTelefono() };
            view.modelAddRow(row);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Guardar paciente
            if (e.getSource().equals(view.getGuardarButton())) {
                String id = view.getCampoId();
                String nombre = view.getCampoNombre();
                String password = view.getCampoPassword();
                String fechaNacimiento = view.getCampoFechaNacimiento();
                String telefono = view.getCampoTelefono();

                if (id.isEmpty() || nombre.isEmpty() || password.isEmpty() || fechaNacimiento.isEmpty() || telefono.isEmpty()) {
                    view.mostrarError("Debe llenar todos los campos");
                    return;
                }

                Paciente paciente = new Paciente(nombre, password, id, fechaNacimiento, telefono);
                dao.addPaciente(paciente);

                Object[] row = { id, nombre, fechaNacimiento, telefono };
                view.modelAddRow(row);
                view.clearAllText();
            }

            // Borrar paciente
            else if (e.getSource().equals(view.getBorrarButton())) {
                int i = view.tableGetSelectedRow();
                if (i >= 0) {
                    String id = (String) view.getTablaPacientes().getValueAt(i, 0);

                    boolean removed = dao.removePacienteById(id);
                    if (removed) {
                        view.tableRemoveRow(i);
                    } else {
                        view.mostrarError("No se pudo eliminar el paciente con ID: " + id);
                    }
                } else {
                    view.mostrarError("Seleccione un paciente en la tabla");
                }
            }
        }
    }
}