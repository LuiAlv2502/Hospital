package org.example.Control;

import org.example.Module.*;
import org.example.Module.Dao.*;
import org.example.Module.wrappers.UsersWrapper;
import org.example.View.*;

import javax.swing.*;

public class LoginController {

    private LoginView view;
    private UsersDao usersDao;

    public LoginController(LoginView view, UsersDao usersDao) {
        this.view = view;
        this.usersDao = usersDao;
        initController();
    }

    private void initController() {
        view.getBtnLogin().addActionListener(_ -> login());
        view.getRegistroLink().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openRegisterView();
            }
        });
    }

    private void openRegisterView() {
        RegisterView registerView = new RegisterView();

        // Instanciar DAOs específicos para el registro
        PacienteDao pacienteDao = new PacienteDao();
        MedicoDao medicoDao = new MedicoDao();
        FarmaceuticoDao farmaceuticoDao = new FarmaceuticoDao();

        // Crear el controlador del registro
        new RegisterController(
                registerView,
                usersDao,
                pacienteDao,
                medicoDao,
                farmaceuticoDao
        );

        registerView.setVisible(true);
        view.dispose();
    }

    private void login() {
        String username = view.getTxtName().getText();
        String password = new String(view.getTxtPassword().getPassword());
        PacienteDao pacienteDao = new PacienteDao();
        MedicoDao medicoDao = new MedicoDao();
        FarmaceuticoDao farmaceuticoDao = new FarmaceuticoDao();
        MedicamentoDao medicamentoDao = new MedicamentoDao();

        try {
            // Cargar todos los usuarios desde UsersDao
            UsersWrapper wrapper = usersDao.loadUsers();
            AbstractUser user = usersDao.searchUserById(wrapper, username);

            if (user != null && user.validatePassword(password)) {
                JOptionPane.showMessageDialog(view, "¡Inicio de sesión exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                view.dispose();

                // Abrir la ventana principal según el rol
                switch (user.getRole().toLowerCase()) {
                    case "admin":
                        AdminPanel adminPanel = new AdminPanel();
                        AdminControler adminControler = new AdminControler(
                                medicoDao,
                                farmaceuticoDao,
                                adminPanel.getFarmaceuticoPanel(), // Get the FarmaceuticoPanel
                                adminPanel.getMedicoPanel()         // Get the MedicoPanel
                        );
                        adminPanel.setVisible(true);
                        System.out.println("Abrir vista de admin");
                        break;
                    case "medico":
                        System.out.println("Abrir vista de médico");
                        MedicoPanel medicoPanel = new MedicoPanel();
                        org.example.Module.Service.PrescripcionService prescripcionController = new org.example.Module.Service.PrescripcionService(pacienteDao, medicoDao, new RecetaDao(), medicamentoDao);
                        panelMedicoController panelMedicoController = new panelMedicoController(medicoPanel.getPrescribir(), prescripcionController);
                        medicoPanel.setVisible(true);
                        break;
                    case "paciente":
                        System.out.println("Abrir vista de paciente");
                        break;
                    case "farmaceuta":
                        System.out.println("Abrir vista de farmacéutico");
                        break;
                    default:
                        JOptionPane.showMessageDialog(view, "Rol de usuario desconocido.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(view, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error al cargar usuarios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}