package org.example.View;

import org.example.Module.DetalleMedicamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class prescribir extends JPanel {

    // Campos de entrada
    private JTextField txtPaciente;
    private JTextField txtMedicamento;
    private JTextField txtCantidad;
    private JTextField txtIndicaciones;
    private JTextField txtDias;

    // Botones
    private JButton btnBuscarPaciente;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnRegistrar;

    // Tabla de medicamentos
    private JTable tblMedicamentos;
    private DefaultTableModel tableModel;

    public prescribir() {
        setLayout(new BorderLayout(10, 10));
        initComponents();
    }

    private void initComponents() {
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        // Campos de formulario
        txtPaciente = new JTextField();
        txtMedicamento = new JTextField();
        txtCantidad = new JTextField();
        txtIndicaciones = new JTextField();
        txtDias = new JTextField();

        formPanel.add(new JLabel("ID Paciente:"));
        formPanel.add(txtPaciente);

        formPanel.add(new JLabel("Código Medicamento:"));
        formPanel.add(txtMedicamento);

        formPanel.add(new JLabel("Cantidad:"));
        formPanel.add(txtCantidad);

        formPanel.add(new JLabel("Indicaciones:"));
        formPanel.add(txtIndicaciones);

        formPanel.add(new JLabel("Duración (días):"));
        formPanel.add(txtDias);

        // Botones
        btnBuscarPaciente = new JButton("Buscar Paciente");
        btnAgregar = new JButton("Agregar Medicamento");
        btnEliminar = new JButton("Eliminar Medicamento");
        btnRegistrar = new JButton("Registrar Receta");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnPanel.add(btnBuscarPaciente);
        btnPanel.add(btnAgregar);
        btnPanel.add(btnEliminar);

        // Tabla de medicamentos
        String[] columnNames = {"Código", "Cantidad", "Indicaciones", "Duración (días)"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tblMedicamentos = new JTable(tableModel);

        // Panel principal
        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(tblMedicamentos), BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(btnPanel, BorderLayout.CENTER);
        southPanel.add(btnRegistrar, BorderLayout.SOUTH);

        add(southPanel, BorderLayout.SOUTH);
    }

    // Métodos que usará el controlador
    public JTextField getTxtPaciente() { return txtPaciente; }
    public JTextField getTxtMedicamento() { return txtMedicamento; }
    public JTextField getTxtCantidad() { return txtCantidad; }
    public JTextField getTxtIndicaciones() { return txtIndicaciones; }
    public JTextField getTxtDias() { return txtDias; }

    public JButton getBtnBuscarPaciente() { return btnBuscarPaciente; }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnRegistrar() { return btnRegistrar; }

    public JTable getTblMedicamentos() { return tblMedicamentos; }

    public void setTableModel(List<DetalleMedicamento> items) {
        tableModel.setRowCount(0); // limpia tabla
        for (DetalleMedicamento d : items) {
            tableModel.addRow(new Object[]{
                    d.getCodigoMedicamento(),
                    d.getCantidad(),
                    d.getIndicaciones(),
                    d.getDuracionDias()
            });
        }
    }

    public void updateTable(List<DetalleMedicamento> items) {
        setTableModel(items);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }


}