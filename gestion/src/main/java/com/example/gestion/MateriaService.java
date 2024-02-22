package com.example.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> obtenerTodasLasMaterias() {
        return materiaRepository.findAll();
    }

    public Materia obtenerMateriaPorId(int id) {
        return materiaRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Materia guardarMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void eliminarMateria(int id) {
        materiaRepository.deleteById(id);
    }
}
