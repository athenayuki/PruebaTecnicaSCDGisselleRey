package com.examen.backend_prueba;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;




@Entity(name = "cancion") 
@Table(name = "canciones") 

public class CancionEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancion_seq_gen") 
    @SequenceGenerator(
        name = "cancion_seq_gen",                  // Nombre del generador
        sequenceName = "canciones_id_seq",          // Nombre de la secuencia en la DB (PostgreSQL la creará o la buscará)
        initialValue = 1,                           // Valor inicial de la secuencia
        allocationSize = 50                         // Número de IDs que JPA pre-solicita (optimización)
    ) //tengo dudas si usar sequence AUTO o IDENTITY
    private int idCancion; 

    @Column(name = "TITULO_CANCION", length = 200, nullable = false, unique = false) 
    private String tituloCancion; 

    @Column(name = "CALIFICACIÓN_CANCION", nullable = false) 
    private double calificacionCancion; 

    @Column (name = "LANZAMIENTO_CANCION", nullable = false)
    private LocalDate lanzamientoCancion; 

    @Column(name = "FAVORITA_CANCIÓN", nullable = false)
    private boolean favoritaCancion; 
}
