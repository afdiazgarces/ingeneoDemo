package com.project.demo.service;

import java.util.List;

import com.project.demo.model.Producto;

public interface IProductoService {

	List<Producto> findAll();

	Producto findById(long id);

	void delete(Producto producto);

	void save(Producto producto);
}
