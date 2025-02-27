package com.generation.participant.repository;

import com.generation.participant.models.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    // Encuentra participantes por ID de clase
    List<Participante> findByClaseId(Long claseId);
}
