package com.ikernell.Ikernell_System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "biblioteca_documentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BibliotecaDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo; // PDF, DOCX, XLSX, etc.

    @Column(name = "ruta_archivo", nullable = false)
    private String rutaArchivo;

    @Column(length = 500)
    private String descripcion;

    @Column(name = "fecha_subida", nullable = false)
    private LocalDateTime fechaSubida;

    @ManyToOne
    @JoinColumn(name = "subido_por", nullable = false)
    private Usuario subidoPor;

    @Column(nullable = false)
    private Boolean activo = true;
}
