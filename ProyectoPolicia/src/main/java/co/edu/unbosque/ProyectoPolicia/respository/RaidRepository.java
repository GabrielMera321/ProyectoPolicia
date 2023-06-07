package co.edu.unbosque.ProyectoPolicia.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.ProyectoPolicia.model.Raid;

public interface RaidRepository extends JpaRepository<Raid, Integer> {

	 List<Raid> findByCapturedGreaterThan(int captured); // encontrar redadas donde se capturaron más de un cierto número de narcóticos

}
