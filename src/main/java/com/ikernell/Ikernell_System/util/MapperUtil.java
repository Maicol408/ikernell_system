package com.ikernell.Ikernell_System.util;

import com.ikernell.Ikernell_System.dto.*;
import com.ikernell.Ikernell_System.dto.create.ActividadCreateDTO;
import com.ikernell.Ikernell_System.dto.create.EtapaCreateDTO;
import com.ikernell.Ikernell_System.dto.create.ProyectoCreateDTO;
import com.ikernell.Ikernell_System.entity.*;

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

}
