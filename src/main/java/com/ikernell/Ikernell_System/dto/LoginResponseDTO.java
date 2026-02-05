package com.ikernell.Ikernell_System.dto;

import com.ikernell.Ikernell_System.entity.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private String username;
    private Rol rol;
    private Boolean autenticado;


}
