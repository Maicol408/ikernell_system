package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.ActividadDTO;
import com.ikernell.Ikernell_System.dto.UsuarioDTO;
import com.ikernell.Ikernell_System.entity.Usuario;
import com.ikernell.Ikernell_System.service.UsuarioService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // ✅ Crear usuario
    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(
            @RequestBody ActividadDTO.UsuarioCreateDTO dto) {

        Usuario usuario = MapperUtil.toEntity(dto);
        Usuario usuarioCreado = usuarioService.crearUsuario(usuario);

        return ResponseEntity.ok(
                MapperUtil.toDTO(usuarioCreado)
        );
    }

    // ✅ Listar todos
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {

        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios()
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(usuarios);
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {

        return usuarioService.buscarPorId(id)
                .map(MapperUtil::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Desactivar usuario (borrado lógico)
    @PutMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarUsuario(@PathVariable Long id) {
        usuarioService.desactivarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
