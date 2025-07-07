package com.examen.backend_prueba;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity(name = "cancion") 
@Table(name = "canciones") 
public class CancionEntidad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCancion;


    @Column(name = "TITULO_CANCION", length = 200, nullable = false) 
    private String tituloCancion; 

    @Column(name = "CALIFICACION_CANCION", nullable = false) 
    private double calificacionCancion; 

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column (name = "LANZAMIENTO_CANCION", nullable = false)
    private LocalDate lanzamientoCancion; 

    @Column(name = "FAVORITA_CANCION", nullable = false)
    private boolean favoritaCancion; 


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idArtista")
    private ArtistaEntidad artista;
 

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
}

        