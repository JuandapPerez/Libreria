package com.proyectosjuan.libreria.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "prestamo_libro")
@IdClass(PrestamoLibroId.class)
public class PrestamoLibroEntity {

    @Id
    private Integer idLibro;

    @Id
    private Integer idPrestamo;

}
