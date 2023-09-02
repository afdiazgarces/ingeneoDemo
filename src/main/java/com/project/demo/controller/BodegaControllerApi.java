package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Bodega;
import com.project.demo.service.IBodegaService;

@RestController
public class BodegaControllerApi {

	@Autowired
	private IBodegaService bodegaService;

	@GetMapping("/api/bodegaFindById")
	public Object bodegaFindById(@RequestParam(value = "id") long id) {
		return bodegaService.findById(id);
	}

	@GetMapping("/api/bodegaFindAll")
	public Object bodegaFindAll() {
		return bodegaService.findAll();
	}
	
	@PostMapping("/api/bodegaSave")
	public Object bodegaSave(@RequestBody Bodega bodega) {
		bodegaService.save(bodega);
		 return new ResponseEntity<>("Ejecuccón Guarado Exitosa", HttpStatus.OK); 
	}
	
	@GetMapping("/api/bodegaDeleteId")
	public Object bodegaDeleteId(@RequestParam(value = "id") long id) {
		Bodega bodega = bodegaService.findById(id);
		bodegaService.delete(bodega);
		return new ResponseEntity<>("Ejecuccón Eliminacion Exitosa", HttpStatus.OK); 
	}

}
