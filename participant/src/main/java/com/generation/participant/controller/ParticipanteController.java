package com.generation.participant.controller;

import com.generation.participant.models.Participante;
import com.generation.participant.service.ParticipanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    // Crear un nuevo participante
    @PostMapping
    public ResponseEntity<Participante> crearParticipante(@Valid @RequestBody Participante participante) {
        Participante nuevoParticipante = participanteService.crearParticipante(participante);
        return new ResponseEntity<>(nuevoParticipante, HttpStatus.CREATED);
    }

    // Obtener todos los participantes
    @GetMapping
    public ResponseEntity<List<Participante>> obtenerTodosLosParticipantes() {
        List<Participante> participantes = participanteService.obtenerTodosLosParticipantes();
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }

    // Obtener participante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Participante> obtenerParticipantePorId(@PathVariable Long id) {
        Optional<Participante> participante = participanteService.obtenerParticipantePorId(id);
        return participante.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener participantes por ID de clase
    @GetMapping("/clase/{claseId}")
    public ResponseEntity<List<Participante>> obtenerParticipantesPorClaseId(@PathVariable Long claseId) {
        List<Participante> participantes = participanteService.obtenerParticipantesPorClaseId(claseId);
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }

    // Actualizar participante
    @PutMapping("/{id}")
    public ResponseEntity<Participante> actualizarParticipante(@PathVariable Long id, @Valid @RequestBody Participante participante) {
        Optional<Participante> participanteExistente = participanteService.obtenerParticipantePorId(id);

        if (participanteExistente.isPresent()) {
            participante.setId(id);
            Participante participanteActualizado = participanteService.actualizarParticipante(participante);
            return new ResponseEntity<>(participanteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar participante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarParticipante(@PathVariable Long id) {
        Optional<Participante> participante = participanteService.obtenerParticipantePorId(id);

        if (participante.isPresent()) {
            participanteService.eliminarParticipante(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
