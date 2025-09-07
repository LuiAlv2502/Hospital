package org.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class FarmaceuticoPanel extends JPanel {
    DefaultTableModel model;

    private JTextField campoId;
    private JTextField campoNombre;
    private JTextField campoClave;
    private JButton guardarButton;
    private JButton borrarButton;
    private JButton buscarButton;
    private JButton reporteButton;
    private JTextField campoBusqNombre;
    private JTable tablaFarmaceuticos;
    private JScrollPane scrollPane;

    public FarmaceuticoPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(900, 400));

        createUIComponents();

        Object[] columns = {"ID", "Nombre", "Clave"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tablaFarmaceuticos.setModel(model);

        campoId = new JTextField();
        campoNombre = new JTextField();
        campoClave = new JTextField();
        campoBusqNombre = new JTextField();

        guardarButton = new JButton("Guardar");
        borrarButton = new JButton("Borrar");
        buscarButton = new JButton("Buscar");
        reporteButton = new JButton("Reporte");

        campoId.setBounds(20, 20, 100, 30);
        campoNombre.setBounds(20, 60, 150, 30);
        campoClave.setBounds(20, 100, 150, 30);
        campoBusqNombre.setBounds(20, 140, 150, 30);

        guardarButton.setBounds(200, 20, 100, 30);
        borrarButton.setBounds(200, 60, 100, 30);
        buscarButton.setBounds(200, 100, 100, 30);
        reporteButton.setBounds(200, 140, 100, 30);

        scrollPane.setBounds(20, 180, 850, 150);

        add(scrollPane);
        add(campoId);
        add(campoNombre);
        add(campoClave);
        add(campoBusqNombre);
        add(guardarButton);
        add(borrarButton);
        add(buscarButton);
        add(reporteButton);
    }

    private void createUIComponents() {
        tablaFarmaceuticos = new JTable();
        tablaFarmaceuticos.setRowHeight(30);
        scrollPane = new JScrollPane(tablaFarmaceuticos);
    }

    // Métodos auxiliares (igual que en la vista original)
    public void modelAddRow(Object[] objects) { model.addRow(objects); }
    public void clearAllText() {
        campoId.setText("");
        campoNombre.setText("");
        campoClave.setText("");
    }

    public JButton getGuardarButton() { return guardarButton; }
    public JButton getBorrarButton() { return borrarButton; }
    public JButton getBuscarButton() { return buscarButton; }
    public JButton getReporteButton() { return reporteButton; }

    public void addListener(ActionListener al) {
        guardarButton.addActionListener(al);
        borrarButton.addActionListener(al);
        buscarButton.addActionListener(al);
        reporteButton.addActionListener(al);
    }

    public String getCampoId() { return campoId.getText(); }
    public String getCampoNombre() { return campoNombre.getText(); }
    public String getCampoClave() { return campoClave.getText(); }
    public JTextField getCampoBusqNombre() { return campoBusqNombre; }
    public JTable getTablaFarmaceuticos() { return tablaFarmaceuticos; }

    public void setCampoId(String campoId) { this.campoId.setText(campoId); }
    public void setCampoNombre(String campoNombre) { this.campoNombre.setText(campoNombre); }
    public void setCampoClave(String campoClave) { this.campoClave.setText(campoClave); }

    public int tableGetSelectedRow() { return tablaFarmaceuticos.getSelectedRow(); }
    public void tableRemoveRow(int i) { model.removeRow(i); }

    public void mostrarError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
