package co.edu.unbosque.ProyectoPolicia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int age;
    private String entryDate; 
    private String rank;
    private int raidsParticipated;

   public Agent() {
	// TODO Auto-generated constructor stub
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getEntryDate() {
	return entryDate;
}

public void setEntryDate(String entryDate) {
	this.entryDate = entryDate;
}

public String getRank() {
	return rank;
}

public void setRank(String rank) {
	this.rank = rank;
}

public int getRaidsParticipated() {
	return raidsParticipated;
}

public void setRaidsParticipated(int raidsParticipated) {
	this.raidsParticipated = raidsParticipated;
}
   
}

