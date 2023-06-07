package co.edu.unbosque.ProyectoPolicia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.ProyectoPolicia.model.Agent;
import co.edu.unbosque.ProyectoPolicia.respository.AgentRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gabrielapi/agent")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;

    @PostMapping("agent/")
    public ResponseEntity<String> addAgent(@RequestBody Agent agent) {
        agentRepository.save(agent);
        return ResponseEntity.status(HttpStatus.CREATED).body("Agent added successfully");
    }

    @GetMapping("agent/")
    public ResponseEntity<List<Agent>> getAllAgents() {
        return ResponseEntity.ok(agentRepository.findAll());
    }

    @GetMapping("/agent{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable Integer id) {
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        return optionalAgent.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("agent/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable Integer id, @RequestBody Agent agentDetails) {
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        if (optionalAgent.isPresent()) {
            Agent agent = optionalAgent.get();
            agent.setName(agentDetails.getName());
            agent.setAge(agentDetails.getAge());
            agent.setEntryDate(agentDetails.getEntryDate());
            agent.setRank(agentDetails.getRank());
            agent.setRaidsParticipated(agentDetails.getRaidsParticipated());
            agentRepository.save(agent);
            return ResponseEntity.ok(agent);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("agent/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable Integer id) {
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        if (optionalAgent.isPresent()) {
            agentRepository.deleteById(id);
            return ResponseEntity.ok("Agent deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agent not found");
        }
    }
}

