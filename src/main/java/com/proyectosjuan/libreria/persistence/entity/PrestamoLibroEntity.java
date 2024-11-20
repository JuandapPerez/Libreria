package com.proyectosjuan.libreria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "prestamo_libro")
@IdClass(PrestamoLibroId.class)
public class PrestamoLibroEntity {

    @Id
    @Column(name = "id_libro")
    private Integer idLibro;

    @Id
    @Column(name = "id_prestamo")
    private Integer idPrestamo;

    @ManyToOne
    @JoinColumn(name = "id_prestamo",referencedColumnName = "id_prestamo", insertable = false, updatable = false)
    @JsonIgnore
    PrestamoEntity prestamo;


    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro", insertable = false, updatable = false)
    @JsonIgnore
    LibroEntity libro;


}
