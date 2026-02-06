package com.ikernell.Ikernell_System.util;

import com.ikernell.Ikernell_System.dto.*;
import com.ikernell.Ikernell_System.dto.create.*;
import com.ikernell.Ikernell_System.entity.*;

import java.time.LocalDateTime;

public class MapperUtil {

    // ================= USUARIO =================
    public static Usuario toEntity(ActividadDTO.UsuarioCreateDTO dto) {
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setEmail(dto.getEmail());
        u.setIdentificacion(dto.getIdentificacion());
        u.setPassword(dto.getPassword());
        u.setRol(dto.getRol());
        u.setActivo(true);
        return u;
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setEmail(usuario.getEmail());
        dto.setIdentificacion(usuario.getIdentificacion());
        dto.setRol(usuario.getRol());
        dto.setActivo(usuario.getActivo());
        return dto;
    }

    // ================= PROYECTO =================
    public static Proyecto toEntity(ProyectoCreateDTO dto, Usuario lider) {
        Proyecto p = new Proyecto();
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setFechaInicio(dto.getFechaInicio());
        p.setLiderProyecto(lider);
        return p;
    }

    public static ProyectoDTO toDTO(Proyecto proyecto) {
        ProyectoDTO dto = new ProyectoDTO();
        dto.setId(proyecto.getId());
        dto.setNombre(proyecto.getNombre());
        dto.setDescripcion(proyecto.getDescripcion());
        dto.setEstado(proyecto.getEstado());
        dto.setFechaInicio(proyecto.getFechaInicio());
        dto.setFechaFin(proyecto.getFechaFin());
        dto.setLiderProyectoId(proyecto.getLiderProyecto().getId());
        return dto;
    }

    // ================= ACTIVIDAD =================
    public static Actividad toEntity(ActividadCreateDTO dto,
                                     Etapa etapa,
                                     Usuario desarrollador) {

        Actividad a = new Actividad();
        a.setNombre(dto.getNombre());
        a.setDescripcion(dto.getDescripcion());
        a.setEtapa(etapa);
        a.setDesarrollador(desarrollador);
        return a;
    }

    public static ActividadDTO toDTO(Actividad actividad) {
        ActividadDTO dto = new ActividadDTO();
        dto.setId(actividad.getId());
        dto.setNombre(actividad.getNombre());
        dto.setDescripcion(actividad.getDescripcion());
        dto.setEstado(actividad.getEstado());
        dto.setEtapaId(actividad.getEtapa().getId());
        dto.setDesarrolladorId(actividad.getDesarrollador().getId());
        return dto;
    }

    // ================= ETAPA =================
    public static Etapa toEntity(EtapaCreateDTO dto, Proyecto proyecto) {
        Etapa e = new Etapa();
        e.setNombre(dto.getNombre());
        e.setProyecto(proyecto);
        return e;
    }

    public static EtapaDTO toDTO(Etapa etapa) {
        EtapaDTO dto = new EtapaDTO();
        dto.setId(etapa.getId());
        dto.setNombre(etapa.getNombre());
        dto.setProyectoId(etapa.getProyecto().getId());
        return dto;
    }

    // ================= CHAT =================
    public static Chat toEntity(ChatCreateDTO dto, Proyecto proyecto) {
        Chat chat = new Chat();
        chat.setProyecto(proyecto);
        return chat;
    }
    public static ChatDTO toDTO(Chat chat) {
        ChatDTO dto = new ChatDTO();
        dto.setId(chat.getId());
        dto.setProyectoId(chat.getProyecto().getId());
        dto.setFechaCreacion(chat.getFechaCreacion());
        return dto;
    }

    // ================= MENSAJE =================
    public static Mensaje toEntity(
            MensajeCreateDTO dto,
            Chat chat,
            Usuario remitente) {

        Mensaje mensaje = new Mensaje();
        mensaje.setChat(chat);
        mensaje.setRemitente(remitente);
        mensaje.setContenido(dto.getContenido());
        return mensaje;
    }
    public static MensajeDTO toDTO(Mensaje mensaje) {
        MensajeDTO dto = new MensajeDTO();
        dto.setId(mensaje.getId());
        dto.setChatId(mensaje.getChat().getId());
        dto.setRemitenteId(mensaje.getRemitente().getId());
        dto.setContenido(mensaje.getContenido());
        dto.setFechaEnvio(mensaje.getFechaEnvio());
        return dto;
    }


    /* ================= BIBLIOTECA ================= */

    public static BibliotecaDocumento toEntity(
            BibliotecaDocumentoCreateDTO dto,
            Usuario usuario
    ) {
        return BibliotecaDocumento.builder()
                .nombre(dto.getNombre())
                .tipo(dto.getTipo())
                .rutaArchivo(dto.getRutaArchivo())
                .descripcion(dto.getDescripcion())
                .fechaSubida(LocalDateTime.now())
                .subidoPor(usuario)
                .activo(true)
                .build();
    }

    public static BibliotecaDocumentoDTO toDTO(BibliotecaDocumento doc) {
        BibliotecaDocumentoDTO dto = new BibliotecaDocumentoDTO();
        dto.setId(doc.getId());
        dto.setNombre(doc.getNombre());
        dto.setTipo(doc.getTipo());
        dto.setRutaArchivo(doc.getRutaArchivo());
        dto.setDescripcion(doc.getDescripcion());
        dto.setFechaSubida(doc.getFechaSubida());
        dto.setSubidoPorId(doc.getSubidoPor().getId());
        dto.setSubidoPorNombre(
                doc.getSubidoPor().getNombre() + " " + doc.getSubidoPor().getApellido()
        );
        return dto;
    }
    public static ErrorProyecto toEntity(
            ErrorProyectoCreateDTO dto,
            Actividad actividad,
            Usuario usuario
    ) {
        return ErrorProyecto.builder()
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .fecha(LocalDateTime.now())
                .estado(EstadoError.valueOf(dto.getEstado()))
                .actividad(actividad)
                .reportadoPor(usuario)
                .activo(true)
                .build();
    }

    public static ErrorProyectoDTO toDTO(ErrorProyecto error) {

        ErrorProyectoDTO dto = new ErrorProyectoDTO();
        dto.setId(error.getId());
        dto.setTitulo(error.getTitulo());
        dto.setDescripcion(error.getDescripcion());
        dto.setFecha(error.getFecha());
        dto.setEstado(error.getEstado().name());

        dto.setActividadId(error.getActividad().getId());
        dto.setActividadNombre(error.getActividad().getNombre());

        dto.setReportadoPorId(error.getReportadoPor().getId());
        dto.setReportadoPorNombre(
                error.getReportadoPor().getNombre() + " " +
                        error.getReportadoPor().getApellido()
        );

        return dto;
    }



}




