package com.examen.backend_prueba.Servicios;

import org.springframework.stereotype.Service;
import com.examen.backend_prueba.Repositorio.CancionRepositorio;
import com.examen.backend_prueba.CancionEntidad;
import java.util.List;
import java.util.Optional;

@Service
public class CancionServicio {
private final CancionRepositorio cancionRepositorio;

    public CancionServicio(CancionRepositorio cancionRepositorio) {
        this.cancionRepositorio = cancionRepositorio;
    }

    public CancionEntidad guardarCancion(CancionEntidad cancion) {
        return cancionRepositorio.save(cancion);
    }

    public List<CancionEntidad> obtenerTodasLasCanciones() {
        return cancionRepositorio.findAll();
    }

    public Optional<CancionEntidad> obtenerCancionPorId(int id) {
        return cancionRepositorio.findById(id);
    }


    public CancionEntidad actualizarCancion(int id, CancionEntidad cancionDetalles) {
        Optional<CancionEntidad> cancionExistenteOptional = cancionRepositorio.findById(id);

        if (cancionExistenteOptional.isPresent()) {
            CancionEntidad cancionExistente = cancionExistenteOptional.get();

            cancionExistente.setTituloCancion(cancionDetalles.getTituloCancion());
            cancionExistente.setCalificacionCancion(cancionDetalles.getCalificacionCancion());
            cancionExistente.setLanzamientoCancion(cancionDetalles.getLanzamientoCancion());
            cancionExistente.setFavoritaCancion(cancionDetalles.isFavoritaCancion());
          
            if (cancionDetalles.getArtista() != null) {
                cancionExistente.setArtista(cancionDetalles.getArtista());
            }
            return cancionRepositorio.save(cancionExistente);
        } else {
            return null; 
        }
    }

     public boolean eliminarCancion(int id) {
        
        if (cancionRepositorio.existsById(id)) {
            cancionRepositorio.deleteById(id);
            return true; 
        }
        return false; 
    }



}
