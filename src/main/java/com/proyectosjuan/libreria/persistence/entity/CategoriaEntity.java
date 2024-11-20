package com.proyectosjuan.libreria.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;

    @Column(nullable = false)
    private String nombre_categoria;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    List<LibroEntity> libros;


}
