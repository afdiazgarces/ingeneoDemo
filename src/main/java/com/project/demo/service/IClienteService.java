package com.project.demo.service;

import java.util.List;

import com.project.demo.model.Cliente;

public interface IClienteService {

	List<Cliente> findAll();
	
	Cliente findById(long id);
	
	void delete(Cliente cliente);
	
	void save(Cliente cliente);
}
