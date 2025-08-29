package org.example.Module.wrappers;

import jakarta.xml.bind.annotation.*;
import org.example.Module.Medico;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "medicosWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicosWrapper {

    @XmlElement(name = "medico")
    private List<Medico> medicos = new ArrayList<>();

    public MedicosWrapper() {
        this.medicos = new ArrayList<>();
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}