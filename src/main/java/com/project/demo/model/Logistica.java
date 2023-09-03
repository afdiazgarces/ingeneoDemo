package com.project.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "logisticas")
public class Logistica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "cliente", referencedColumnName = "id")
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name = "bodega", referencedColumnName = "id")
	private Bodega bodega;

	@OneToOne
	@JoinColumn(name = "producto", referencedColumnName = "id")
	private Producto producto;

	@Column(name = "numeroflota")
	@NotEmpty(message = "El campo es obligatorio")
	private String numeroFlota;

	@Column(name = "numeroguia")
	private String numeroGuia;

	@Column(name = "cantidadpructo")
	private int cantidadPructo;

	@Column(name = "fecharegistro")
	private String fechaRegistro;

	@Column(name = "fechaentrega")
	private String fechaEntrega;

	@Column(name = "precioenvio")
	private double precioEnvio;

	@Column(name = "valordescuento")
	private double valorDescuento;

	@Column(name = "preciofinalenvio")
	private double precioFinalEnvio;

	@Column(name = "tipologistica")
	private String tipoLogistica;

	public String getTipoLogistica() {
		return tipoLogistica;
	}

	public void setTipoLogistica(String tipoLogistica) {
		this.tipoLogistica = tipoLogistica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidadPructo() {
		return cantidadPructo;
	}

	public void setCantidadPructo(int cantidadPructo) {
		this.cantidadPructo = cantidadPructo;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public double getPrecioEnvio() {
		return precioEnvio;
	}

	public void setPrecioEnvio(double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	public double getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	public double getPrecioFinalEnvio() {
		return precioFinalEnvio;
	}

	public void setPrecioFinalEnvio(double precioFinalEnvio) {
		this.precioFinalEnvio = precioFinalEnvio;
	}

	public String getNumeroFlota() {
		return numeroFlota;
	}

	public void setNumeroFlota(String numeroFlota) {
		this.numeroFlota = numeroFlota;
	}

	public String getNumeroGuia() {
		return numeroGuia;
	}

	public void setNumeroGuia(String numeroGuia) {
		this.numeroGuia = numeroGuia;
	}

}
