package org.example.Module;
import org.example.Module.AbstractUser;

public class Medico extends AbstractUser{
    public Medico() {
        super();
    }
    public Medico(String name, String password, String id, String especialidad) {
        super(name, password, "Medico", id);
        this.especialidad = especialidad;
    }
    String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }
}

