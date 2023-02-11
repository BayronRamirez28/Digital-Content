package com.DigitalContentV2.DigitalContentv2.dto;

import com.DigitalContentV2.DigitalContentv2.modelo.Compra;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;
import com.DigitalContentV2.DigitalContentv2.modelo.Venta;

public class InventarioDTO {

	private Integer idInventario;
	private Producto id_Producto_fk;
	private Compra id_Compra_fk;
	private Venta id_Venta_fk;
	private Integer stock;
	private Integer calculo;

	public Integer getCalculo() {
		return calculo;
	}

	public void setCalculo(Integer calculo) {
		this.calculo = calculo;
	}

	public InventarioDTO(Producto id_Producto_fk, Compra id_Compra_fk, Venta id_Venta_fk, Integer stock) {
		super();
		this.id_Producto_fk = id_Producto_fk;
		this.id_Compra_fk = id_Compra_fk;
		this.id_Venta_fk = id_Venta_fk;
		this.stock = stock;
	}

	public InventarioDTO() {
		super();
	}

	public Integer getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public Producto getId_Producto_fk() {
		return id_Producto_fk;
	}

	public void setId_Producto_fk(Producto id_Producto_fk) {
		this.id_Producto_fk = id_Producto_fk;
	}

	public Compra getId_Compra_fk() {
		return id_Compra_fk;
	}

	public void setId_Compra_fk(Compra id_Compra_fk) {
		this.id_Compra_fk = id_Compra_fk;
	}

	public Venta getId_Venta_fk() {
		return id_Venta_fk;
	}

	public void setId_Venta_fk(Venta id_Venta_fk) {
		this.id_Venta_fk = id_Venta_fk;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
