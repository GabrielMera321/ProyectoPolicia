package co.edu.unbosque.ProyectoPolicia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Raid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String executionDate; 
    private String startTime; 
    private String endTime; 
    private int capturedQuantity;

    public Raid() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getCapturedQuantity() {
		return capturedQuantity;
	}

	public void setCapturedQuantity(int capturedQuantity) {
		this.capturedQuantity = capturedQuantity;
	}
    
}

