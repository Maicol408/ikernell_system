package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.InterrupcionDTO;
import com.ikernell.Ikernell_System.dto.create.InterrupcionCreateDTO;
import com.ikernell.Ikernell_System.entity.Actividad;
import com.ikernell.Ikernell_System.entity.Interrupcion;
import com.ikernell.Ikernell_System.entity.Usuario;
import com.ikernell.Ikernell_System.service.ActividadService;
import com.ikernell.Ikernell_System.service.InterrupcionService;
import com.ikernell.Ikernell_System.service.UsuarioService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interrupciones")
public class InterrupcionController {

    private final InterrupcionService interrupcionService;
    private final ActividadService actividadService;
    private final UsuarioService usuarioService;

    public InterrupcionController(
            InterrupcionService interrupcionService,
            ActividadService actividadService,
            UsuarioService usuarioService) {
        this.interrupcionService = interrupcionService;
        this.actividadService = actividadService;
        this.usuarioService = usuarioService;
    }

    // Crear interrupción
    @PostMapping
    public ResponseEntity<InterrupcionDTO> crear(
            @RequestBody InterrupcionCreateDTO dto) {

        Actividad actividad = actividadService.buscarPorId(dto.getActividadId())
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));

        Usuario usuario = usuarioService.buscarPorId(dto.getRegistradoPorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Interrupcion inter = MapperUtil.toEntity(dto, actividad, usuario);
        Interrupcion creada = interrupcionService.crear(inter);

        return ResponseEntity.ok(MapperUtil.toDTO(creada));
    }

    // Listar activas
    @GetMapping
    public ResponseEntity<List<InterrupcionDTO>> listar() {
        List<InterrupcionDTO> lista = interrupcionService.listarActivas()
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(lista);
    }

    // Finalizar interrupción
    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Void> finalizar(@PathVariable Long id) {
        interrupcionService.finalizar(id);
        return ResponseEntity.noContent().build();
    }
}
