package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.BibliotecaDocumentoDTO;
import com.ikernell.Ikernell_System.dto.create.BibliotecaDocumentoCreateDTO;
import com.ikernell.Ikernell_System.entity.BibliotecaDocumento;
import com.ikernell.Ikernell_System.entity.Usuario;
import com.ikernell.Ikernell_System.service.BibliotecaDocumentoService;
import com.ikernell.Ikernell_System.service.UsuarioService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    private final BibliotecaDocumentoService bibliotecaService;
    private final UsuarioService usuarioService;

    public BibliotecaController(
            BibliotecaDocumentoService bibliotecaService,
            UsuarioService usuarioService) {
        this.bibliotecaService = bibliotecaService;
        this.usuarioService = usuarioService;
    }

    // ✅ Subir documento
    @PostMapping
    public ResponseEntity<BibliotecaDocumentoDTO> crear(
            @RequestBody BibliotecaDocumentoCreateDTO dto) {

        Usuario usuario = usuarioService.buscarPorId(dto.getSubidoPorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        BibliotecaDocumento doc = MapperUtil.toEntity(dto, usuario);
        BibliotecaDocumento creado = bibliotecaService.guardar(doc);

        return ResponseEntity.ok(MapperUtil.toDTO(creado));
    }

    // ✅ Listar documentos activos
    @GetMapping
    public ResponseEntity<List<BibliotecaDocumentoDTO>> listar() {

        List<BibliotecaDocumentoDTO> docs = bibliotecaService.listarActivos()
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(docs);
    }

    // ✅ Borrado lógico
    @PutMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable Long id) {
        bibliotecaService.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
