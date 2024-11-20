package com.proyectosjuan.libreria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "libro")
@Data
public class LibroEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer idLibro;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(name = "año_publicacion",nullable = false)
    private Integer añoPublicacion;

    private Boolean disponibilidad;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "id_autor")
    private Integer idAutor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_autor",referencedColumnName = "id_autor", insertable = false, updatable = false)
    private AutorEntity autor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria", insertable = false, updatable = false)
    private CategoriaEntity categoria;

    @OneToMany(mappedBy = "libro")
    private List<PrestamoLibroEntity> prestamos;
}


