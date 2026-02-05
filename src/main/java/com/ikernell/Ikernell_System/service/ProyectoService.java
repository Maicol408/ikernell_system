package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.Proyecto;
import com.ikernell.Ikernell_System.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    // ✅ Crear proyecto
    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // ✅ Listar proyectos
    public List<Proyecto> listarProyectos() {
        return proyectoRepository.findAll();
    }

    // ✅ Buscar proyecto por ID
    public Optional<Proyecto> buscarPorId(Long id) {
        return proyectoRepository.findById(id);
    }
}
