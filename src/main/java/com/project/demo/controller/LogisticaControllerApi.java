package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Logistica;
import com.project.demo.service.ILogisticaService;

@RestController
public class LogisticaControllerApi {

	@Autowired
	private ILogisticaService logisticaService;

	@GetMapping("/api/logisticaFindById")
	public Object logisticaFindById(@RequestParam(value = "id") long id) {
		return logisticaService.findById(id);
	}

	@GetMapping("/api/logisticaFindAll")
	public Object logisticaFindAll() {
		return logisticaService.findAll();
	}
	
	@PostMapping("/api/logisticaSave")
	public Object logisticaSave(@RequestBody Logistica logistica) throws Exception {
		logisticaService.save(logistica);
		 return new ResponseEntity<>("Ejecuccón Guarado Exitosa", HttpStatus.OK); 
	}
	
	@GetMapping("/api/logisticaDeleteId")
	public Object logisticaDeleteId(@RequestParam(value = "id") long id) {
		Logistica logistica = logisticaService.findById(id);
		logisticaService.delete(logistica);
		return new ResponseEntity<>("Ejecuccón Eliminacion Exitosa", HttpStatus.OK); 
	}
	
	@GetMapping("/api/logisticaFindByGuia")
	public Object logisticaFindByFieldGuia(@RequestParam(value = "value") String value) {
		return logisticaService.findByFieldGuia(value);
	}
	
	@GetMapping("/api/logisticaFindByCedula")
	public Object logisticaFindByCedula(@RequestParam(value = "value") String value) {
		return logisticaService.findByFieldCedula(value);
	}

}
