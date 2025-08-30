package org.example.Module.wrappers;

import jakarta.xml.bind.annotation.*;
import org.example.Module.Paciente;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "pacientesWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class PacientesWrapper {

    @XmlElement(name = "paciente")
    private List<Paciente> pacientes = new ArrayList<>();

    public PacientesWrapper() {
        this.pacientes = new ArrayList<>();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}