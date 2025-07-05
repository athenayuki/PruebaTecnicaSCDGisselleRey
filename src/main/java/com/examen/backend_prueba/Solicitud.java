package com.examen.backend_prueba;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "SOLICITUDES")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

@ManyToOne
@JoinColumn(name = "ArtistaEntidad" )
private ArtistaEntidad artista;

}
