package org.example.Module.Dao;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.Module.Farmaceutico;
import org.example.Module.wrappers.FarmaceuticosWrapper;

import java.io.File;
import java.util.List;

public class FarmaceuticoDao {

    private static final String FILE_PATH = "src/main/resources/farmaceuticos.xml";

    public FarmaceuticosWrapper loadFarmaceuticos() {
        try {
            JAXBContext context = JAXBContext.newInstance(FarmaceuticosWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return (FarmaceuticosWrapper) unmarshaller.unmarshal(file);
            } else {
                return new FarmaceuticosWrapper();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new FarmaceuticosWrapper();
        }
    }

    public void saveFarmaceuticos(FarmaceuticosWrapper wrapper) {
        try {
            JAXBContext context = JAXBContext.newInstance(FarmaceuticosWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFarmaceutico(Farmaceutico farmaceutico) {
        FarmaceuticosWrapper wrapper = loadFarmaceuticos();
        List<Farmaceutico> list = wrapper.getFarmaceuticos();

        boolean exists = list.stream().anyMatch(f -> f.getId().equals(farmaceutico.getId()));
        if (!exists) {
            list.add(farmaceutico);
            saveFarmaceuticos(wrapper);
            System.out.println("Farmacéutico guardado: " + farmaceutico.getId());
        } else {
            System.out.println("Farmacéutico con ID " + farmaceutico.getId() + " ya existe.");
        }
    }

    public boolean removeFarmaceuticoById(String id) {
        FarmaceuticosWrapper wrapper = loadFarmaceuticos();
        boolean removed = wrapper.getFarmaceuticos().removeIf(f -> f.getId().equals(id));
        if (removed) saveFarmaceuticos(wrapper);
        return removed;
    }

    public Farmaceutico searchFarmaceuticoById(String id) {
        return loadFarmaceuticos().getFarmaceuticos().stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}