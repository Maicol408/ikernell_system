package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.EtapaDTO;
import com.ikernell.Ikernell_System.dto.create.EtapaCreateDTO;
import com.ikernell.Ikernell_System.entity.Etapa;
import com.ikernell.Ikernell_System.entity.Proyecto;
import com.ikernell.Ikernell_System.service.EtapaService;
import com.ikernell.Ikernell_System.service.ProyectoService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etapas")
public class EtapaController {

    private final EtapaService etapaService;
    private final ProyectoService proyectoService;

    public EtapaController(EtapaService etapaService,
                           ProyectoService proyectoService) {
        this.etapaService = etapaService;
        this.proyectoService = proyectoService;
    }

    // ✅ Crear etapa
    @PostMapping
    public ResponseEntity<EtapaDTO> crearEtapa(
            @RequestBody EtapaCreateDTO dto) {

        Proyecto proyecto = proyectoService.buscarPorId(dto.getProyectoId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        Etapa etapa = MapperUtil.toEntity(dto, proyecto);
        Etapa creada = etapaService.crearEtapa(etapa);

        return ResponseEntity.ok(
                MapperUtil.toDTO(creada)
        );
    }

    // ✅ Listar etapas
    @GetMapping
    public ResponseEntity<List<EtapaDTO>> listarEtapas() {

        List<EtapaDTO> etapas = etapaService.listarEtapas()
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(etapas);
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<EtapaDTO> buscarPorId(@PathVariable Long id) {

        return etapaService.buscarPorId(id)
                .map(MapperUtil::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Listar etapas por proyecto
    @GetMapping("/proyecto/{proyectoId}")
    public ResponseEntity<List<EtapaDTO>> listarPorProyecto(
            @PathVariable Long proyectoId) {

        List<EtapaDTO> etapas = etapaService.listarPorProyecto(proyectoId)
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(etapas);
    }
}
