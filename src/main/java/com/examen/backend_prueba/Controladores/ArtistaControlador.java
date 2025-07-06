package com.examen.backend_prueba.Controladores;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.backend_prueba.ArtistaEntidad;
import com.examen.backend_prueba.Servicios.ArtistaServicio;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/artistas")
public class ArtistaControlador {

    private final ArtistaServicio artistaServicio;
    public ArtistaControlador(ArtistaServicio artistaServicio) {
        this.artistaServicio = artistaServicio;
    }

@GetMapping
public List<ArtistaEntidad> obtenerTodosLosArtistas() {
    return artistaServicio.obtenerTodosLosArtistas();
}

@PostMapping

public ArtistaEntidad crearArtista(@RequestBody ArtistaEntidad artista) {
    return artistaServicio.guardarArtista(artista);

}

@PutMapping
public ArtistaEntidad actualizarArtista(@RequestBody ArtistaEntidad artista) {
    return artistaServicio.actualizarArtista(artista.getIdArtista(), artista);
}

@DeleteMapping
public void eliminarArtista(int id) {
    artistaServicio.eliminarArtista(id);

}
}

