package com.ikernell.Ikernell_System.dto.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterrupcionCreateDTO {

    private String motivo;
    private String estado;

    private Long actividadId;
    private Long registradoPorId;
}
