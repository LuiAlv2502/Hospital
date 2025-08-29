package org.example.Module.Dao;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.Module.Paciente;
import org.example.Module.wrappers.PacientesWrapper;

import java.io.File;
import java.util.List;

public class PacienteDao {

    private static final String FILE_PATH = "src/main/resources/pacientes.xml";

    public PacientesWrapper loadPacientes() {
        try {
            JAXBContext context = JAXBContext.newInstance(PacientesWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return (PacientesWrapper) unmarshaller.unmarshal(file);
            } else {
                return new PacientesWrapper();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new PacientesWrapper();
        }
    }

    public void savePacientes(PacientesWrapper wrapper) {
        try {
            JAXBContext context = JAXBContext.newInstance(PacientesWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPaciente(Paciente paciente) {
        PacientesWrapper wrapper = loadPacientes();
        List<Paciente> list = wrapper.getPacientes();

        boolean exists = list.stream().anyMatch(p -> p.getId().equals(paciente.getId()));
        if (!exists) {
            list.add(paciente);
            savePacientes(wrapper);
            System.out.println("Paciente guardado: " + paciente.getId());
        } else {
            System.out.println("Paciente con ID " + paciente.getId() + " ya existe.");
        }
    }

    public boolean removePacienteById(String id) {
        PacientesWrapper wrapper = loadPacientes();
        boolean removed = wrapper.getPacientes().removeIf(p -> p.getId().equals(id));
        if (removed) savePacientes(wrapper);
        return removed;
    }

    public Paciente searchPacienteById(String id) {
        return loadPacientes().getPacientes().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}