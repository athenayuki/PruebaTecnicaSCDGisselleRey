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

    public void eliminarCancion(int id) {
        cancionRepositorio.deleteById(id);
    }

    public CancionEntidad actualizarCancion(int id, CancionEntidad cancionActualizada) {
        if (cancionRepositorio.existsById(id)) {
            cancionActualizada.setIdCancion(id);
            return cancionRepositorio.save(cancionActualizada);
        } else {
            throw new RuntimeException("Canción no encontrada con ID: " + id);
        }
    }



}
