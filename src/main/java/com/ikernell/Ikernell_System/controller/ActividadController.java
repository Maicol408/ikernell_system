package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.create.ActividadCreateDTO;
import com.ikernell.Ikernell_System.dto.ActividadDTO;
import com.ikernell.Ikernell_System.entity.Actividad;
import com.ikernell.Ikernell_System.entity.Etapa;
import com.ikernell.Ikernell_System.entity.Usuario;
import com.ikernell.Ikernell_System.service.ActividadService;
import com.ikernell.Ikernell_System.service.EtapaService;
import com.ikernell.Ikernell_System.service.UsuarioService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    private final ActividadService actividadService;
    private final EtapaService etapaService;
    private final UsuarioService usuarioService;

    public ActividadController(
            ActividadService actividadService,
            EtapaService etapaService,
            UsuarioService usuarioService) {
        this.actividadService = actividadService;
        this.etapaService = etapaService;
        this.usuarioService = usuarioService;
    }

    // ✅ Crear actividad
    @PostMapping
    public ResponseEntity<ActividadDTO> crearActividad(
            @RequestBody ActividadCreateDTO dto) {

        Etapa etapa = etapaService.buscarPorId(dto.getEtapaId())
                .orElseThrow(() -> new RuntimeException("Etapa no encontrada"));

        Usuario desarrollador = usuarioService.buscarPorId(dto.getDesarrolladorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Actividad actividad = MapperUtil.toEntity(dto, etapa, desarrollador);
        Actividad creada = actividadService.crearActividad(actividad);

        return ResponseEntity.ok(
                MapperUtil.toDTO(creada)
        );
    }

    // ✅ Listar actividades
    @GetMapping
    public ResponseEntity<List<ActividadDTO>> listarActividades() {

        List<ActividadDTO> actividades = actividadService.listarActividades()
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(actividades);
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> buscarPorId(@PathVariable Long id) {

        return actividadService.buscarPorId(id)
                .map(MapperUtil::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
