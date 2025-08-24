package org.example.Module;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Admin extends AbstractUser{
    public Admin(String name, String password, String id) {
        super(name, password, "Admin", id);
    }
    public Admin() {
        super();
    }
}
