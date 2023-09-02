package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Bodega;
import com.project.demo.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements IBodegaService {

	@Autowired
	BodegaRepository bodegaRepository;

	@Override
	public List<Bodega> findAll() {
		return (List<Bodega>) bodegaRepository.findAll();
	}

	@Override
	public Bodega findById(long id) {
		return bodegaRepository.findById(id).get();
	}

	@Override
	public void delete(Bodega bodega) {
		bodegaRepository.delete(bodega);

	}

	@Override
	public void save(Bodega bodega) {
		bodegaRepository.save(bodega);

	}

}
