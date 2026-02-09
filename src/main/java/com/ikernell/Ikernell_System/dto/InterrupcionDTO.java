package com.ikernell.Ikernell_System.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InterrupcionDTO {

    private Long id;
    private String motivo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado;

    private Long actividadId;
    private String actividadNombre;

    private Long registradoPorId;
    private String registradoPorNombre;
}
