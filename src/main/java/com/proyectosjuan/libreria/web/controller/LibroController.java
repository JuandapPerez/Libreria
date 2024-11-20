package com.proyectosjuan.libreria.web.controller;

import com.proyectosjuan.libreria.Service.LibroService;
import com.proyectosjuan.libreria.persistence.entity.LibroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libreria")
public class LibroController {

    private LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/libros")
    public ResponseEntity<List<LibroEntity>> getAllLibros(){
        return ResponseEntity.ok(this.libroService.getAllLibros());
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<LibroEntity> getLibroById(@PathVariable Integer id){
        return ResponseEntity.ok(this.libroService.getLibroById(id));
    }

    @PostMapping("/crearLibro")
    public ResponseEntity<LibroEntity> createLibro(@RequestBody LibroEntity libro){
        return ResponseEntity.ok(this.libroService.createLibro(libro));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<LibroEntity>> getAllLibrosByCategoria(@PathVariable Integer id){
        return ResponseEntity.ok(this.libroService.getLibroByIdCategoria(id));
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<List<LibroEntity>> getAllLibrosByAutor(@PathVariable Integer id){
        return ResponseEntity.ok(this.libroService.getLibroByIdAutor(id));
    }


}
