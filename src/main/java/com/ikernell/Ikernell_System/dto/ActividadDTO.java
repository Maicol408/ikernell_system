package com.ikernell.Ikernell_System.dto;

import com.ikernell.Ikernell_System.entity.EstadoActividad;
import com.ikernell.Ikernell_System.entity.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActividadDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private EstadoActividad estado;
    private Long etapaId;
    private Long desarrolladorId;

    @Getter
    @Setter
    public static class UsuarioCreateDTO {

        private String nombre;
        private String apellido;
        private String email;
        private String identificacion;
        private String password;
        private Rol rol;
    }
}