package com.ikernell.Ikernell_System.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(nullable = false, unique = true)
    private String identificacion;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String profesion;

    @Column(nullable = false)
    private String especialidad;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    /* ================= RELACIONES ================= */

    // Proyectos donde es líder
    @OneToMany(mappedBy = "liderProyecto")
    private List<Proyecto> proyectosLiderados;

    // Proyectos donde participa como desarrollador
    @ManyToMany(mappedBy = "desarrolladores")
    private List<Proyecto> proyectosAsignados;

    // Actividades asignadas
    @OneToMany(mappedBy = "desarrollador")
    private List<Actividad> actividades;

    // Interrupciones registradas
    @OneToMany(mappedBy = "registradoPor")
    private List<Interrupcion> interrupcionesRegistradas;

    // Errores reportados (si decides usar la entidad Error)
    @OneToMany(mappedBy = "reportadoPor")
    private List<Error1> erroresReportados;

    @Column(nullable = false)
    private Boolean activo = true;
}
