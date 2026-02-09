package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.Interrupcion;
import com.ikernell.Ikernell_System.repository.InterrupcionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterrupcionService {

    private final InterrupcionRepository repository;

    public InterrupcionService(InterrupcionRepository repository) {
        this.repository = repository;
    }

    public Interrupcion crear(Interrupcion interrupcion) {
        return repository.save(interrupcion);
    }

    public List<Interrupcion> listarActivas() {
        return repository.findByActivoTrue();
    }

    public Optional<Interrupcion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void finalizar(Long id) {
        Interrupcion inter = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interrupción no encontrada"));

        inter.setFechaFin(java.time.LocalDateTime.now());
        repository.save(inter);
    }

    public void desactivar(Long id) {
        Interrupcion inter = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interrupción no encontrada"));

        inter.setActivo(false);
        repository.save(inter);
    }
}
