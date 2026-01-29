package com.ikernell.Ikernell_System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "interrupciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Interrupcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String motivo;

    @Column(length = 500)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoInterrupcion estado;

    @ManyToOne
    @JoinColumn(name = "actividad_id", nullable = false)
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "registrado_por", nullable = false)
    private Usuario registradoPor;

    @Column(nullable = false)
    private Boolean activo = true;
}
