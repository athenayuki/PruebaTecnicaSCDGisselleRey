package com.examen.backend_prueba.Repositorio;

import com.examen.backend_prueba.CancionEntidad; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository 
public interface CancionRepositorio extends JpaRepository<CancionEntidad, Integer> {

    CancionEntidad findByTituloCancion(String tituloCancion);

    List<CancionEntidad> findByCalificacionCancionGreaterThanEqual(double calificacion);

    List<CancionEntidad> findByFavoritaCancionTrue();

    List<CancionEntidad> findByArtistaNombreArtista(String nombreArtista);

    List<CancionEntidad> findByTituloCancionContainingIgnoreCase(String palabraClave);

}