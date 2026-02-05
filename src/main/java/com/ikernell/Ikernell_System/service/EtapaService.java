package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.Etapa;

import java.util.List;
import java.util.Optional;

public interface EtapaService {

    Etapa crearEtapa(Etapa etapa);

    List<Etapa> listarEtapas();

    Optional<Etapa> buscarPorId(Long id);

    List<Etapa> listarPorProyecto(Long proyectoId);
}
