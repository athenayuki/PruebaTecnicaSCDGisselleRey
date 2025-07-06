package com.examen.backend_prueba.Controladores;


import java.util.List;
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
        // Aquí se llamaría al servicio para obtener todas las canciones
        return cancionServicio.obtenerTodasLasCanciones(); // Retorna una lista vacía como ejemplo
    }

    // 1. Crear Canción (POST)
    @PostMapping
    public ResponseEntity<CancionEntidad> crearCancion(@RequestBody CancionEntidad cancion) {
        CancionEntidad nuevaCancion = cancionServicio.guardarCancion(cancion); // Asume que tienes un método guardarCancion en tu servicio
        return new ResponseEntity<>(nuevaCancion, HttpStatus.CREATED);
    }

    // 2. Actualizar Canción (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<CancionEntidad> actualizarCancion(@PathVariable int id, @RequestBody CancionEntidad cancionDetalles) {
        CancionEntidad cancionActualizada = cancionServicio.actualizarCancion(id, cancionDetalles); // Asume que tienes un método actualizarCancion en tu servicio
        if (cancionActualizada != null) {
            return new ResponseEntity<>(cancionActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si la canción no se encuentra para actualizar
        }
    }

    // 3. Eliminar Canción (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCancion(@PathVariable int id) {
        boolean eliminado = cancionServicio.eliminarCancion(id); // Asume que tienes un método eliminarCancion en tu servicio
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content para eliminación exitosa sin cuerpo de respuesta
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si la canción no se encuentra para eliminar
        }
    }
    

}
