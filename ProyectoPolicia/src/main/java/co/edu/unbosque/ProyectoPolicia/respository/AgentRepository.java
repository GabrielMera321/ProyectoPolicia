package co.edu.unbosque.ProyectoPolicia.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unbosque.ProyectoPolicia.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

	List<Agent> findByRank(String rank); // encontrar agentes por rango

    @Query("SELECT a FROM Agent a WHERE a.raidsParticipated.size > ?1")
    List<Agent> findByRaidParticipationGreaterThan(int raidCount); // encontrar agentes que han participado en más de un cierto número de redadas
}


