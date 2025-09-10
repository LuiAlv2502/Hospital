package org.example.Control;

import org.example.Module.Medicamento;
import org.example.Module.Dao.MedicamentosDao;
import org.example.View.MedicamentoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MedicamentosController {
    private MedicamentoView view;
    private MedicamentosDao dao;

    public MedicamentosController() {
        this.view = new MedicamentoView();
        this.dao = new MedicamentosDao();

        cargarMedicamentos();
        view.addListener(new ButtonListener());
    }

    public MedicamentoView getView() {
        return view;
    }

    // === Cargar medicamentos en la tabla ===
    private void cargarMedicamentos() {
        List<Medicamento> medicamentos = dao.getAll();
        for (Medicamento m : medicamentos) {
            Object[] row = { m.getCodigo(), m.getNombre(), m.getPresentacion() };
            view.modelAddRow(row);
        }
    }

    // === Manejo de botones ===
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Guardar medicamento
            if (e.getSource().equals(view.getGuardarButton())) {
                String codigo = view.getCampoCodigo();
                String nombre = view.getCampoNombre();
                String presentacion = view.getCampoPresentacion();

                if (codigo.isEmpty() || nombre.isEmpty() || presentacion.isEmpty()) {
                    view.mostrarError("Debe llenar todos los campos");
                    return;
                }

                // Crear y guardar medicamento
                Medicamento medicamento = new Medicamento(codigo, nombre, presentacion);
                dao.add(medicamento);

                // Agregar a la tabla
                Object[] row = { codigo, nombre, presentacion };
                view.modelAddRow(row);
                view.clearAllText();
            }

            // Borrar medicamento
            else if (e.getSource().equals(view.getBorrarButton())) {
                int i = view.tableGetSelectedRow();
                if (i >= 0) {
                    String codigo = (String) view.getTablaMedicamentos().getValueAt(i, 0);

                    boolean removed = dao.eliminarPorCodigo(codigo);
                    if (removed) {
                        view.tableRemoveRow(i);
                    } else {
                        view.mostrarError("No se pudo eliminar el medicamento con código: " + codigo);
                    }
                } else {
                    view.mostrarError("Seleccione un medicamento en la tabla");
                }
            }

            // Buscar medicamento por código o nombre
            else if (e.getSource().equals(view.getBuscarButton())) {
                String busqueda = view.getCampoBusq().getText();
                view.clearTable();

                if (busqueda.isEmpty()) {
                    cargarMedicamentos();
                } else {
                    // Primero intentar buscar por código
                    dao.buscarPorCodigo(busqueda).ifPresent(m -> {
                        Object[] row = { m.getCodigo(), m.getNombre(), m.getPresentacion() };
                        view.modelAddRow(row);
                    });

                    // Buscar por nombre
                    List<Medicamento> encontrados = dao.buscarPorNombre(busqueda);
                    for (Medicamento m : encontrados) {
                        Object[] row = { m.getCodigo(), m.getNombre(), m.getPresentacion() };
                        view.modelAddRow(row);
                    }
                }
            }
        }
    }
}