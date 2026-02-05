package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.EstadoProyecto;
import com.ikernell.Ikernell_System.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    List<Proyecto> findByEstado(EstadoProyecto estado);
    Optional<Proyecto> findByNombre(String nombre);
    List<Proyecto> findByActivoTrue();
    List<Proyecto> findByFechaInicioBetween(
            LocalDate fechaInicio,
            LocalDate fechaFin
    );



}
