package co.edu.unbosque.ProyectoPolicia.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unbosque.ProyectoPolicia.model.Narcotics;

public interface NarcoticsRepository extends JpaRepository<Narcotics, Integer> {

	List<Narcotics> findByType(String type); // encontrar narcóticos por tipo

    @Query("SELECT n FROM Narcotic n WHERE n.weight < ?1")
    List<Narcotics> findByWeightLessThan(double weight); // encontrar narcóticos con un peso menor que cierto valor
}
