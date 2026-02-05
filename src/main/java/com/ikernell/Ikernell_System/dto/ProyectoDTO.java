package com.ikernell.Ikernell_System.dto;

import com.ikernell.Ikernell_System.entity.EstadoProyecto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProyectoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private EstadoProyecto estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long liderProyectoId;

}
