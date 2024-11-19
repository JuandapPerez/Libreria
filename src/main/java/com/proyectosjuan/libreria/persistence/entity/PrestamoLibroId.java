package com.proyectosjuan.libreria.persistence.entity;


import java.io.Serializable;
import java.util.Objects;

public class PrestamoLibroId implements Serializable {

    private Integer idLibro;
    private Integer idPrestamo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrestamoLibroId that = (PrestamoLibroId) o;
        return Objects.equals(idLibro, that.idLibro) && Objects.equals(idPrestamo, that.idPrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLibro, idPrestamo);
    }
}
