package com.proyectosjuan.libreria.Service;

import com.proyectosjuan.libreria.persistence.entity.LibroEntity;
import com.proyectosjuan.libreria.persistence.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<LibroEntity> getAllLibros() {
        return libroRepository.findAll();
    }

    public LibroEntity createLibro(LibroEntity libro) {
        return libroRepository.save(libro);
    }

    public LibroEntity deleteLibro(Integer id) {
        LibroEntity libro = libroRepository.findById(id).orElse(null);
        if (libro != null) {
            libroRepository.deleteById(id);
        }
        return libro;
    }

    public LibroEntity getLibroById(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public LibroEntity updateLibro(LibroEntity libro) {
        return libroRepository.save(libro);
    }

    public List<LibroEntity> getLibroByIdCategoria(Integer id) {
        return libroRepository.findAllByIdCategoria(id).orElse(null);
    }

    public List<LibroEntity> getLibroByIdAutor(Integer id) {
        return libroRepository.findAllByIdAutor(id).orElse(null);
    }


}
