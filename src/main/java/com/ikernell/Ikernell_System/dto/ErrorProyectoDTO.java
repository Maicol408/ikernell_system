package com.ikernell.Ikernell_System.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorProyectoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fecha;
    private String estado;

    private Long actividadId;
    private String actividadNombre;

    private Long reportadoPorId;
    private String reportadoPorNombre;
}
