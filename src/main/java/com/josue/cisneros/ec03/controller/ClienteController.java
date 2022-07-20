package com.josue.cisneros.ec03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josue.cisneros.ec03.dto.ClienteDTORequest;
import com.josue.cisneros.ec03.dto.ClienteDTOResponse;
import com.josue.cisneros.ec03.service.ClienteService;

@Controller
@RequestMapping( path = "/EC3JosueCisneros/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ClienteDTOResponse>>  listar() {
		
		return new ResponseEntity<List<ClienteDTOResponse>>(service.listarClientes(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest clientes) {
		service.guardarCliente(clientes);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);	
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ClienteDTOResponse c =service.obtenerClienteId(id);
		if(c != null) {
			service.eliminarCliente(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ClienteDTORequest clientes) {
		ClienteDTOResponse c =service.obtenerClienteId(clientes.getIdCliente());
		if(c != null) {
			service.actualizarCliente(clientes);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTOResponse> obtenerId(@PathVariable Integer id) {
		ClienteDTOResponse c =service.obtenerClienteId(id);
		if(c != null) {
			return new ResponseEntity<ClienteDTOResponse>(service.obtenerClienteId(id),HttpStatus.OK);
		}
		return new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
}






