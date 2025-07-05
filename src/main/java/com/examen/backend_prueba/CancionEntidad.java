package com.examen.backend_prueba;

import java.time.LocalDate;
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
import java.util.List;



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
    @JoinColumn(name = "idArtista")
    private ArtistaEntidad artista;

    @OneToMany(mappedBy = "artista")
    private List<CancionEntidad> canciones; 

     public CancionEntidad() {
    }

    public CancionEntidad(String tituloCancion, double calificacionCancion, LocalDate lanzamientoCancion, boolean favoritaCancion, ArtistaEntidad artista) {
        this.tituloCancion = tituloCancion;
        this.calificacionCancion = calificacionCancion;
        this.lanzamientoCancion = lanzamientoCancion;
        this.favoritaCancion = favoritaCancion;
        this.artista = artista;
    }


    public int getIdCancion() {
        return idCancion;
    }       
    public void setIdCancion(int idCancion) {
            this.idCancion = idCancion;
        }   

    public String getTituloCancion() {
        return tituloCancion;
    }
    public void setTituloCancion(String tituloCancion) {    
        this.tituloCancion = tituloCancion;
    }

    public double getCalificacionCancion() {
        return calificacionCancion; 

    }
    public void setCalificacionCancion(double calificacionCancion) {        
        this.calificacionCancion = calificacionCancion;
    }
    public LocalDate getLanzamientoCancion() {
        return lanzamientoCancion;      
    }
    public void setLanzamientoCancion(LocalDate lanzamientoCancion) {                       
        this.lanzamientoCancion = lanzamientoCancion;
    }
    public boolean isFavoritaCancion() {
        return favoritaCancion;             
    }
    public void setFavoritaCancion(boolean favoritaCancion) {   
        this.favoritaCancion = favoritaCancion;
    }
    public ArtistaEntidad getArtista() {
        return artista; 
    }
    public void setArtista(ArtistaEntidad artista) {    
        this.artista = artista;
    }   


        