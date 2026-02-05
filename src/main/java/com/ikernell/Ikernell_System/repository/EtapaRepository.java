package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtapaRepository extends JpaRepository<Etapa, Long> {

    List<Etapa> findByProyectoId(Long proyectoId);
}
