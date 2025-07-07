package com.examen.backend_prueba.Controladores;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.examen.backend_prueba.ArtistaEntidad;
import com.examen.backend_prueba.Servicios.ArtistaServicio;
import java.util.Optional;
import java.util.List;


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

    @GetMapping("/{id}") 
    public ResponseEntity<ArtistaEntidad> obtenerArtistaPorId(@PathVariable int id) {
        Optional<ArtistaEntidad> artista = artistaServicio.obtenerArtistaPorId(id);
        return artista.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PostMapping
    public ArtistaEntidad crearArtista(@RequestBody ArtistaEntidad artista) {
    return artistaServicio.guardarArtista(artista);
}
 
    @PutMapping("/{id}") 
    public ResponseEntity<ArtistaEntidad> actualizarArtista(
            @PathVariable int id, @RequestBody ArtistaEntidad artistaDetalles) { 

        ArtistaEntidad artistaActualizado = artistaServicio.actualizarArtista(id, artistaDetalles);
        if (artistaActualizado != null) {
            return new ResponseEntity<>(artistaActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArtista(@PathVariable int id) {
        boolean eliminado = artistaServicio.eliminarArtista(id); 
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
}

