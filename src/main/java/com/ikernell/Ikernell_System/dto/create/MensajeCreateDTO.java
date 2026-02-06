package com.ikernell.Ikernell_System.dto.create;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MensajeCreateDTO {

    private Long chatId;
    private Long remitenteId;
    private String contenido;

    // getters y setters
}
