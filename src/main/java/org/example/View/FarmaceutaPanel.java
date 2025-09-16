package org.example.View;

import javax.swing.*;

public class FarmaceutaPanel extends JFrame {
    private DespachoView despachoView;
    private RecetaView recetaView;

    public FarmaceutaPanel() {
        setTitle("Panel Farmacéutico");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        JTabbedPane tabbedPane = new JTabbedPane();


        despachoView = new DespachoView();
        recetaView = new RecetaView();
        tabbedPane.addTab("Despacho", despachoView);
        tabbedPane.addTab("Historial de Recetas",recetaView );

        dashboard dashboardView = new dashboard();
        new org.example.Control.DashboardController(dashboardView);
        tabbedPane.addTab("Indicadores", dashboardView);


        add(tabbedPane);
        setVisible(true);
    }

    public DespachoView getDespachoPanel() {
        return despachoView;
    }
    public RecetaView getRecetaView() {
        return recetaView;
    }
}
