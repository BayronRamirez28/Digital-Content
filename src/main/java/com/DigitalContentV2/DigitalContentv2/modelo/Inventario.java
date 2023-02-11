package com.DigitalContentV2.DigitalContentv2.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInventario;

	@ManyToOne
	@JoinColumn(name = "id_Producto_fk")
	private Producto id_Producto_fk;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Compra_fk")
	private Compra id_Compra_fk;

	@ManyToOne
	@JoinColumn(name = "id_Venta_fk")
	private Venta id_Venta_fk;

	@Column(name = "stock", nullable = false)
	private Integer stock;

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

	public Inventario(Producto id_Producto_fk, Compra id_Compra_fk, Venta id_Venta_fk, Integer stock) {
		super();
		this.id_Producto_fk = id_Producto_fk;
		this.id_Compra_fk = id_Compra_fk;
		this.id_Venta_fk = id_Venta_fk;
		this.stock = stock;
	}

	public Inventario(Venta id_Venta_fk) {
		super();
		this.id_Venta_fk = id_Venta_fk;
	}

	public Inventario(Producto id_Producto_fk) {
		super();
		this.id_Producto_fk = id_Producto_fk;
	}

	public Inventario(Compra id_Compra_fk) {
		super();
		this.id_Compra_fk = id_Compra_fk;
	}

	public Inventario(Producto id_Producto_fk, Venta id_Venta_fk, Integer stock) {
		super();
		this.id_Producto_fk = id_Producto_fk;
		this.id_Venta_fk = id_Venta_fk;
		this.stock = stock;
	}

	public Inventario() {
		super();
	}
	
}
