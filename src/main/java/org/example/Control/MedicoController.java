package org.example.Control;
import org.example.Module.Medico;
import org.example.Module.wrappers.MedicosWrapper;
import org.example.View.MedicoView;
import org.example.Module.Dao.MedicoDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicoController{
    private MedicoView view;
    private MedicoDao dao;

    public MedicoController(){
        this.view = new MedicoView();
        this.dao = new MedicoDao();

        cargarMedicos();
        view.addListener(new ButtonListener());
    }
    public MedicoController(MedicoView view, MedicoDao dao){
        this.view = view;
        this.dao = dao;

        cargarMedicos();
        view.addListener(new ButtonListener());
    }


    private void cargarMedicos() {
        MedicosWrapper wrapper = dao.loadMedicos();
        for (Medico m : wrapper.getMedicos()) {
            Object[] row = { m.getId(), m.getName(), m.getEspecialidad() };
            view.modelAddRow(row);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // guardar medico
            if (e.getSource().equals(view.getGuardarButton())) {
                String id = view.getCampoId();
                String nombre = view.getCampoNombre();
                String especialidad = view.getCampoEspecialidad();

                if (id.isEmpty() || nombre.isEmpty() || especialidad.isEmpty()) {
                    view.mostrarError("Debe llenar todos los campos");
                    return;
                }

                // Crear y guardar médico en XML
                Medico medico = new Medico(nombre, id, id, especialidad);
                dao.addMedico(medico);

                // Mostrar en tabla
                Object[] row = { id, nombre, especialidad };
                view.modelAddRow(row);
                view.clearAllText();
            }

            // borrar medico
            else if (e.getSource().equals(view.getBorrarButton())) {
                int i = view.tableGetSelectedRow();
                if (i >= 0) {
                    String id = (String) view.getTablaDoctores().getValueAt(i, 0);

                    boolean removed = dao.removeMedicoById(id);
                    if (removed) {
                        view.tableRemoveRow(i);
                    } else {
                        view.mostrarError("No se pudo eliminar el médico con ID: " + id);
                    }
                } else {
                    view.mostrarError("Seleccione un médico en la tabla");
                }
            }
        }
    }
}