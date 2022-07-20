package com.josue.cisneros.ec03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josue.cisneros.ec03.dto.UsuarioDTORequest;
import com.josue.cisneros.ec03.dto.UsuarioDTOResponse;
import com.josue.cisneros.ec03.model.Usuario;
import com.josue.cisneros.ec03.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public void guardarUsuario(UsuarioDTORequest usuario) {
		Usuario u = new Usuario();
		u.setContrasena(usuario.getContrasena());
		u.setRol(usuario.getRolUsuario());
		u.setUsuario(usuario.getUsername());
		repository.save(u);
	
	}

	@Override
	public void actualizarUsuario(UsuarioDTORequest usuario) {
		Usuario u = new Usuario();
		u.setContrasena(usuario.getContrasena());
		u.setId(usuario.getIdUsuario());
		u.setRol(usuario.getRolUsuario());
		u.setUsuario(usuario.getUsername());
		
		repository.saveAndFlush(u);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuarios() {
		List<UsuarioDTOResponse> listar = new ArrayList<>();
		
		UsuarioDTOResponse dto = null;
		
		List<Usuario> u = repository.findAll();
		
		for(Usuario usuario : u) {
			dto = new UsuarioDTOResponse();
			
			dto.setContrasena(usuario.getContrasena());
			dto.setIdUsuario(usuario.getId());
			dto.setRolUsuario(usuario.getRol());
			dto.setUsername(usuario.getUsuario());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {
		Usuario usuario = repository.findById(id).orElse(null);
		UsuarioDTOResponse dto = new UsuarioDTOResponse();
		
		dto.setContrasena(usuario.getContrasena());
		dto.setIdUsuario(usuario.getId());
		dto.setRolUsuario(usuario.getRol());
		dto.setUsername(usuario.getUsuario());
		
		return dto;
	}

}










