package org.example.Module.Dao;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.Marshaller;
import org.example.Module.wrappers.UsersWrapper;
import org.example.Module.AbstractUser;
import java.io.File;
import java.util.List;

public class UsersDao {

    private static final String FILE_PATH = "src/main/resources/users.xml";

    public UsersWrapper loadUsers() {
        try {
            JAXBContext context = JAXBContext.newInstance(UsersWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return (UsersWrapper) unmarshaller.unmarshal(file);
            } else {
                return new UsersWrapper(); // si no existe el archivo, devolvemos lista vacía
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new UsersWrapper();
        }
    }

    public void saveUsers(UsersWrapper users) {
        try {
            JAXBContext context = JAXBContext.newInstance(UsersWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AbstractUser searchUserById(UsersWrapper users, String id) {
        for (AbstractUser user : users.getUsers()) {
            if (user.getId().equals(id)) return user;
        }
        return null;
    }

    public void addUser(AbstractUser user) {
        UsersWrapper wrapper = loadUsers();
        List<AbstractUser> users = wrapper.getUsers();

        // Validar duplicado por ID
        boolean exists = users.stream()
                .anyMatch(u -> u.getId().equals(user.getId()));

        if (!exists) {
            users.add(user);
            saveUsers(wrapper);
            System.out.println("Usuario guardado correctamente: " + user.getId());
        } else {
            System.out.println("Usuario con ID " + user.getId() + " ya existe.");
        }
    }

    public boolean removeUserById(String id) {
        UsersWrapper wrapper = loadUsers();
        List<AbstractUser> list = wrapper.getUsers();
        boolean removed = list.removeIf(user -> user.getId().equals(id));

        if (removed) {
            saveUsers(wrapper);
        }
        return removed;
    }
}