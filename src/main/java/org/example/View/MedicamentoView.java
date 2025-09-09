package org.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class MedicamentoView extends JPanel {
    DefaultTableModel model;

    private JTextField campoCodigo;
    private JTextField campoNombre;
    private JTextField campoPresentacion;

    private JButton guardarButton;
    private JButton borrarButton;
    private JButton buscarButton;
    private JButton modificarButton;

    private JTextField campoBusq;
    private JTable tablaMedicamentos;
    private JScrollPane scrollPane;

    public MedicamentoView() {
        setLayout(new BorderLayout());
        addComponents();
    }

    // === Métodos auxiliares ===
    public void modelAddRow(Object[] objects){
        model.addRow(objects);
    }

    public void clearAllText(){
        campoCodigo.setText("");
        campoNombre.setText("");
        campoPresentacion.setText("");
    }

    public void clearTable(){
        model.setRowCount(0);
    }

    // === Getters de botones ===
    public JButton getGuardarButton() { return guardarButton; }
    public JButton getBorrarButton() { return borrarButton; }
    public JButton getBuscarButton() { return buscarButton; }
    public JButton getModificarButton() { return modificarButton; }

    // === Getters de campos ===
    public String getCampoCodigo() { return campoCodigo.getText(); }
    public String getCampoNombre() { return campoNombre.getText(); }
    public String getCampoPresentacion() { return campoPresentacion.getText(); }
    public JTextField getCampoBusq() { return campoBusq; }

    public JTable getTablaMedicamentos() { return tablaMedicamentos; }

    public void setCampoCodigo(String codigo) { campoCodigo.setText(codigo); }
    public void setCampoNombre(String nombre) { campoNombre.setText(nombre); }
    public void setCampoPresentacion(String presentacion) { campoPresentacion.setText(presentacion); }

    // === Listeners ===
    public void addListener(ActionListener al){
        guardarButton.addActionListener(al);
        borrarButton.addActionListener(al);
        buscarButton.addActionListener(al);
        modificarButton.addActionListener(al);
    }

    // === Componentes gráficos ===
    private void addComponents(){
        createUIComponents();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Object[] columns = {"Código","Nombre","Presentación"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tablaMedicamentos.setModel(model);

        campoCodigo = new JTextField();
        campoNombre = new JTextField();
        campoPresentacion = new JTextField();
        campoBusq = new JTextField();

        guardarButton = new JButton("Guardar");
        borrarButton = new JButton("Borrar");
        modificarButton = new JButton("Modificar");
        buscarButton = new JButton("Buscar");

        // === Ubicación ===
        campoCodigo.setBounds(20, 20, 150, 30);
        campoNombre.setBounds(20, 60, 150, 30);
        campoPresentacion.setBounds(20, 100, 150, 30);

        guardarButton.setBounds(200, 20, 100, 30);
        borrarButton.setBounds(200, 60, 100, 30);
        modificarButton.setBounds(200, 100, 100, 30);
        buscarButton.setBounds(200, 140, 100, 30);

        campoBusq.setBounds(320, 20, 200, 30);
        scrollPane.setBounds(20, 200, 850, 150);

        // === Añadir componentes ===
        panel.add(campoCodigo);
        panel.add(campoNombre);
        panel.add(campoPresentacion);
        panel.add(guardarButton);
        panel.add(borrarButton);
        panel.add(modificarButton);
        panel.add(buscarButton);
        panel.add(campoBusq);
        panel.add(scrollPane);

        add(panel, BorderLayout.CENTER);
    }

    private void createUIComponents() {
        tablaMedicamentos = new JTable();
        tablaMedicamentos.setRowHeight(30);
        scrollPane = new JScrollPane(tablaMedicamentos);
    }

    public int tableGetSelectedRow() {
        return tablaMedicamentos.getSelectedRow();
    }

    public void tableRemoveRow(int i) {
        model.removeRow(i);
    }

    public void mostrarError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}