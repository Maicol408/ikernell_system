package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.ErrorProyecto;
import com.ikernell.Ikernell_System.entity.EstadoError;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ErrorProyectoRepository
        extends JpaRepository<ErrorProyecto, Long> {

    List<ErrorProyecto> findByActivoTrue();

    List<ErrorProyecto> findByEstado(EstadoError estado);

    List<ErrorProyecto> findByActividadId(Long actividadId);
}
