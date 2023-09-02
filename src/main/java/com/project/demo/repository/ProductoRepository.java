package com.project.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
