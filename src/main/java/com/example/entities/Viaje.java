package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Viaje implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    
    //Booleanos
    // private boolean vestuarioExtra;
    // private boolean reportajeExra;  
    
    @ManyToOne
    @NotNull
    private Categoria categoria;

    @ManyToOne
    private Cliente cliente;


}