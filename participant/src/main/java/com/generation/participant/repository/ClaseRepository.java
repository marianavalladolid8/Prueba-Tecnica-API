package com.generation.participant.repository;

import com.generation.participant.models.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {

    // Busca clase por nombre exacto
    List<Clase> findByDescripcion(String descripcion);

    // Busca clase por parte del nombre
    @Query("SELECT c FROM Clase c WHERE c.descripcion LIKE %:descripcion%")
    List<Clase> findByDescripcionContaining(@Param("descripcion") String descripcion);
}
