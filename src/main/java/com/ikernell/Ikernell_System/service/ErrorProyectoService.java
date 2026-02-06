package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.ErrorProyecto;
import com.ikernell.Ikernell_System.repository.ErrorProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorProyectoService {

    private final ErrorProyectoRepository repository;

    public ErrorProyectoService(ErrorProyectoRepository repository) {
        this.repository = repository;
    }

    public ErrorProyecto crear(ErrorProyecto error) {
        return repository.save(error);
    }

    public List<ErrorProyecto> listarActivos() {
        return repository.findByActivoTrue();
    }

    public Optional<ErrorProyecto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void desactivar(Long id) {
        ErrorProyecto error = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error no encontrado"));
        error.setActivo(false);
        repository.save(error);
    }
}
