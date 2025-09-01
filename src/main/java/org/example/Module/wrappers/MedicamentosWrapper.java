package org.example.Module.wrappers;

import jakarta.xml.bind.annotation.*;
import org.example.Module.Medicamento;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "medicamentosWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicamentosWrapper {

    @XmlElement(name = "medicamento")
    private List<Medicamento> medicamentos = new ArrayList<>();

    public MedicamentosWrapper() {
        this.medicamentos = new ArrayList<>();
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}