package com.josue.cisneros.ec03.service;

import java.util.List;

import com.josue.cisneros.ec03.dto.ClienteDTORequest;
import com.josue.cisneros.ec03.dto.ClienteDTOResponse;


public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id);
	
}
