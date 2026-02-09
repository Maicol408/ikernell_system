package com.ikernell.Ikernell_System.dto.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaqCreateDTO {

    private String pregunta;
    private String respuesta;
    private Long creadoPorId;
}
