package co.edu.unbosque.ProyectoPolicia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.ProyectoPolicia.model.Narcotics;
import co.edu.unbosque.ProyectoPolicia.respository.NarcoticsRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gabrielapi/raid")
public class NarcoticsController {

    @Autowired
    private NarcoticsRepository narcoticRepository;

    @PostMapping("/narcotic")
    public ResponseEntity<String> agregar(@RequestBody Narcotics narcotic) {
        narcoticRepository.save(narcotic);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con éxito: 201");
    }

    @GetMapping("/narcotic")
    public ResponseEntity<List<Narcotics>> mostrarTodo() {
        List<Narcotics> lista = narcoticRepository.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
    }

    @GetMapping("/narcotic/{id}")
    public ResponseEntity<Optional<Narcotics>> mostrarPorID(@PathVariable Integer id) {
        Optional<Narcotics> dato = narcoticRepository.findById(id);
        if (dato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dato);
    }

    @DeleteMapping("/narcotic/{id}")
    public ResponseEntity<String> eliminarPorID(@PathVariable Integer id) {
        Optional<Narcotics> dato = narcoticRepository.findById(id);
        if (dato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el dato");
        }
        narcoticRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dato eliminado con éxito");
    }

    @PutMapping("/narcotic/{id}")
    public ResponseEntity<String> actualizarPorID(@PathVariable Integer id, @RequestBody Narcotics newNarcotic) {
        Optional<Narcotics> oldNarcotic = narcoticRepository.findById(id);
        if (oldNarcotic.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dato no encontrado");
        }
        Narcotics narcoticToUpdate = oldNarcotic.get();
        narcoticToUpdate.setType(newNarcotic.getType());
        narcoticToUpdate.setWeight(newNarcotic.getWeight());
        narcoticRepository.save(narcoticToUpdate);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Actualizado con éxito");
    }
}

