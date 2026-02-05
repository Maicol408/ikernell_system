package com.ikernell.Ikernell_System.dto;

import com.ikernell.Ikernell_System.entity.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String identificacion;
    private Rol rol;
    private Boolean activo;

}

