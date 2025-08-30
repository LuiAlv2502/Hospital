package org.example.Module;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlSeeAlso({Admin.class, Medico.class, Farmaceutico.class, Paciente.class})
public abstract class AbstractUser  {
    protected String name;
    protected String id;
    protected String password;
    protected String role;

    public AbstractUser() {
    }

    public AbstractUser(String name, String password, String role, String id) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {this.id = id;}


    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {this.password = password;}

    public String getRole() {
        return role;
    }
    public void setRole(String role) {this.role = role;}

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
