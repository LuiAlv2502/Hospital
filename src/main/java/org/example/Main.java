package org.example;

import org.example.Control.LoginController;
import org.example.Module.AbstractUser;
import org.example.Module.Admin;
import org.example.Module.wrappers.UsersWrapper;
import org.example.Module.Dao.UsersDao;
import org.example.View.LoginView;

public class Main {
    public static void main(String[] args) throws Exception {
        UsersDao usersDao = new UsersDao();
        LoginView loginView = new LoginView();
        new LoginController(loginView, usersDao);
        loginView.setVisible(true);
        //UsersDao dao = new UsersDao();
        //String filePath = "src/main/resources/users.xml";

        // Load users
        //UsersWrapper users = dao.loadUsers();

        // Add a user
        // newUser = new Admin("juan","123", "1234"); // Replace with your constructor
        //dao.addUser(newUser);

        // Save users
        //dao.saveUsers(users);
    }
}