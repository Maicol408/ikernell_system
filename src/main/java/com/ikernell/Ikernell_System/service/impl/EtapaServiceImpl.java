package com.ikernell.Ikernell_System.service.impl;

import com.ikernell.Ikernell_System.entity.Etapa;
import com.ikernell.Ikernell_System.repository.EtapaRepository;
import com.ikernell.Ikernell_System.service.EtapaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtapaServiceImpl implements EtapaService {

    private final EtapaRepository etapaRepository;

    public EtapaServiceImpl(EtapaRepository etapaRepository) {
        this.etapaRepository = etapaRepository;
    }

    @Override
    public Etapa crearEtapa(Etapa etapa) {
        return etapaRepository.save(etapa);
    }

    @Override
    public List<Etapa> listarEtapas() {
        return etapaRepository.findAll();
    }

    @Override
    public Optional<Etapa> buscarPorId(Long id) {
        return etapaRepository.findById(id);
    }

    @Override
    public List<Etapa> listarPorProyecto(Long proyectoId) {
        return etapaRepository.findByProyectoId(proyectoId);
    }
}
