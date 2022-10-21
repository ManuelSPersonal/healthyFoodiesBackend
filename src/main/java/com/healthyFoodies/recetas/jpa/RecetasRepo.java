package com.healthyFoodies.recetas.jpa;

import com.healthyFoodies.recetas.model.Recetas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetasRepo extends JpaRepository<Recetas, Long> {
}
