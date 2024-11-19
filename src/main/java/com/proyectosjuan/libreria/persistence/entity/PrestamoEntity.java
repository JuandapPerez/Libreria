package com.proyectosjuan.libreria.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "prestamo")
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrestamo;

    @Column(nullable = false)
    private Integer idClienteFk;

    @Column(nullable = false)
    private Date fechaInicioPrestamo;

    @Column(nullable = false)
    private Date fechaFinPrestamo;

}
