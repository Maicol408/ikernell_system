package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.Interrupcion;
import com.ikernell.Ikernell_System.entity.EstadoInterrupcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterrupcionRepository
        extends JpaRepository<Interrupcion, Long> {

    List<Interrupcion> findByActivoTrue();

    List<Interrupcion> findByEstado(EstadoInterrupcion estado);

    List<Interrupcion> findByActividadId(Long actividadId);
}
