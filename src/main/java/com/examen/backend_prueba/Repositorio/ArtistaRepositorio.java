package com.examen.backend_prueba.Repositorio;

import com.examen.backend_prueba.ArtistaEntidad; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ArtistaRepositorio extends JpaRepository<ArtistaEntidad, Integer> {

    ArtistaEntidad findByNombreArtista(String nombreArtista);

    List<ArtistaEntidad> findByFechaDebutBefore(LocalDate fecha);

    List<ArtistaEntidad> findBySeguirArtistaTrue();



}
