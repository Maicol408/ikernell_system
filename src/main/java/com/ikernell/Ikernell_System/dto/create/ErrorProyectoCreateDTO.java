package com.ikernell.Ikernell_System.dto.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorProyectoCreateDTO {

    private String titulo;
    private String descripcion;
    private String estado;

    private Long actividadId;
    private Long reportadoPorId;
}
