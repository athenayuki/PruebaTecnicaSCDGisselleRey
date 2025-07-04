package com.examen.backend_prueba;


import jakarta.persistence.Entity; 
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;



@Entity(name = "artista") 
@Table(name = "artistas") 
public class ArtistaEntidad { 
   
    @Id 
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "artista_seq_gen") // Usamos SEQUENCE y vinculamos a un generador
    @SequenceGenerator(
        name = "artista_seq_gen",                  // Nombre del generador en JPA
        sequenceName = "artistas_id_seq",          // Nombre de la secuencia en tu base de datos PostgreSQL
        initialValue = 1,                          // Valor inicial de la secuencia (opcional, por defecto es 1)
        allocationSize = 50          )              // Cantidad de IDs que JPA "reserva" en memoria para optimizar el rendimiento // tengo dudas si usar AUTO o IDENTITY
    private int idArtista; 

    @Column (name = "NOMBRE_ARTISTA", length = 200, 
            nullable = false, unique = false) 
    private String nombreArtista;

    @Column  (name = "FECHA_DEBUT", nullable = false) 
    private LocalDate fechaDebut; 

    @Column(name = "SEGU   IR_ARTISTA", nullable = false) 
    private boolean seguiRArtista; 





}
