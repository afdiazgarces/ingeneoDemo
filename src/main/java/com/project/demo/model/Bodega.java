package com.project.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "bodegas")
public class Bodega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "El campo es obligatorio")
	private String nombre;
	@NotEmpty(message = "El campo es obligatorio")
	private String telefono;
	@NotEmpty(message = "El campo es obligatorio")
	private String ubicacion;
	@Column(name = "tipobodega")
	@NotEmpty(message = "El campo es obligatorio")
	private String tipoBodega;
	@NotEmpty(message = "El campo es obligatorio")
	private String territorio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTipoBodega() {
		return tipoBodega;
	}

	public void setTipoBodega(String tipoBodega) {
		this.tipoBodega = tipoBodega;
	}

	public String getTerritorio() {
		return territorio;
	}

	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}

}
