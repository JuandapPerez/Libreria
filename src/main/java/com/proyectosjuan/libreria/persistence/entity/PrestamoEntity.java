package com.proyectosjuan.libreria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "prestamo")
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Integer idPrestamo;

    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "fecha_inicio_prestamo",nullable = false)
    private Date fechaInicioPrestamo;

    @Column(name = "fecha_fin_prestamo", nullable = false)
    private Date fechaFinPrestamo;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @JsonIgnore
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "prestamo")
    private List<PrestamoLibroEntity> prestamosLibros;

}
