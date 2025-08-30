package org.example.Control;

import org.example.Module.*;
import org.example.Module.Dao.*;
import org.example.View.LoginView;
import org.example.View.RegisterView;

import javax.swing.*;
import java.awt.*;

public class RegisterController {

    private RegisterView view;
    private UsersDao usersDao;
    private PacienteDao pacienteDao;
    private MedicoDao medicoDao;
    private FarmaceuticoDao farmaceuticoDao;

    public RegisterController(RegisterView view,
                              UsersDao usersDao,
                              PacienteDao pacienteDao,
                              MedicoDao medicoDao,
                              FarmaceuticoDao farmaceuticoDao) {
        this.view = view;
        this.usersDao = usersDao;
        this.pacienteDao = pacienteDao;
        this.medicoDao = medicoDao;
        this.farmaceuticoDao = farmaceuticoDao;

        initController();
    }

    private void initController() {
        view.getRegistrarseButton().addActionListener(_ -> register());
    }

    private void register() {
        String username = view.getNombreTextfield().getText();
        String id = view.getIdtextField().getText();
        String especialidad = view.getEspecialidadtextField().getText();
        String password1 = new String(view.getPasswordField1().getPassword());
        String password2 = new String(view.getPasswordField2().getPassword());
        String role = (String) view.getComboBoxRol();
        String fecha = view.getFecha().getText();

        if (!password1.equals(password2)) {
            JOptionPane.showMessageDialog(view, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar duplicado en UsersDao
        AbstractUser existingUser = usersDao.searchUserById(usersDao.loadUsers(), id);
        if (existingUser != null) {
            JOptionPane.showMessageDialog(view, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            AbstractUser newUser;

            switch (role) {
                case "Admin" -> {
                    newUser = new Admin(username, password1, id);
                }
                case "Medico" -> {
                    newUser = new Medico(username, password1, id, especialidad);
                    medicoDao.addMedico((Medico) newUser);  // Guardar en DAO específico
                }
                case "Paciente" -> {
                    newUser = new Paciente(username, password1, id, fecha, "1111");
                    pacienteDao.addPaciente((Paciente) newUser);  // Guardar en DAO específico
                }
                case "Farmaceutico" -> {
                    newUser = new Farmaceutico(username, password1, id);
                    farmaceuticoDao.addFarmaceutico((Farmaceutico) newUser);  // Guardar en DAO específico
                }
                default -> throw new IllegalStateException("Rol inesperado: " + role);
            }

            // Guardar en UsersDao para login
            usersDao.addUser(newUser);

            JOptionPane.showMessageDialog(view, "¡Registro exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
            LoginView loginView = new LoginView();
            new LoginController(loginView, usersDao);
            loginView.setVisible(true);


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error al registrar usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}