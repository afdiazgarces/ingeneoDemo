package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Producto;
import com.project.demo.service.IProductoService;

@RestController
public class ProductoControllerApi {

	@Autowired
	private IProductoService productoService;

	@GetMapping("/api/productoFindById")
	public Object productoFindById(@RequestParam(value = "id") long id) {
		return productoService.findById(id);
	}

	@GetMapping("/api/productoFindAll")
	public Object productoFindAll() {
		return productoService.findAll();
	}
	
	@PostMapping("/api/productoSave")
	public Object productoSave(@RequestBody Producto producto) {
		productoService.save(producto);
		 return new ResponseEntity<>("Ejecuccón Guarado Exitosa", HttpStatus.OK); 
	}
	
	@GetMapping("/api/productoDeleteId")
	public Object productoDeleteId(@RequestParam(value = "id") long id) {
		Producto producto = productoService.findById(id);
		productoService.delete(producto);
		return new ResponseEntity<>("Ejecuccón Eliminacion Exitosa", HttpStatus.OK); 
	}

}
