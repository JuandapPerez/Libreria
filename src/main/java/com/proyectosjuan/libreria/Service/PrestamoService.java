package com.proyectosjuan.libreria.Service;

import com.proyectosjuan.libreria.persistence.entity.*;
import com.proyectosjuan.libreria.persistence.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestamoService {


    private PrestamoRepository prestamoRepository;

    @Autowired
    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public List<LibroEntity> findLibrosByClienteId(Integer idCliente) {
        List<PrestamoEntity> prestamos = prestamoRepository.findPrestamosByClienteId(idCliente);
        return prestamos.stream()
                .flatMap(prestamo -> prestamo.getPrestamosLibros().stream())
                .map(PrestamoLibroEntity::getLibro)
                .collect(Collectors.toList());
    }


}
