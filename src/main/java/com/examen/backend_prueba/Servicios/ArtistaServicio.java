package com.examen.backend_prueba.Servicios;


import org.springframework.stereotype.Service;
import com.examen.backend_prueba.Repositorio.ArtistaRepositorio;
import com.examen.backend_prueba.ArtistaEntidad; 
import java.util.List; 
import java.util.Optional; 

@Service
public class ArtistaServicio {

    private final ArtistaRepositorio artistaRepositorio; 

    
    public ArtistaServicio(ArtistaRepositorio artistaRepositorio) {
        this.artistaRepositorio = artistaRepositorio;
    }

   
    public ArtistaEntidad guardarArtista(ArtistaEntidad artista) {
        return artistaRepositorio.save(artista);
    }

    public List<ArtistaEntidad> obtenerTodosLosArtistas() {
        return artistaRepositorio.findAll();
    }

    public Optional<ArtistaEntidad> obtenerArtistaPorId(int id) {
        return artistaRepositorio.findById(id);
    }
    public void eliminarArtista(int id) {
        artistaRepositorio.deleteById(id);
    }
    public ArtistaEntidad actualizarArtista(int id, ArtistaEntidad artistaActualizado) { //IA
        if (artistaRepositorio.existsById(id)) {
            artistaActualizado.setIdArtista(id);
            return artistaRepositorio.save(artistaActualizado);
        } else {
            throw new RuntimeException("Artista no encontrado con ID: " + id);
        }
    }

   
}