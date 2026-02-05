package com.ikernell.Ikernell_System.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ChatDTO {

    private Long id;
    private Long proyectoId;
    private LocalDateTime fechaCreacion;

}
