package com.ikernell.Ikernell_System.dto.create;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ProyectoCreateDTO {

    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private Long liderProyectoId;
}
