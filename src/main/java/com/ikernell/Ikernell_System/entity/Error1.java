package com.ikernell.Ikernell_System.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "errores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Error1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoError estado;

    // 🔗 Relación con Actividad
    @ManyToOne
    @JoinColumn(name = "actividad_id", nullable = false)
    private Actividad actividad;

    // 👤 Usuario que reporta el error
    @ManyToOne
    @JoinColumn(name = "reportado_por", nullable = false)
    private Usuario reportadoPor;

    @Column(nullable = false)
    private Boolean activo = true;
}
