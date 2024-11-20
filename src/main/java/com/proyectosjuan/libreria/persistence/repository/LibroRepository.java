package com.proyectosjuan.libreria.persistence.repository;

import com.proyectosjuan.libreria.persistence.entity.LibroEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends ListCrudRepository<LibroEntity,Integer> {

    Optional<List<LibroEntity>> findAllByIdCategoria(Integer idCategoriaFx);
    Optional<List<LibroEntity>> findAllByIdAutor (Integer idAutorFk);

}
