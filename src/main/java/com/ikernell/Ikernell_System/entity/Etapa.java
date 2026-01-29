package com.ikernell.Ikernell_System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "etapas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 300)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEtapa estado;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    @OneToMany(mappedBy = "etapa", cascade = CascadeType.ALL)
    private List<Actividad> actividades;

    @Column(nullable = false)
    private Boolean activo = true;
}