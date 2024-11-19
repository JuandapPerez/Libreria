package com.proyectosjuan.libreria.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "libro")
@Data
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false)
    private Integer añoPublicacion;

    @Column(nullable = false)
    private Boolean disponibilidad;

    @Column(nullable = false, length = 50)
    private String descripcion;

    @Column(nullable = false)
    private Integer idCategoriaFx;

    @Column(nullable = false)
    private Integer idAutorFk;


}
