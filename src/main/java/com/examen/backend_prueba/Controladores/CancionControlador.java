package com.examen.backend_prueba.Controladores;


import java.util.List;
import com.examen.backend_prueba.CancionEntidad;
import com.examen.backend_prueba.Servicios.CancionServicio; 
import org.springframework.web.bind.annotation.GetMapping;
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


}
