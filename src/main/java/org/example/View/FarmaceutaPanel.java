package org.example.View;

import javax.swing.*;

public class FarmaceutaPanel extends JFrame {
    private DespachoView despachoView;
    // Puedes agregar más paneles aquí si lo necesitas

    public FarmaceutaPanel() {
        setTitle("Panel Farmacéutico");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creamos el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregamos la pestaña principal de despacho
        despachoView = new DespachoView();
        tabbedPane.addTab("Despacho", despachoView);

        // Puedes agregar más pestañas aquí si lo necesitas

        add(tabbedPane);
        setVisible(true);
    }

    public DespachoView getDespachoPanel() {
        return despachoView;
    }
}

