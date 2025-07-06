package com.examen.backend_prueba.Controladores;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.backend_prueba.ArtistaEntidad;
import com.examen.backend_prueba.Servicios.ArtistaServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}") // <--- Asegúrate de tener esto exactamente así
    public ResponseEntity<ArtistaEntidad> obtenerArtistaPorId(@PathVariable int id) {
        Optional<ArtistaEntidad> artista = artistaServicio.obtenerArtistaPorId(id);
        return artista.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



@PostMapping
public ArtistaEntidad crearArtista(@RequestBody ArtistaEntidad artista) {
    return artistaServicio.guardarArtista(artista);

}
 // BLOQUE CON IA
    @PutMapping("/{id}") // <--- MUY IMPORTANTE: Se espera el ID en la URL
    public ResponseEntity<ArtistaEntidad> actualizarArtista(
            @PathVariable int id, // <--- Captura el ID de la URL
            @RequestBody ArtistaEntidad artistaDetalles) { // <--- Captura el cuerpo de la solicitud

        ArtistaEntidad artistaActualizado = artistaServicio.actualizarArtista(id, artistaDetalles);
        if (artistaActualizado != null) {
            return new ResponseEntity<>(artistaActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si el artista no se encuentra para actualizar
        }
    }

@DeleteMapping("/{id}")

public void eliminarArtista(int id) {
    artistaServicio.eliminarArtista(id);

}
}

