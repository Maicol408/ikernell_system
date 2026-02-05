package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    // 🔎 Buscar actividades por proyecto (si lo necesitas)
    List<Actividad> findByEtapaProyectoId(Long proyectoId);

    // 🔎 Buscar actividades por desarrollador
    List<Actividad> findByDesarrolladorId(Long desarrolladorId);
}
