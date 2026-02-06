package com.ikernell.Ikernell_System.dto.create;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BibliotecaDocumentoCreateDTO {

    private String nombre;
    private String tipo;
    private String rutaArchivo;
    private String descripcion;
    private Long subidoPorId;
}
