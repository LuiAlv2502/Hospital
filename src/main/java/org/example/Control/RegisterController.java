package org.example.Control;

import org.example.Module.AbstractUser;
import org.example.Module.Dao.UsersDao;
import org.example.Module.wrappers.UsersWrapper;
import org.example.View.LoginView;
import org.example.View.RegisterView;

public class RegisterController {
    private RegisterView view;
    private UsersDao UsersDao;
    LoginView loginView;

    public RegisterController(RegisterView view, UsersDao UsersDao) {
        this.view = view;
        this.UsersDao = UsersDao;
        this.loginView = new LoginView();
        initController();
    }

    private void initController() {
        view.getRegistrarseButton().addActionListener(_ -> {
            System.out.println("Botón Registrarse presionado");
            register();
        });


    }

    public void register() {
        String username = view.getNombreTextfield().getText();
        String id = view.getIdtextField().getText();
        String especialidad = view.getEspecialidadtextField().getText();
        String password1 = new String(view.getPasswordField1().getPassword());
        String password2 = new String(view.getPasswordField2().getPassword());
        String role = (String) view.getComboBoxRol();
        String fecha = view.getFecha().getText();
        try {
            UsersWrapper wrapper = UsersDao.loadUsers(); // carga todos los usuarios
            AbstractUser user = UsersDao.searchUserById(wrapper, username);
            if (user == null) {
                if (password1.equals(password2)) {
                    AbstractUser newUser;
                    switch (role) {
                        case "Admin" -> newUser = new org.example.Module.Admin(username, password1, id);
                        case "Medico" -> newUser = new org.example.Module.Medico(username, password1, id, especialidad);
                        case "Paciente" -> newUser = new org.example.Module.Paciente(username, password1, id, fecha, "1111");
                        default -> throw new IllegalStateException("Unexpected value: " + role);
                    }
                    UsersDao.addUser(newUser);
                    System.out.println("Usuario registrado correctamente: " + username);
                    javax.swing.JOptionPane.showMessageDialog(view, "¡Registro exitoso!", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    view.dispose(); // cerrar registro
                    loginView.setVisible(true);

                } else {
                    javax.swing.JOptionPane.showMessageDialog(view, "Las contraseñas no coinciden", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(view, "El usuario ya existe", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
