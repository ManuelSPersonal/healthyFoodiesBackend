package com.healthyFoodies.recetas.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;

    public String calorias;

    public String activo;
}
