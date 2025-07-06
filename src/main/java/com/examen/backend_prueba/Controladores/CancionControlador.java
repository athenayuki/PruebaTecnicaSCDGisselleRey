package com.examen.backend_prueba.Controladores;


import java.util.List;
import java.util.Optional;
import com.examen.backend_prueba.CancionEntidad;
import com.examen.backend_prueba.Servicios.CancionServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/canciones")
public class CancionControlador {

 
    private final CancionServicio cancionServicio; 
    public CancionControlador(CancionServicio cancionServicio) {
        this.cancionServicio = cancionServicio;
    }

    @GetMapping
    public List<CancionEntidad> obtenerTodasLasCanciones() {
        return cancionServicio.obtenerTodasLasCanciones(); 
    }

 @GetMapping("/{id}")
    public ResponseEntity<CancionEntidad> obtenerCancionPorId(@PathVariable int id) {
        Optional<CancionEntidad> cancion = cancionServicio.obtenerCancionPorId(id);
        return cancion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CancionEntidad> crearCancion(@RequestBody CancionEntidad cancion) {
        CancionEntidad nuevaCancion = cancionServicio.guardarCancion(cancion); 
        return new ResponseEntity<>(nuevaCancion, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CancionEntidad> actualizarCancion(@PathVariable int id, @RequestBody CancionEntidad cancionDetalles) {
        CancionEntidad cancionActualizada = cancionServicio.actualizarCancion(id, cancionDetalles); 
        if (cancionActualizada != null) {
            return new ResponseEntity<>(cancionActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCancion(@PathVariable int id) {
        boolean eliminado = cancionServicio.eliminarCancion(id); 
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

}
