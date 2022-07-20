package com.josue.cisneros.ec03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josue.cisneros.ec03.dto.HospitalDTORequest;
import com.josue.cisneros.ec03.dto.HospitalDTOResponse;
import com.josue.cisneros.ec03.model.Hospital;
import com.josue.cisneros.ec03.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	HospitalRepository repository;
	
	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		Hospital h = new Hospital();
		h.setDistrito(hospital.getDistritoHospital());
		h.setDescripcion(hospital.getDescripcionHospital());
		h.setNombre(hospital.getNombreHospital());
		repository.save(h);
	}

	@Override
	public void actualizarHospital(HospitalDTORequest hospital) {
		Hospital h = new Hospital();
		h.setDistrito(hospital.getDistritoHospital());
		h.setDescripcion(hospital.getDescripcionHospital());
		h.setNombre(hospital.getNombreHospital());
		h.setIdHospital(hospital.getId());
		
		repository.saveAndFlush(h);
	}

	@Override
	public void eliminarHospital(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		List<HospitalDTOResponse> listar = new ArrayList<>();
		
		HospitalDTOResponse dto = null;
		
		List<Hospital> h = repository.findAll();
		
		for(Hospital hospital : h) {
			dto = new HospitalDTOResponse();
			
			dto.setDescripcionHospital(hospital.getDescripcion());
			dto.setDistritoHospital(hospital.getDistrito());
			dto.setId(hospital.getIdHospital());
			dto.setNombreHospital(hospital.getNombre());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		
		dto.setDescripcionHospital(hospital.getDescripcion());
		dto.setDistritoHospital(hospital.getDistrito());
		dto.setId(hospital.getIdHospital());
		dto.setNombreHospital(hospital.getNombre());
		
		return dto;
	}
	
}











