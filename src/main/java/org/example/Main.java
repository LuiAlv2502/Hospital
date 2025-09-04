package org.example;

import org.example.Control.LoginController;
import org.example.Control.MedicoController;
import org.example.Module.AbstractUser;
import org.example.Module.Dao.FarmaceuticoDao;
import org.example.Module.Dao.MedicoDao;
import org.example.Module.Dao.PacienteDao;
import org.example.Module.Dao.UsersDao;
import org.example.Module.wrappers.UsersWrapper;
import org.example.View.LoginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crear DAOs
        UsersDao usersDao = new UsersDao();
        PacienteDao pacienteDao = new PacienteDao();
        MedicoDao medicoDao = new MedicoDao();
        FarmaceuticoDao farmaceuticoDao = new FarmaceuticoDao();

        // Crear la vista de login
        LoginView loginView = new LoginView();

        // Crear el controlador de login
        new LoginController(loginView, usersDao);

        // Mostrar la ventana de login
        SwingUtilities.invokeLater(() -> loginView.setVisible(true));

        new MedicoController();
            }
        }
