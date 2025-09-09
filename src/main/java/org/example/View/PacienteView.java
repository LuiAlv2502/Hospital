package org.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class PacienteView extends JPanel {
    private JTextField campoId;
    private JTextField campoNombre;
    private JPasswordField campoPassword;
    private JTextField campoFechaNacimiento;
    private JTextField campoTelefono;

    private JButton guardarButton;
    private JButton borrarButton;
    private JButton buscarButton;

    private JTable tablaPacientes;
    private DefaultTableModel tableModel;

    public PacienteView() {
        setLayout(new BorderLayout());

        // ==== Panel de formulario ====
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        formPanel.add(new JLabel("ID:"));
        campoId = new JTextField();
        formPanel.add(campoId);

        formPanel.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        formPanel.add(campoNombre);

        formPanel.add(new JLabel("Contraseña:"));
        campoPassword = new JPasswordField();
        formPanel.add(campoPassword);

        formPanel.add(new JLabel("Fecha de nacimiento:"));
        campoFechaNacimiento = new JTextField();
        formPanel.add(campoFechaNacimiento);

        formPanel.add(new JLabel("Teléfono:"));
        campoTelefono = new JTextField();
        formPanel.add(campoTelefono);

        add(formPanel, BorderLayout.NORTH);

        // ==== Botones ====
        JPanel buttonPanel = new JPanel();
        guardarButton = new JButton("Guardar");
        borrarButton = new JButton("Borrar");
        buscarButton = new JButton("Buscar");

        buttonPanel.add(guardarButton);
        buttonPanel.add(borrarButton);
        buttonPanel.add(buscarButton);

        add(buttonPanel, BorderLayout.CENTER);

        // ==== Tabla ====
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Fecha Nacimiento", "Teléfono"}, 0);
        tablaPacientes = new JTable(tableModel);
        add(new JScrollPane(tablaPacientes), BorderLayout.SOUTH);
    }

    // ==== Métodos auxiliares ====
    public String getCampoId() { return campoId.getText(); }
    public String getCampoNombre() { return campoNombre.getText(); }
    public String getCampoPassword() { return new String(campoPassword.getPassword()); }
    public String getCampoFechaNacimiento() { return campoFechaNacimiento.getText(); }
    public String getCampoTelefono() { return campoTelefono.getText(); }

    public void clearAllText() {
        campoId.setText("");
        campoNombre.setText("");
        campoPassword.setText("");
        campoFechaNacimiento.setText("");
        campoTelefono.setText("");
    }

    public JButton getGuardarButton() { return guardarButton; }
    public JButton getBorrarButton() { return borrarButton; }
    public JButton getBuscarButton() { return buscarButton; }

    public JTable getTablaPacientes() { return tablaPacientes; }

    public void modelAddRow(Object[] row) { tableModel.addRow(row); }
    public void tableRemoveRow(int index) { tableModel.removeRow(index); }
    public int tableGetSelectedRow() { return tablaPacientes.getSelectedRow(); }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void addListener(ActionListener listener) {
        guardarButton.addActionListener(listener);
        borrarButton.addActionListener(listener);
        buscarButton.addActionListener(listener);
    }
}