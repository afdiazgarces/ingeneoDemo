package com.project.demo.service;

import java.util.List;

import com.project.demo.model.Logistica;

public interface ILogisticaService {

	List<Logistica> findAll();

	Logistica findById(long id);

	List<Logistica> findByFieldGuia(String value);

	List<Logistica> findByFieldCedula(String value);

	List<Logistica> findByFieldFlota(String value);

	void delete(Logistica logistica);

	void save(Logistica logistica) throws Exception;
}
