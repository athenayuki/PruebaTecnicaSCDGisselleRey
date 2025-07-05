package com.examen.backend_prueba;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import java.util.Set;
import java.util.HashSet;
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

    @Column(name = "SEGUIR_ARTISTA", nullable = false) 
    private boolean seguirArtista; 


    @OneToMany(mappedBy = "artista")
    private Set<CancionEntidad> canciones = new HashSet<>(); 

    public ArtistaEntidad() {
    }

    public ArtistaEntidad(String nombreArtista, LocalDate fechaDebut, boolean seguiRArtista) {
        this.nombreArtista = nombreArtista;
        this.fechaDebut = fechaDebut;
        this.seguiRArtista = seguiRArtista;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public LocalDate getFechaDebut() {
        return fechaDebut;
    }

    public void setFechaDebut(LocalDate fechaDebut) {
        this.fechaDebut = fechaDebut;
    }

    public boolean isSeguiRArtista() {
        return seguiRArtista;
    }

    public void setSeguiRArtista(boolean seguiRArtista) {
        this.seguiRArtista = seguiRArtista;
    }



}

