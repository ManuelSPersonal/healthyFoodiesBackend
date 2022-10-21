package com.healthyFoodies.recetas.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Recetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;

    public String descripcion;

    public String preparacion;

    public Boolean activa;

}
