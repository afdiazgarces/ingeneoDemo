package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Cliente;
import com.project.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente findById(long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
		
	}
	
	@Override
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

}
