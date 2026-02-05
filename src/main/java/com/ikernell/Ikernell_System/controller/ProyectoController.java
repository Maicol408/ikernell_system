package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.create.ProyectoCreateDTO;
import com.ikernell.Ikernell_System.dto.ProyectoDTO;
import com.ikernell.Ikernell_System.entity.Proyecto;
import com.ikernell.Ikernell_System.entity.Usuario;
import com.ikernell.Ikernell_System.service.ProyectoService;
import com.ikernell.Ikernell_System.service.UsuarioService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;
    private final UsuarioService usuarioService;

    public ProyectoController(ProyectoService proyectoService,
                              UsuarioService usuarioService) {
        this.proyectoService = proyectoService;
        this.usuarioService = usuarioService;
    }

    // ✅ Crear proyecto
    @PostMapping
    public ResponseEntity<ProyectoDTO> crearProyecto(
            @RequestBody ProyectoCreateDTO dto) {

        Usuario lider = usuarioService.buscarPorId(dto.getLiderProyectoId())
                .orElseThrow(() -> new RuntimeException("Líder no encontrado"));

        Proyecto proyecto = MapperUtil.toEntity(dto, lider);
        Proyecto creado = proyectoService.crearProyecto(proyecto);

        return ResponseEntity.ok(
                MapperUtil.toDTO(creado)
        );
    }

    // ✅ Listar proyectos
    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> listarProyectos() {

        List<ProyectoDTO> proyectos = proyectoService.listarProyectos()
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(proyectos);
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> buscarPorId(@PathVariable Long id) {

        return proyectoService.buscarPorId(id)
                .map(MapperUtil::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
