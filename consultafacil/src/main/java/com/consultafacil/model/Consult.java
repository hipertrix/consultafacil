package com.consultafacil.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id; 
import javax.validation.constraints.NotNull;


@Entity
public class Consult implements Serializable {

 
	private static final long serialVersionUID = 1631864248431455790L;
 

	@Id 
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Date date;
	
	private String end_time;
	@NotNull
	private String ini_time;
	private String observation;
	private int patient_id;
	private int doctor_id;
	private int parent_id; 
	private Date created_at;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	} 
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getIni_time() {
		return ini_time;
	}

	public void setIni_time(String ini_time) {
		this.ini_time = ini_time;
	}

	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patients_id) {
		this.patient_id = patients_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	


}
