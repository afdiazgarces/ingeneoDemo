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

import com.project.demo.model.Bodega;
import com.project.demo.service.IBodegaService;
import com.project.demo.util.Util;

@Controller
public class BodegaController {

	@Autowired
	private IBodegaService bodegaService;

	Logger logger = Logger.getLogger(BodegaController.class.getName());

	@GetMapping("/crearBodega")
	public String crearBodega(Model model) {
		Bodega bodega = new Bodega();
		model.addAttribute("bodega", bodega);
		return "crearBodega";
	}

	@PostMapping("/addBodega")
	public String addBodega(@ModelAttribute("bodega") Bodega bodega, BindingResult result, Model model) {

		logger.info("bodega save" + Util.writeValueAsString(bodega));

		bodegaService.save(bodega);
		return "redirect:/mostrarBodegas";
	}

	@GetMapping("/mostrarBodegas")
	public Object mostrarBodegas(Model model) {

		var bodegas = (List<Bodega>) bodegaService.findAll();

		logger.info(Util.writeValueAsString(bodegas));

		model.addAttribute("bodegas", bodegas);

		return "mostrarBodegas";
	}

	@GetMapping("/deleteBodega/{id}")
	public String deleteBodega(@PathVariable("id") long id, Model model) {
		Bodega bodega = bodegaService.findById(id);
		bodegaService.delete(bodega);
		return "redirect:/mostrarBodegas";
	}

	@GetMapping("/editarBodega/{id}")
	public String editarBodega(Model model, @PathVariable("id") long id) {
		Bodega bodega = bodegaService.findById(id);
		model.addAttribute("bodega", bodega);
		return "crearBodega";
	}

}
