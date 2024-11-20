package com.proyectosjuan.libreria.web.controller;

import com.proyectosjuan.libreria.Service.PrestamoService;
import com.proyectosjuan.libreria.persistence.entity.LibroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/clientes/{idCliente}")
    public List<LibroEntity> getLibrosByClienteId(@PathVariable Integer idCliente) {
        return prestamoService.findLibrosByClienteId(idCliente);
    }

}
