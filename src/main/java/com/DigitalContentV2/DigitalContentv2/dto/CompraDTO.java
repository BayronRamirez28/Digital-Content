package com.DigitalContentV2.DigitalContentv2.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.DigitalContentV2.DigitalContentv2.modelo.Inventario;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;

public class CompraDTO {

	private Integer idCompra;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	private Integer cantidad;
	private Long precioU;
	private List<Inventario> inventario;
	private Producto id_Producto_fk;

	public CompraDTO(Integer idCompra, Date fecha, Integer cantidad, Long precioU, List<Inventario> inventario,
			Producto id_Producto_fk) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.precioU = precioU;
		this.inventario = inventario;
		this.id_Producto_fk = id_Producto_fk;
	}

	public CompraDTO(Integer idCompra, Integer cantidad, Producto id_Producto_fk) {
		super();
		this.idCompra = idCompra;
		this.cantidad = cantidad;
		this.id_Producto_fk = id_Producto_fk;
	}

	public CompraDTO() {
		super();
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Long getPrecioU() {
		return precioU;
	}

	public void setPrecioU(Long precioU) {
		this.precioU = precioU;
	}

	public List<Inventario> getInventario() {
		return inventario;
	}

	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}

	public Producto getId_Producto_fk() {
		return id_Producto_fk;
	}

	public void setId_Producto_fk(Producto id_Producto_fk) {
		this.id_Producto_fk = id_Producto_fk;
	}
	
}
