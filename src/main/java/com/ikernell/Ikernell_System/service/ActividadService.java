package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.Actividad;
import com.ikernell.Ikernell_System.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    // ✅ Crear actividad
    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    // ✅ Listar actividades
    public List<Actividad> listarActividades() {
        return actividadRepository.findAll();
    }

    // ✅ Buscar actividad por ID
    public Optional<Actividad> buscarPorId(Long id) {
        return actividadRepository.findById(id);
    }
}
