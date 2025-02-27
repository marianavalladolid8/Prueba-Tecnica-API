package com.generation.participant.service;

import com.generation.participant.models.Participante;
import com.generation.participant.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    // Crear un nuevo participante
    public Participante crearParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    // Obtener todos los participantes
    public List<Participante> obtenerTodosLosParticipantes() {
        return participanteRepository.findAll();
    }

    // Obtener participante por ID
    public Optional<Participante> obtenerParticipantePorId(Long id) {
        return participanteRepository.findById(id);
    }

    // Actualizar participante
    public Participante actualizarParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    // Eliminar participante
    public void eliminarParticipante(Long id) {
        participanteRepository.deleteById(id);
    }

    // Obtener participantes por ID de clase
    public List<Participante> obtenerParticipantesPorClaseId(Long claseId) {
        return participanteRepository.findByClaseId(claseId);
    }
}
