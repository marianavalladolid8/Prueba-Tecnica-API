package com.generation.participant.controller;

import com.generation.participant.models.Clase;
import com.generation.participant.service.ClaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    // Crear una nueva clase
    @PostMapping
    public ResponseEntity<Clase> crearClase(@Valid @RequestBody Clase clase) {
        Clase nuevaClase = claseService.crearClase(clase);
        return new ResponseEntity<>(nuevaClase, HttpStatus.CREATED);
    }

    // Obtenemos todas las clases
    @GetMapping
    public ResponseEntity<List<Clase>> obtenerTodasLasClases(
            @RequestParam(required = false) String nombre) {

        List<Clase> clases;

        if (nombre != null && !nombre.isEmpty()) {
            // Buscar por nombre o parte del nombre
            clases = claseService.buscarPorDescripcionParcial(nombre);
        } else {
            // Obtener todas las clases
            clases = claseService.obtenerTodasLasClases();
        }

        return new ResponseEntity<>(clases, HttpStatus.OK);
    }

    // Obtener clase por ID
    @GetMapping("/{id}")
    public ResponseEntity<Clase> obtenerClasePorId(@PathVariable Long id) {
        Optional<Clase> clase = claseService.obtenerClasePorId(id);
        return clase.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar clase
    @PutMapping("/{id}")
    public ResponseEntity<Clase> actualizarClase(@PathVariable Long id, @Valid @RequestBody Clase clase) {
        Optional<Clase> claseExistente = claseService.obtenerClasePorId(id);

        if (claseExistente.isPresent()) {
            clase.setId(id);
            Clase claseActualizada = claseService.actualizarClase(clase);
            return new ResponseEntity<>(claseActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar clase
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClase(@PathVariable Long id) {
        Optional<Clase> clase = claseService.obtenerClasePorId(id);

        if (clase.isPresent()) {
            claseService.eliminarClase(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
