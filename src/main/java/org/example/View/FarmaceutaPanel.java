package org.example.View;

import javax.swing.*;

public class FarmaceutaPanel extends JFrame {
    private DespachoView despachoView;

    public FarmaceutaPanel() {
        setTitle("Panel Farmacéutico");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JTabbedPane tabbedPane = new JTabbedPane();


        despachoView = new DespachoView();
        tabbedPane.addTab("Despacho", despachoView);



        add(tabbedPane);
        setVisible(true);
    }

    public DespachoView getDespachoPanel() {
        return despachoView;
    }
}

