package com.examen.backend_prueba;

import java.time.LocalDate;
import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import java.util.Set;



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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArtista", nullable = false)
    private ArtistaEntidad artista;


      // Relación One-to-Many: Un artista puede tener muchas canciones.
    // 'mappedBy = "artista"' indica que la propiedad 'artista' en CancionEntidad es la dueña de la relación.
    // CascadeType.ALL significa que las operaciones (persistir, eliminar) se propagarán a las entidades relacionadas.
    // orphanRemoval = true es útil para eliminar canciones cuando se desvinculan de un artista.
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CancionEntidad> canciones = new HashSet<>(); // Usa Set para evitar duplicados, o List si el orden es importante.



}
