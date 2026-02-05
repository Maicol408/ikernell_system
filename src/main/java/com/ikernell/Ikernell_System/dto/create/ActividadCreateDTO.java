package com.ikernell.Ikernell_System.dto.create;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActividadCreateDTO {

    private String nombre;
    private String descripcion;
    private Long etapaId;
    private Long desarrolladorId;
}
