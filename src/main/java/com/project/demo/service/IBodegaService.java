package com.project.demo.service;

import java.util.List;

import com.project.demo.model.Bodega;

public interface IBodegaService {

	List<Bodega> findAll();

	Bodega findById(long id);

	void delete(Bodega bodega);

	void save(Bodega bodega);
}
