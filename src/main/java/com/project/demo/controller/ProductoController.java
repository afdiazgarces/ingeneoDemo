package com.project.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.demo.model.Producto;
import com.project.demo.service.IProductoService;
import com.project.demo.util.Util;

@Controller
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	Logger logger = Logger.getLogger(ProductoController.class.getName());

	@GetMapping("/crearProducto")
	public String crearProducto(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "crearProducto";
	}

	@PostMapping("/addProducto")
	public String addProducto(@ModelAttribute("producto") Producto producto, BindingResult result, Model model) {

		logger.info("producto save" + Util.writeValueAsString(producto));

		productoService.save(producto);
		return "redirect:/mostrarProductos";
	}

	@GetMapping("/mostrarProductos")
	public Object mostrarProductos(Model model) {

		var productos = (List<Producto>) productoService.findAll();

		logger.info(Util.writeValueAsString(productos));

		model.addAttribute("productos", productos);

		return "mostrarProductos";
	}

	@GetMapping("/deleteProducto/{id}")
	public String deleteProducto(@PathVariable("id") long id, Model model) {
		Producto producto = productoService.findById(id);
		productoService.delete(producto);
		return "redirect:/mostrarProductos";
	}

	@GetMapping("/editarProducto/{id}")
	public String editarProducto(Model model, @PathVariable("id") long id) {
		Producto producto = productoService.findById(id);
		model.addAttribute("producto", producto);
		return "crearProducto";
	}

}
