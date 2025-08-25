package org.example.Control;

import org.example.Module.AbstractUser;
import org.example.Module.Dao.UsersDao;
import org.example.Module.wrappers.UsersWrapper;
import org.example.View.LoginView;
import org.example.View.RegisterView;

import javax.swing.*;

public class LoginController {

    private LoginView view;
    private UsersDao UsersDao;

    public LoginController(LoginView view, UsersDao UsersDao) {
        this.view = view;
        this.UsersDao = UsersDao;
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
        UsersDao usersDao = new UsersDao();
        RegisterController registerController = new RegisterController(registerView, usersDao);
        registerView.setVisible(true);
        view.dispose();
        // cerrar login
    }

    private void login() {
        String username = view.getTxtName().getText();
        String password = new String(view.getTxtPassword().getPassword());

        try {
            UsersWrapper wrapper = UsersDao.loadUsers(); // carga todos los usuarios
            AbstractUser user = UsersDao.searchUserById(wrapper, username);
            System.out.println(wrapper);

            if (user != null && user.validatePassword(password)) {
                JOptionPane.showMessageDialog(view, "¡Inicio de sesión exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                view.dispose(); // cerrar login
                // Abrir la ventana principal o dashboard basado en el rol del usuario
                if (user.getRole().equals("admin")) {
                    // Abrir vista de admin
                    System.out.println("Abrir vista de admin");
                }else if (user.getRole().equals("Medico")) {
                        // Abrir vista de usuario
                        System.out.println("Abrir vista de usuario");
                } else if (user.getRole().equals("Paciente")) {
                        // Rol desconocido
                        JOptionPane.showMessageDialog(view, "Rol de usuario desconocido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

            } else {
                JOptionPane.showMessageDialog(view, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error al cargar usuarios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
