package com.puce.controller;

import com.puce.entity.Libro;
import com.puce.service.LIbroService;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")

public class LibroController {
    @Autowired
    private LIbroService lIbroService;
    @GetMapping
    public List<Libro> leerLibros(){
        return lIbroService.mostrarLibros();
    }

    @PostMapping("/guardarLibro")
    public Libro guardarLibro(@RequestBody Libro libro){
        return lIbroService.guardarLibro(libro);

    }

    @PutMapping("/actualizarLibro/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libro){
        return lIbroService.actualizarLibro(libro, id);
    }

    @DeleteMapping("/eliminarLibro/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        lIbroService.eliminarLibro(id);
    }
}
