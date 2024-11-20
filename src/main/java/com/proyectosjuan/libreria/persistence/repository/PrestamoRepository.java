package com.proyectosjuan.libreria.persistence.repository;

import com.proyectosjuan.libreria.persistence.entity.LibroEntity;
import com.proyectosjuan.libreria.persistence.entity.PrestamoEntity;
import com.proyectosjuan.libreria.persistence.entity.PrestamoLibroEntity;
import com.proyectosjuan.libreria.persistence.entity.PrestamoLibroId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PrestamoRepository extends ListCrudRepository<PrestamoEntity, Integer> {

    @Query("SELECT p FROM PrestamoEntity p WHERE p.idCliente = :idCliente")
    List<PrestamoEntity> findPrestamosByClienteId(@Param("idCliente") Integer idCliente);


}
