package com.proyectosjuan.libreria.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cliente")
@Data
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private Integer telefono;

    @Column(name = "estado_cuenta",nullable = false)
    private boolean estadoCuenta;

    @OneToMany(mappedBy = "cliente")
    List<PrestamoEntity> prestamos;

}
