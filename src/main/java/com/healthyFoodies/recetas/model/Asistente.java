package com.healthyFoodies.recetas.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Asistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;

    public String apellido_p;

    public String apellido_m;

    public String correo;

    public String contrasena;

    public String activo;
}
