package com.examen.backend_prueba;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;


@Entity(name = "artista") 
@Table(name = "artistas") 
public class ArtistaEntidad { 
   

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY, generator = "artista_seq") 
    @SequenceGenerator(name = "artista_seq", sequenceName = "artistas_seq", allocationSize = 1)      
    private int idArtista; 


    @Column (name = "NOMBRE_ARTISTA", length = 200, 
            nullable = false, unique = false) 
    private String nombreArtista;

    @JsonFormat(pattern = "dd-MM-yyyy")
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
        this.seguirArtista = seguiRArtista;
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
        return seguirArtista;
    }
    public void setSeguiRArtista(boolean seguiRArtista) {
        this.seguirArtista = seguiRArtista;
    }

}

