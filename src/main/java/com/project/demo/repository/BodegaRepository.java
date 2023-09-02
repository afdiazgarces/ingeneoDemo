package com.project.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.Bodega;

@Repository
public interface BodegaRepository extends CrudRepository<Bodega, Long> {

}
