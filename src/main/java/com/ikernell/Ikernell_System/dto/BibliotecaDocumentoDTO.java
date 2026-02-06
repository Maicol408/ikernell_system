package com.ikernell.Ikernell_System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BibliotecaDocumentoDTO {

    private Long id;
    private String nombre;
    private String tipo;
    private String rutaArchivo;
    private String descripcion;
    private LocalDateTime fechaSubida;
    private Long subidoPorId;
    private String subidoPorNombre;
}
