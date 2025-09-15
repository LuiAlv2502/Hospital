package org.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;


public class MedicoView extends JPanel {
    DefaultTableModel model;
    private JPanel JPanel;
    private JTextField campoId;
    private JTextField campoNombre;
    private JTextField campoEspecialidad;
    private JButton guardarButton;
    private JButton borrarButton;
    private JButton buscarButton;
    private JButton reporteButton;
    private JTextField campoBusqNombre;
    private JTable tablaDoctores;
    private JScrollPane scrollPane;

    public MedicoView() {
        setLayout(new BorderLayout()); // para organizar
        addComponents();
    }

    public void modelAddRow(Object[] objects){
        model.addRow(objects);
    }

    public void clearAllText(){
        campoId.setText("");
        campoNombre.setText("");
        campoEspecialidad.setText("");
    }

    public JButton getGuardarButton() { return guardarButton; }
    public JButton getBorrarButton() { return borrarButton; }
    public JButton getBuscarButton() { return buscarButton; }
    public JButton getReporteButton() { return reporteButton; }

    public void addListener(ActionListener al){
        guardarButton.addActionListener(al);
        borrarButton.addActionListener(al);
        buscarButton.addActionListener(al);
        reporteButton.addActionListener(al);
    }

    public String getCampoId() { return campoId.getText(); }
    public String getCampoNombre() { return campoNombre.getText(); }
    public String getCampoEspecialidad() { return campoEspecialidad.getText(); }
    public JTextField getCampoBusqNombre() { return campoBusqNombre; }
    public JTable getTablaDoctores() { return tablaDoctores; }
    public void setCampoId(String campoId) { this.campoId.setText(campoId); }
    public void setCampoNombre(String campoNombre){ this.campoNombre.setText(campoNombre); }
    public void setCampoEspecialidad(String campoEspecialidad){ this.campoEspecialidad.setText(campoEspecialidad); }

    private void addComponents(){
        createUIComponents();
        JPanel jPanelMedico = new JPanel();
        jPanelMedico.setLayout(null);

        Object[] columns = {"ID","Nombre","Especialidad"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tablaDoctores.setModel(model);

        // Labels
        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(20, 20, 80, 30);
        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(20, 60, 80, 30);
        JLabel labelEspecialidad = new JLabel("Especialidad:");
        labelEspecialidad.setBounds(20, 100, 80, 30);

        // Campos
        campoId = new JTextField();
        campoNombre = new JTextField();
        campoEspecialidad = new JTextField();
        campoId.setBounds(110, 20, 150, 30);
        campoNombre.setBounds(110, 60, 150, 30);
        campoEspecialidad.setBounds(110, 100, 150, 30);

        // Botones
        guardarButton = new JButton("Guardar");
        borrarButton = new JButton("Borrar");
        buscarButton = new JButton("Buscar");
        guardarButton.setBounds(300, 20, 100, 30);
        borrarButton.setBounds(300, 60, 100, 30);
        buscarButton.setBounds(300, 100, 100, 30);

        scrollPane.setBounds(20, 180, 850, 150);

        // Agregar labels y campos
        jPanelMedico.add(labelId);
        jPanelMedico.add(campoId);
        jPanelMedico.add(labelNombre);
        jPanelMedico.add(campoNombre);
        jPanelMedico.add(labelEspecialidad);
        jPanelMedico.add(campoEspecialidad);
        jPanelMedico.add(guardarButton);
        jPanelMedico.add(borrarButton);
        jPanelMedico.add(buscarButton);
        jPanelMedico.add(scrollPane);

        add(jPanelMedico, BorderLayout.CENTER);
    }

    private void createUIComponents() {
        tablaDoctores = new JTable();
        tablaDoctores.setRowHeight(30);
        scrollPane = new JScrollPane(tablaDoctores);
    }

    public int tableGetSelectedRow() {
        return tablaDoctores.getSelectedRow();
    }

    public void tableRemoveRow(int i) {
        model.removeRow(i);
    }

    public void mostrarError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}