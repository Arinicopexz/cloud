package com.puce.service;


import com.puce.entity.Libro;
import com.puce.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class LIbroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> mostrarLibros(){
        return libroRepository.findAll();
    }

    public Optional<Libro> buscarLibroporId(Long id){
        return libroRepository.findById(id);

    }

    public Libro guardarLibro(Libro libro){
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Libro libro, Long id){
        Libro libroEncontrado = buscarLibroporId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        libroEncontrado.setTitulo(libro.getTitulo());
        libroEncontrado.setNumeroPaginas(libro.getNumeroPaginas());
        libroEncontrado.setEditorial(libro.getEditorial());

        return libroRepository.save(libroEncontrado);
    }

    public void eliminarLibro(Long id){
        Libro libro = buscarLibroporId(id)
                .orElseThrow(()-> new RuntimeException("Libro no existe"));
        libroRepository.delete(libro);
    }
}
