package co.edu.unbosque.ProyectoPolicia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.ProyectoPolicia.model.Raid;
import co.edu.unbosque.ProyectoPolicia.respository.RaidRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gabrielapi/narcotic")
public class RaidController {

    @Autowired
    private RaidRepository raidRepository;

    @PostMapping("/raid")
    public ResponseEntity<String> agregar(@RequestBody Raid raid) {
        raidRepository.save(raid);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con éxito: 201");
    }

    @GetMapping("/raid")
    public ResponseEntity<List<Raid>> mostrarTodo() {
        List<Raid> lista = raidRepository.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
    }

    @GetMapping("/raid/{id}")
    public ResponseEntity<Optional<Raid>> mostrarPorID(@PathVariable Integer id) {
        Optional<Raid> dato = raidRepository.findById(id);
        if (dato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dato);
    }

    @DeleteMapping("/raid/{id}")
    public ResponseEntity<String> eliminarPorID(@PathVariable Integer id) {
        Optional<Raid> dato = raidRepository.findById(id);
        if (dato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el dato");
        }
        raidRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dato eliminado con éxito");
    }

    @PutMapping("/raid/{id}")
    public ResponseEntity<String> actualizarPorID(@PathVariable Integer id, @RequestBody Raid newRaid) {
        Optional<Raid> oldRaid = raidRepository.findById(id);
        if (oldRaid.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dato no encontrado");
        }
        Raid raidToUpdate = oldRaid.get();
        raidToUpdate.setExecutionDate(newRaid.getExecutionDate());
        raidToUpdate.setStartTime(newRaid.getStartTime());
        raidToUpdate.setEndTime(newRaid.getEndTime());
        raidToUpdate.setCapturedQuantity(newRaid.getCapturedQuantity());
        raidRepository.save(raidToUpdate);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Actualizado con éxito");
    }
}

