// UsersWrapper.java
package org.example.Module.wrappers;

import jakarta.xml.bind.annotation.*;
import org.example.Module.*;


import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "usersWrapper")
@XmlAccessorType(XmlAccessType.FIELD) // IMPORTANTE: JAXB usa los campos
public class UsersWrapper {

    @XmlElements({
            @XmlElement(name = "admin", type = Admin.class),
            @XmlElement(name = "doctor", type = Medico.class),
            @XmlElement(name = "patient", type = Paciente.class),
            @XmlElement(name = "pharmacist", type = Farmaceutico.class)
    })
    private List<AbstractUser> users = new ArrayList<>();

    // Constructor
    public UsersWrapper() {
        this.users = new ArrayList<>();
    }

    // Getters/Setters sin anotación
    public List<AbstractUser> getUsers() {
        return users;
    }

    public void setUsers(List<AbstractUser> users) {
        this.users = users;
    }
}