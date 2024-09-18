package com.trendy.controlador.autenticacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendy.entidades.Paquete.Pais;
import com.trendy.servicio.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    // Obtener todos los países
    @GetMapping("findAllP")
    public ResponseEntity<List<Pais>> getAllPaises() {
        List<Pais> paises = paisService.findAll();
        return ResponseEntity.ok(paises);
    }

    // Obtener un país por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable("id") Long id_Pais) {
        Optional<Pais> pais = paisService.findById(id_Pais);
        return pais.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

     // Obtener un país por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Pais> getPaisByNombre(@PathVariable("nombre") String nombrePais) {
    Optional<Pais> pais = paisService.findByNombrePais(nombrePais);
        return pais.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

     // Crear un nuevo país
    @PostMapping("/save")
    public ResponseEntity<Pais> createPais(@RequestBody Pais pais) {
        Pais nuevoPais = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPais);
    }

    // Actualizar un país existente
    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable("id") Long id_Pais, @RequestBody Pais pais) {
        if (!paisService.findById(id_Pais).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Pais paisActualizado = paisService.save(pais);
        return ResponseEntity.ok(paisActualizado);
    }

    // Eliminar un país por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable("id") Long id_Pais) {
        if (!paisService.findById(id_Pais).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        paisService.deleteById(id_Pais);
        return ResponseEntity.noContent().build();
    }

}
