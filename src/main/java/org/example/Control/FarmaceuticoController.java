package org.example.Control;

import org.example.Module.Dao.FarmaceuticoDao;
import org.example.Module.Farmaceutico;
import org.example.Module.wrappers.FarmaceuticosWrapper;
import org.example.View.FarmaceuticoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FarmaceuticoController implements ActionListener {

    private FarmaceuticoView view;
    private FarmaceuticoDao dao;

    public FarmaceuticoController(FarmaceuticoView view, FarmaceuticoDao dao) {
        this.view = view;
        this.dao = dao;

        // Cargar listeners
        this.view.addListener(this);

        // Cargar tabla al inicio
        cargarTabla();
    }

    private void cargarTabla() {
        FarmaceuticosWrapper wrapper = dao.loadFarmaceuticos();
        for (Farmaceutico f : wrapper.getFarmaceuticos()) {
            view.modelAddRow(new Object[]{
                    f.getId(),
                    f.getName(),
                    f.getPassword()
            });
        }
    }

    private void limpiarTabla() {
        while (view.getTablaFarmaceuticos().getRowCount() > 0) {
            ((javax.swing.table.DefaultTableModel) view.getTablaFarmaceuticos().getModel()).removeRow(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == view.getGuardarButton()) {
            String id = view.getCampoId();
            String nombre = view.getCampoNombre();
            String clave = view.getCampoClave();

            if (id.isEmpty() || nombre.isEmpty()) {
                view.mostrarError("ID y Nombre son obligatorios");
                return;
            }

            // Al crear un farmaceutico, la clave por defecto será igual al ID
            if (clave.isEmpty()) {
                clave = id;
            }

            Farmaceutico f = new Farmaceutico(nombre, clave, id);
            dao.addFarmaceutico(f);

            limpiarTabla();
            cargarTabla();
            view.clearAllText();
        }

        if (src == view.getBorrarButton()) {
            int row = view.tableGetSelectedRow();
            if (row >= 0) {
                String id = (String) view.getTablaFarmaceuticos().getValueAt(row, 0);
                dao.removeFarmaceuticoById(id);

                view.tableRemoveRow(row);
            } else {
                view.mostrarError("Seleccione un farmaceuta para borrar");
            }
        }

        if (src == view.getBuscarButton()) {
            String criterio = view.getCampoBusqNombre().getText();
            if (criterio.isEmpty()) {
                view.mostrarError("Ingrese un ID o nombre para buscar");
                return;
            }

            limpiarTabla();
            List<Farmaceutico> lista = dao.loadFarmaceuticos().getFarmaceuticos();
            for (Farmaceutico f : lista) {
                if (f.getId().equalsIgnoreCase(criterio) || f.getName().equalsIgnoreCase(criterio)) {
                    view.modelAddRow(new Object[]{f.getId(), f.getName(), f.getPassword()});
                }
            }
        }

        if (src == view.getReporteButton()) {
            limpiarTabla();
            cargarTabla();
        }
    }
}