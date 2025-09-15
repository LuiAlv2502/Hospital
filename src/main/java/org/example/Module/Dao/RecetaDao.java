package org.example.Module.Dao;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.Module.Receta;
import org.example.Module.wrappers.RecetasWrapper;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecetaDao {

    private static final String FILE_PATH = "src/main/resources/recetas.xml";

    public RecetasWrapper loadRecetas() {
        try {
            JAXBContext context = JAXBContext.newInstance(RecetasWrapper.class, Receta.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return (RecetasWrapper) unmarshaller.unmarshal(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RecetasWrapper();
    }

    private void saveRecetas(RecetasWrapper wrapper) {
        try {
            JAXBContext context = JAXBContext.newInstance(RecetasWrapper.class, Receta.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // === CRUD escritura ===
    public Receta saveNew(Receta receta) {
        RecetasWrapper wrapper = loadRecetas();
        List<Receta> list = wrapper.getRecetas();

        if (receta.getIdReceta() == null || receta.getIdReceta().isEmpty()) {
            receta.setIdReceta("R-" + System.currentTimeMillis());
        }

        list.add(receta);
        saveRecetas(wrapper);
        return receta;
    }

    public void update(Receta receta) {
        RecetasWrapper wrapper = loadRecetas();
        List<Receta> list = wrapper.getRecetas();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdReceta().equals(receta.getIdReceta())) {
                list.set(i, receta);
                saveRecetas(wrapper);
                return;
            }
        }
    }

    // === Consultas ===
    public Optional<Receta> findById(String id) {
        return loadRecetas().getRecetas().stream()
                .filter(r -> r.getIdReceta().equalsIgnoreCase(id))
                .findFirst();
    }

    public List<Receta> findAll() {
        return loadRecetas().getRecetas();
    }

    public List<Receta> findByEstado(String estado) {
        return loadRecetas().getRecetas().stream()
                .filter(r -> r.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public List<Receta> findByPaciente(String pacienteId) {
        return loadRecetas().getRecetas().stream()
                .filter(r -> r.getPaciente() != null && r.getPaciente().getId().equals(pacienteId))
                .collect(Collectors.toList());
    }

    public Receta[] getAll() {
        List<Receta> list = loadRecetas().getRecetas();
        return list.toArray(new Receta[0]);
    }
}