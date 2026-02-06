package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.ErrorProyectoDTO;
import com.ikernell.Ikernell_System.dto.create.ErrorProyectoCreateDTO;
import com.ikernell.Ikernell_System.entity.Actividad;
import com.ikernell.Ikernell_System.entity.ErrorProyecto;
import com.ikernell.Ikernell_System.entity.EstadoError;
import com.ikernell.Ikernell_System.entity.Usuario;
import com.ikernell.Ikernell_System.service.ActividadService;
import com.ikernell.Ikernell_System.service.ErrorProyectoService;
import com.ikernell.Ikernell_System.service.UsuarioService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/errores")
public class ErrorProyectoController {

    private final ErrorProyectoService errorService;
    private final ActividadService actividadService;
    private final UsuarioService usuarioService;

    public ErrorProyectoController(
            ErrorProyectoService errorService,
            ActividadService actividadService,
            UsuarioService usuarioService) {
        this.errorService = errorService;
        this.actividadService = actividadService;
        this.usuarioService = usuarioService;
    }

    // ✅ Crear error
    @PostMapping
    public ResponseEntity<ErrorProyectoDTO> crear(
            @RequestBody ErrorProyectoCreateDTO dto) {

        Actividad actividad = actividadService.buscarPorId(dto.getActividadId())
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));

        Usuario usuario = usuarioService.buscarPorId(dto.getReportadoPorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        ErrorProyecto error = MapperUtil.toEntity(dto, actividad, usuario);
        ErrorProyecto creado = errorService.crear(error);

        return ResponseEntity.ok(MapperUtil.toDTO(creado));
    }

    // ✅ Listar errores activos
    @GetMapping
    public ResponseEntity<List<ErrorProyectoDTO>> listar() {

        List<ErrorProyectoDTO> errores = errorService.listarActivos()
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(errores);
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<ErrorProyectoDTO> buscar(@PathVariable Long id) {

        return errorService.buscarPorId(id)
                .map(MapperUtil::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Borrado lógico
    @PutMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable Long id) {
        errorService.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
