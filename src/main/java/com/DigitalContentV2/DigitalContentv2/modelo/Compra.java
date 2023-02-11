package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "precioU", nullable = false)
	private Long precioU;

	@OneToMany(mappedBy = "id_Compra_fk", cascade = CascadeType.ALL)
	private List<Inventario> inventario;

	@ManyToOne
	@JoinColumn(name = "id_Producto_fk")
	private Producto id_Producto_fk;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Compra(Date fecha, Integer cantidad, Long precioU, List<Inventario> inventario, Producto id_Producto_fk) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.precioU = precioU;
		this.inventario = inventario;
		this.id_Producto_fk = id_Producto_fk;
	}

	public Compra(Integer idCompra, Integer cantidad, Producto id_Producto_fk) {
		super();
		this.idCompra = idCompra;
		this.cantidad = cantidad;
		this.id_Producto_fk = id_Producto_fk;
	}

	public Compra() {
		super();
	}

}
