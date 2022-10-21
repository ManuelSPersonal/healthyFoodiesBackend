package com.healthyFoodies.recetas.resource;

import com.healthyFoodies.recetas.jpa.AsistenteRepo;
import com.healthyFoodies.recetas.model.Asistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Asistente")
public class AsistenteResource {

    @Autowired
    private AsistenteRepo asistenteRepo;

    @GetMapping
    public ResponseEntity getAsistente(@RequestParam(required = false) String buscar){
        if (buscar != null)
        {
            List<Asistente> asistente = asistenteRepo.findAllByNombre(buscar);
            if (!asistente.isEmpty())
                return ResponseEntity.ok(asistente);
        }
            return ResponseEntity.ok(asistenteRepo.findAll());
    }


}
