package com.josue.cisneros.ec03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josue.cisneros.ec03.dto.ClienteDTORequest;
import com.josue.cisneros.ec03.dto.ClienteDTOResponse;
import com.josue.cisneros.ec03.model.Cliente;
import com.josue.cisneros.ec03.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		c.setCliente(cliente.getNombreCliente());
		c.setCelular(cliente.getCelularCliente());
		repository.save(c);
	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		c.setId(cliente.getIdCliente());
		c.setCliente(cliente.getNombreCliente());
		c.setCelular(cliente.getCelularCliente());
		
		repository.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		List<ClienteDTOResponse> listar = new ArrayList<>();
		
		ClienteDTOResponse dto = null;
		
		List<Cliente> c = repository.findAll();
		
		for(Cliente cliente : c) {
			dto = new ClienteDTOResponse();
			
			dto.setIdCliente(cliente.getId());
			dto.setCelularCliente(cliente.getCelular());
			dto.setNombreCliente(cliente.getCliente());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		Cliente clientes = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		dto.setIdCliente(clientes.getId());
		dto.setCelularCliente(clientes.getCelular());
		dto.setNombreCliente(clientes.getCliente());
		
		return dto;
	}

}
