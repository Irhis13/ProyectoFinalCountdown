package com.example.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellidos;
    private String imagenDni;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSalida;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegreso;
    private String telefono;
    private String email;

    @ManyToOne
    @NotNull
    private Viaje viaje;

}
 

