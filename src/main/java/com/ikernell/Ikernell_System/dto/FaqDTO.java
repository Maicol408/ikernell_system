package com.ikernell.Ikernell_System.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FaqDTO {

    private Long id;
    private String pregunta;
    private String respuesta;
    private LocalDate fechaCreacion;

    private Long creadoPorId;
    private String creadoPorNombre;
}
