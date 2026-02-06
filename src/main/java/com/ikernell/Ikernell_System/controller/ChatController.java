package com.ikernell.Ikernell_System.controller;

import com.ikernell.Ikernell_System.dto.ChatDTO;
import com.ikernell.Ikernell_System.dto.MensajeDTO;
import com.ikernell.Ikernell_System.dto.create.ChatCreateDTO;
import com.ikernell.Ikernell_System.dto.create.MensajeCreateDTO;
import com.ikernell.Ikernell_System.entity.Chat;
import com.ikernell.Ikernell_System.entity.Mensaje;
import com.ikernell.Ikernell_System.entity.Proyecto;
import com.ikernell.Ikernell_System.entity.Usuario;
import com.ikernell.Ikernell_System.service.ChatService;
import com.ikernell.Ikernell_System.service.MensajeService;
import com.ikernell.Ikernell_System.service.ProyectoService;
import com.ikernell.Ikernell_System.service.UsuarioService;
import com.ikernell.Ikernell_System.util.MapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;
    private final MensajeService mensajeService;
    private final ProyectoService proyectoService;
    private final UsuarioService usuarioService;

    public ChatController(ChatService chatService,
                          MensajeService mensajeService,
                          ProyectoService proyectoService,
                          UsuarioService usuarioService) {
        this.chatService = chatService;
        this.mensajeService = mensajeService;
        this.proyectoService = proyectoService;
        this.usuarioService = usuarioService;
    }

    // ✅ Crear chat para un proyecto
    @PostMapping
    public ResponseEntity<ChatDTO> crearChat(
            @RequestBody ChatCreateDTO dto) {

        Proyecto proyecto = proyectoService.buscarPorId(dto.getProyectoId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        Chat chat = MapperUtil.toEntity(dto, proyecto);
        Chat creado = chatService.crearChat(chat);

        return ResponseEntity.ok(
                MapperUtil.toDTO(creado)
        );
    }

    // ✅ Obtener chat por proyecto
    @GetMapping("/proyecto/{proyectoId}")
    public ResponseEntity<ChatDTO> obtenerPorProyecto(
            @PathVariable Long proyectoId) {

        return chatService.buscarPorProyecto(proyectoId)
                .map(MapperUtil::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Enviar mensaje
    @PostMapping("/mensajes")
    public ResponseEntity<MensajeDTO> enviarMensaje(
            @RequestBody MensajeCreateDTO dto) {

        Chat chat = chatService.buscarPorId(dto.getChatId())
                .orElseThrow(() -> new RuntimeException("Chat no encontrado"));

        Usuario remitente = usuarioService.buscarPorId(dto.getRemitenteId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Mensaje mensaje = MapperUtil.toEntity(dto, chat, remitente);
        Mensaje enviado = mensajeService.enviarMensaje(mensaje);

        return ResponseEntity.ok(
                MapperUtil.toDTO(enviado)
        );
    }

    // ✅ Listar mensajes del chat
    @GetMapping("/{chatId}/mensajes")
    public ResponseEntity<List<MensajeDTO>> listarMensajes(
            @PathVariable Long chatId) {

        List<MensajeDTO> mensajes = mensajeService.listarPorChat(chatId)
                .stream()
                .map(MapperUtil::toDTO)
                .toList();

        return ResponseEntity.ok(mensajes);
    }
}
