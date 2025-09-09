package org.example.Module;
import org.example.Module.AbstractUser;
//De cada paciente se requiere su id, nombre, fecha de nacimiento y número
//telefónico. Esta funcionalidad sólo la podrá ejecutar un usuario tipo administrador.
public class Paciente extends AbstractUser{
    String fechaNacimiento;
    String telefono;
    public Paciente() {
        super();
    }
    public Paciente(String name, String password, String id, String fechaNacimiento, String telefono) {
        super(name, password, "Paciente", id);
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
