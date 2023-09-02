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

import com.project.demo.model.Logistica;
import com.project.demo.model.SearchDto;
import com.project.demo.service.IBodegaService;
import com.project.demo.service.IClienteService;
import com.project.demo.service.ILogisticaService;
import com.project.demo.service.IProductoService;
import com.project.demo.util.Util;

@Controller
public class LogisticaController {

	@Autowired
	private ILogisticaService logisticaService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IBodegaService bodegaService;

	@Autowired
	private IProductoService productoService;

	Logger logger = Logger.getLogger(LogisticaController.class.getName());

	@GetMapping("/crearLogistica")
	public String crearLogistica(Model model) {
		Logistica logistica = new Logistica();
		model.addAttribute("logistica", logistica);
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("bodegas", bodegaService.findAll());
		model.addAttribute("productos", productoService.findAll());

		return "crearLogistica";
	}

	@PostMapping("/addLogistica")
	public String addLogistica(@ModelAttribute("logistica") Logistica logistica, BindingResult result, Model model) {

		try {
			logisticaService.save(logistica);
		} catch (Exception e) {
			model.addAttribute("logistica", logistica);
			model.addAttribute("clientes", clienteService.findAll());
			model.addAttribute("bodegas", bodegaService.findAll());
			model.addAttribute("productos", productoService.findAll());
			model.addAttribute("mensaje", e.getMessage());
			return "crearLogistica";
		}

		return "redirect:/mostrarLogisticas";
	}

	@GetMapping("/mostrarLogisticas")
	public Object mostrarLogisticas(Model model) {

		var logisticas = (List<Logistica>) logisticaService.findAll();

		logger.info(Util.writeValueAsString(logisticas));

		model.addAttribute("logisticas", logisticas);

		SearchDto dto = new SearchDto();

		model.addAttribute("dto", dto);

		return "mostrarLogisticas";
	}

	@GetMapping("/deleteLogistica/{id}")
	public String deleteLogistica(@PathVariable("id") long id, Model model) {
		Logistica logistica = logisticaService.findById(id);
		logisticaService.delete(logistica);
		return "redirect:/mostrarLogisticas";
	}

	@GetMapping("/editarLogistica/{id}")
	public String editarLogistica(Model model, @PathVariable("id") long id) {
		Logistica logistica = logisticaService.findById(id);
		model.addAttribute("logistica", logistica);
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("bodegas", bodegaService.findAll());
		model.addAttribute("productos", productoService.findAll());
		return "crearLogistica";
	}

	@PostMapping("/searchLogistica")
	public String searchLogistica(@ModelAttribute("dto") SearchDto dto, BindingResult result, Model model) {

		var logisticas = (List<Logistica>) logisticaService.findAll();

		if (dto.getOption().equals("Cedula")) {
			logisticas = (List<Logistica>) logisticaService.findByFieldCedula(dto.getValue());
		} else if (dto.getOption().equals("Guia")) {
			logisticas = (List<Logistica>) logisticaService.findByFieldGuia(dto.getValue());
		} else if (dto.getOption().equals("Flota")) {
			logisticas = (List<Logistica>) logisticaService.findByFieldFlota(dto.getValue());
		}

		logger.info(Util.writeValueAsString(logisticas));

		model.addAttribute("logisticas", logisticas);

		return "mostrarLogisticas";
	}

}
