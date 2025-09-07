package org.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class FarmaceuticoView extends JPanel {
    DefaultTableModel model;

    private JTextField campoId;
    private JTextField campoClave;
    private JTextField campoNombre;
    private JTextField campoBusqNombre;

    private JButton guardarButton;
    private JButton borrarButton;
    private JButton buscarButton;
    private JButton reporteButton;

    private JTable tablaFarmaceuticos;
    private JScrollPane scrollPane;

    public FarmaceuticoView() {
        setLayout(new BorderLayout());
        addComponents();
    }

    public void modelAddRow(Object[] objects) {
        model.addRow(objects);
    }

    public void clearAllText() {
        campoId.setText("");
        campoClave.setText("");
        campoNombre.setText("");
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
    public String getCampoClave() { return campoClave.getText(); }
    public String getCampoNombre() { return campoNombre.getText(); }
    public JTextField getCampoBusqNombre() { return campoBusqNombre; }
    public JTable getTablaFarmaceuticos() { return tablaFarmaceuticos; }

    public void setCampoId(String campoId) { this.campoId.setText(campoId); }
    public void setCampoClave(String campoClave) { this.campoClave.setText(campoClave); }
    public void setCampoNombre(String campoNombre) { this.campoNombre.setText(campoNombre); }

    private void addComponents() {
        createUIComponents();
        JPanel jPanelFarmaceutico = new JPanel();
        jPanelFarmaceutico.setLayout(null);

        // Columnas de la tabla
        Object[] columns = {"ID", "Clave", "Nombre"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tablaFarmaceuticos.setModel(model);

        // Campos de entrada
        campoId = new JTextField();
        campoClave = new JTextField();
        campoNombre = new JTextField();
        campoBusqNombre = new JTextField();

        // Botones
        guardarButton = new JButton("Guardar");
        borrarButton = new JButton("Borrar");
        buscarButton = new JButton("Buscar");
        reporteButton = new JButton("Reporte");

        // Posiciones
        campoId.setBounds(20, 20, 150, 30);
        campoClave.setBounds(20, 60, 150, 30);
        campoNombre.setBounds(20, 100, 150, 30);

        guardarButton.setBounds(200, 20, 100, 30);
        borrarButton.setBounds(200, 60, 100, 30);
        buscarButton.setBounds(200, 100, 100, 30);
        reporteButton.setBounds(200, 140, 100, 30);

        scrollPane.setBounds(20, 180, 850, 150);

        jPanelFarmaceutico.add(scrollPane);
        jPanelFarmaceutico.add(campoId);
        jPanelFarmaceutico.add(campoClave);
        jPanelFarmaceutico.add(campoNombre);
        jPanelFarmaceutico.add(guardarButton);
        jPanelFarmaceutico.add(borrarButton);
        jPanelFarmaceutico.add(buscarButton);
        jPanelFarmaceutico.add(reporteButton);

        add(jPanelFarmaceutico, BorderLayout.CENTER);
    }

    private void createUIComponents() {
        tablaFarmaceuticos = new JTable();
        tablaFarmaceuticos.setRowHeight(30);
        scrollPane = new JScrollPane(tablaFarmaceuticos);
    }

    public int tableGetSelectedRow() {
        return tablaFarmaceuticos.getSelectedRow();
    }

    public void tableRemoveRow(int i) {
        model.removeRow(i);
    }

    public void mostrarError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}