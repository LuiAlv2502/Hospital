package org.example.Module;

public class Farmaceutico extends AbstractUser {
    public Farmaceutico(String name, String password, String id) {
        super(name, password, "Farmaceuta", id);
    }
}
