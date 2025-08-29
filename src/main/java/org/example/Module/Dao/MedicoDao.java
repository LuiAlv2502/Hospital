package org.example.Module.Dao;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.Module.Medico;
import org.example.Module.wrappers.MedicosWrapper;

import java.io.File;
import java.util.List;

public class MedicoDao {

    private static final String FILE_PATH = "src/main/resources/medicos.xml";

    public MedicosWrapper loadMedicos() {
        try {
            JAXBContext context = JAXBContext.newInstance(MedicosWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return (MedicosWrapper) unmarshaller.unmarshal(file);
            } else {
                return new MedicosWrapper();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new MedicosWrapper();
        }
    }


    public void saveMedicos(MedicosWrapper wrapper) {
        try {
            JAXBContext context = JAXBContext.newInstance(MedicosWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMedico(Medico medico) {
        MedicosWrapper wrapper = loadMedicos();
        List<Medico> list = wrapper.getMedicos();

        boolean exists = list.stream().anyMatch(m -> m.getId().equals(medico.getId()));
        if (!exists) {
            list.add(medico);
            saveMedicos(wrapper);
            System.out.println("Médico guardado: " + medico.getId());
        } else {
            System.out.println("Médico con ID " + medico.getId() + " ya existe.");
        }
    }

    public boolean removeMedicoById(String id) {
        MedicosWrapper wrapper = loadMedicos();
        boolean removed = wrapper.getMedicos().removeIf(m -> m.getId().equals(id));
        if (removed) saveMedicos(wrapper);
        return removed;
    }

    public Medico searchMedicoById(String id) {
        return loadMedicos().getMedicos().stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}