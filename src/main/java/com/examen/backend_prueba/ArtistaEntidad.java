package com.examen.backend_prueba;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import jakarta.persistence.CascadeType;
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


// --- Relación OneToMany ---
    // Un artista puede tener muchas canciones
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // - mappedBy: Indica el campo en la entidad "muchos" (CancionEntidad) que es el dueño de la relación.
    //             En CancionEntidad, necesitaremos un campo 'artista' de tipo ArtistaEntidad.
    // - cascade: Define cómo las operaciones (persist, merge, remove, etc.) se propagan a las entidades relacionadas.
    //            CascadeType.ALL significa que si persistes o eliminas un Artista, sus canciones asociadas también serán afectadas.
    // - fetch: Define la estrategia de carga. FetchType.LAZY (por defecto) significa que las canciones no se cargarán
    //          de la base de datos hasta que se accedan. FetchType.EAGER cargaría las canciones junto con el artista.
    private Set<CancionEntidad> canciones = new HashSet<>(); // Inicializa la colección para evitar NullPointerExceptions


}
