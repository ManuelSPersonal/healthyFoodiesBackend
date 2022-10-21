package com.healthyFoodies.recetas.resource;

import com.healthyFoodies.recetas.jpa.RecetasRepo;
import com.healthyFoodies.recetas.model.Recetas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/receta")
public class RecetaResource {

    @Autowired
    private RecetasRepo recetasRepo;

    @GetMapping
    public ResponseEntity getReceta(@RequestParam(required = false) Long id){
        if (id != null) {
            Recetas receta = recetasRepo.getById(id);
            return ResponseEntity.ok(receta);
        }
        else
            return ResponseEntity.ok(recetasRepo.findAll());
    }

    @PostMapping
    public ResponseEntity postReceta(@RequestBody Recetas nuevaReceta){
        nuevaReceta.setActiva(true);
        recetasRepo.save(nuevaReceta);

        return ResponseEntity.ok(nuevaReceta);
    }

    @PutMapping("{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody Recetas datos){
        try {
            Optional<Recetas> existe = recetasRepo.findById(id);
            Recetas receta = recetasRepo.getById(id);

            if (existe.isPresent() & receta.getActiva().equals(true)) {
                receta.setNombre(datos.getNombre());
                receta.setDescripcion(datos.getDescripcion());
                receta.setPreparacion(datos.getPreparacion());
                recetasRepo.save(receta);
                return ResponseEntity.ok(receta);
            } else
                return ResponseEntity.ok("La receta especificada no existe");
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity eliminar(@PathVariable long id){
        Recetas receta = recetasRepo.getById(id);
        receta.setActiva(false);
        recetasRepo.save(receta);
        return ResponseEntity.ok("se ha eliminado la receta id:"+ id);
    }
}
