package org.example.View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MedicoPanel extends JPanel {
    // Campos de texto
    public JTextField campoId = new JTextField(10);
    public JTextField campoNombre = new JTextField(10);
    public JTextField campoEspecialidad = new JTextField(10);

    // Botones
    public JButton guardarButton = new JButton("Guardar");
    public JButton borrarButton = new JButton("Borrar");
    public JButton buscarButton = new JButton("Buscar");

    // Tabla
    public JTable tablaDoctores;
    public DefaultTableModel tableModel;

    public MedicoPanel() {
        // Layout con rejilla flexible
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5); // márgenes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ID
        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; add(campoId, gbc);

        // Nombre
        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; add(campoNombre, gbc);

        // Especialidad
        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("Especialidad:"), gbc);
        gbc.gridx = 1; add(campoEspecialidad, gbc);

        // Botones
        gbc.gridx = 0; gbc.gridy = 3; add(guardarButton, gbc);
        gbc.gridx = 1; add(borrarButton, gbc);
        gbc.gridx = 2; add(buscarButton, gbc);

        // Tabla
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Especialidad"}, 0);
        tablaDoctores = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tablaDoctores);
        scrollPane.setPreferredSize(new Dimension(700, 200));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 3;
        add(scrollPane, gbc);
    }
}

