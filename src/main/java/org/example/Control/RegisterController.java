package org.example.Control;

import org.example.Module.Dao.UsersDao;
import org.example.View.RegisterView;

public class RegisterController {
    private RegisterView view;
    private UsersDao UsersDao;

    public RegisterController(RegisterView view, UsersDao UsersDao) {
        this.view = view;
        this.UsersDao = UsersDao;
        initController();
    }

    private void initController() {
        view.getRegistrarseButton().addActionListener(_ -> {
            System.out.println("Botón Registrarse presionado");
            register();
        });


    }

    public void register() {
    }
}
