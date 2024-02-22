package com.example.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> obtenerTodasLasMaterias() {
        return materiaService.obtenerTodasLasMaterias();
    }

    @GetMapping("/{id}")
    public Materia obtenerMateriaPorId(@PathVariable int id) {
        return materiaService.obtenerMateriaPorId(id);
    }

    @PostMapping
    public Materia crearMateria(@RequestBody Materia materia) {
        return materiaService.guardarMateria(materia);
    }

    @PutMapping("/{id}")
    public Materia actualizarMateria(@PathVariable int id, @RequestBody Materia materia) {
        materia.setId_materia(id);
        return materiaService.guardarMateria(materia);
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable int id) {
        materiaService.eliminarMateria(id);
    }
}
