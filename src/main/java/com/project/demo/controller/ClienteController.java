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

import com.project.demo.model.Cliente;
import com.project.demo.service.IClienteService;
import com.project.demo.util.Util;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	Logger logger = Logger.getLogger(ClienteController.class.getName());

	@GetMapping("/crearCliente")
	public String crearCliente(Model model) {
		Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
		return "crearCliente";
	}

	@PostMapping("/addCliente")
	public String addCliente(@ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model) {
		
		logger.info("Cliente save" + Util.writeValueAsString(cliente));
		
		clienteService.save(cliente);
		return "redirect:/mostrarClientes";
	}

	@GetMapping("/mostrarClientes")
	public Object mostrarClientes(Model model) {

		Object clientes = (List<Cliente>) clienteService.findAll();

		logger.info(Util.writeValueAsString(clientes));

		model.addAttribute("clientes", clientes);

		return "mostrarClientes";
	}

	@GetMapping("/delete/{id}")
	public String deleteCliente(@PathVariable("id") long id, Model model) {
		Cliente cliente = clienteService.findById(id);
		clienteService.delete(cliente);
		return "redirect:/mostrarClientes";
	}
	
	
	@GetMapping("/editarCliente/{id}")
	public String editarCliente(Model model,@PathVariable("id") long id) {
		Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
		return "crearCliente";
	}
	


}
