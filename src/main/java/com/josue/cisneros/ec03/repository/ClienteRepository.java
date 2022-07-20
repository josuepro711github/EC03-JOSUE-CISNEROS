package com.josue.cisneros.ec03.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.josue.cisneros.ec03.model.Cliente;

@RepositoryRestResource(path = "cliente")
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
