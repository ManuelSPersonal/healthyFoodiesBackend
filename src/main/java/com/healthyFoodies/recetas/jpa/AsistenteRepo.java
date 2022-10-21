package com.healthyFoodies.recetas.jpa;

import com.healthyFoodies.recetas.model.Asistente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsistenteRepo extends JpaRepository<Asistente, Long> {

    List<Asistente> findAllByNombre(String nombre);
}
