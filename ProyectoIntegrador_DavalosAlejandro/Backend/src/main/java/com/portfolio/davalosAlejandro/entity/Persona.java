
package com.portfolio.davalosAlejandro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    @NotNull
    @Size(min = 1, max=50, message ="No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max=50, message ="No cumple con la longitud")
    private String apellido;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private String about;
    
    @Size(min = 1, max=50, message ="No cumple con la longitud")
    @Column(name="img")
    private String img;
    
     public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String titulo, String about, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.about = about;
        this.img = img;
    }
    }
 
