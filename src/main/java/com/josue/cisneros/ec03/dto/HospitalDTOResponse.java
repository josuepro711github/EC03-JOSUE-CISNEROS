package com.josue.cisneros.ec03.dto;

public class HospitalDTOResponse {
	
	private Integer id;
	private String nombreHospital;
	private String descripcionHospital;
	private String distritoHospital;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreHospital() {
		return nombreHospital;
	}
	public void setNombreHospital(String nombreHospital) {
		this.nombreHospital = nombreHospital;
	}
	public String getDescripcionHospital() {
		return descripcionHospital;
	}
	public void setDescripcionHospital(String descripcionHospital) {
		this.descripcionHospital = descripcionHospital;
	}
	public String getDistritoHospital() {
		return distritoHospital;
	}
	public void setDistritoHospital(String distritoHospital) {
		this.distritoHospital = distritoHospital;
	}
	
	
	
}
