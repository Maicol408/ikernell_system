package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.FaqDTO;
import com.ikernell.Ikernell_System.dto.create.FaqCreateDTO;
import com.ikernell.Ikernell_System.entity.Faq;
import com.ikernell.Ikernell_System.entity.Usuario;
import com.ikernell.Ikernell_System.service.FaqService;
import com.ikernell.Ikernell_System.service.UsuarioService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faq")
public class FaqController {

    private final FaqService faqService;
    private final UsuarioService usuarioService;

    public FaqController(
            FaqService faqService,
            UsuarioService usuarioService) {
        this.faqService = faqService;
        this.usuarioService = usuarioService;
    }

    // ✅ Crear FAQ
    @PostMapping
    public ResponseEntity<FaqDTO> crear(
            @RequestBody FaqCreateDTO dto) {

        Usuario usuario = usuarioService.buscarPorId(dto.getCreadoPorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Faq faq = MapperUtil.toEntity(dto, usuario);
        Faq creada = faqService.crear(faq);

        return ResponseEntity.ok(
                MapperUtil.toDTO(creada)
        );
    }

    // ✅ Listar FAQs activas
    @GetMapping
    public ResponseEntity<List<FaqDTO>> listar() {

        List<FaqDTO> lista = faqService.listarActivas()
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(lista);
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<FaqDTO> buscar(@PathVariable Long id) {

        return faqService.buscarPorId(id)
                .map(MapperUtil::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Borrado lógico
    @PutMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable Long id) {
        faqService.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
