package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Producto;
import com.project.demo.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public Producto findById(long id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public void delete(Producto producto) {
		productoRepository.delete(producto);

	}

	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);

	}

}
