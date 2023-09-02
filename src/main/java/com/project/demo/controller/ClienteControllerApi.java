package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Cliente;
import com.project.demo.service.IClienteService;

@RestController
public class ClienteControllerApi {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/api/clienteFindById")
	public Object clientefindById(@RequestParam(value = "id") long id) {
		return clienteService.findById(id);
	}

	@GetMapping("/api/clienteFindAll")
	public Object clientefindAll() {
		return clienteService.findAll();
	}
	
	@PostMapping("/api/clienteSave")
	public Object clienteSave(@RequestBody Cliente cliente) {
		 clienteService.save(cliente);
		 return new ResponseEntity<>("Ejecuccón Guarado Exitosa", HttpStatus.OK); 
	}
	
	@GetMapping("/api/clienteDeleteId")
	public Object clienteDeleteId(@RequestParam(value = "id") long id) {
		Cliente cliente = clienteService.findById(id);
		clienteService.delete(cliente);
		return new ResponseEntity<>("Ejecuccón Eliminacion Exitosa", HttpStatus.OK); 
	}

}
