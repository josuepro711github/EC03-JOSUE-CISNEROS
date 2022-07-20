package com.josue.cisneros.ec03.service;

import java.util.List;

import com.josue.cisneros.ec03.dto.UsuarioDTORequest;
import com.josue.cisneros.ec03.dto.UsuarioDTOResponse;

public interface UsuarioService {
	
	void guardarUsuario(UsuarioDTORequest usuario);
	void actualizarUsuario(UsuarioDTORequest usuario);
	void eliminarUsuario(Integer id);
	List<UsuarioDTOResponse> listarUsuarios();
	UsuarioDTOResponse obtenerUsuarioId(Integer id);
	
}
