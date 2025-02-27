package com.generation.participant.service;

import com.generation.participant.models.Clase;
import com.generation.participant.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    // Crear una nueva clase
    public Clase crearClase(Clase clase) {
        return claseRepository.save(clase);
    }

    // Obtener todas las clases
    public List<Clase> obtenerTodasLasClases() {
        return claseRepository.findAll();
    }

    // Obtener clase por ID
    public Optional<Clase> obtenerClasePorId(Long id) {
        return claseRepository.findById(id);
    }

    // Actualizar clase
    public Clase actualizarClase(Clase clase) {
        return claseRepository.save(clase);
    }

    // Eliminar clase
    public void eliminarClase(Long id) {
        claseRepository.deleteById(id);
    }

    // Buscar clases por descripción exacta
    public List<Clase> buscarPorDescripcion(String descripcion) {
        return claseRepository.findByDescripcion(descripcion);
    }

    // Buscar clases por descripción parcial
    public List<Clase> buscarPorDescripcionParcial(String descripcion) {
        return claseRepository.findByDescripcionContaining(descripcion);
    }
}
