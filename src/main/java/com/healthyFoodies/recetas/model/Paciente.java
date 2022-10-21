package com.healthyFoodies.recetas.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;

    public String apellido_p;

    public String apellido_m;

    public int edad;

    public String sexo;

    public Float peso;

    public Float estatura;

    public Float imc;

    public String correo;

    public String contrasena;

    public String telefono;

    public String activo;

}
