package com.josue.cisneros.ec03.service;

import java.util.List;

import com.josue.cisneros.ec03.dto.HospitalDTORequest;
import com.josue.cisneros.ec03.dto.HospitalDTOResponse;

public interface HospitalService {
	
	void guardarHospital(HospitalDTORequest hospital);
	void actualizarHospital(HospitalDTORequest hospital);
	void eliminarHospital(Integer id);
	List<HospitalDTOResponse> listarHospital();
	HospitalDTOResponse obtenerHospitalId(Integer id);
	
}
