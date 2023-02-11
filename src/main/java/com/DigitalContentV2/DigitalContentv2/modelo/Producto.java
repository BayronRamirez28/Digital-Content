package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;

	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_Categoria_fk")
	private Categoria id_Categoria_fk;

	@ManyToOne
	@JoinColumn(name = "id_Talla_fk")
	private Talla id_Talla_fk;

	@ManyToOne
	@JoinColumn(name = "id_Color_fk")
	private Color id_Color_fk;

	@Column(name = "precio", nullable = false)
	private float precio;

	@ManyToOne
	@JoinColumn(name = "id_Genero_fk")
	private Genero id_Genero_fk;

	@Column(name = "foto", nullable = false, length = 200)
	private String foto;

	@Column(name = "estado", nullable = false)
	private String estado;

	/*
	 * @ManyToMany(mappedBy = "producto") private List<Devolucion> devolucion = new
	 * ArrayList<Devolucion>();
	 */

	@ManyToMany(mappedBy = "producto")
	private List<Pedido> pedido = new ArrayList<Pedido>();

	@OneToMany(mappedBy = "id_Producto_fk")
	private List<Inventario> inventario;

	@OneToMany(mappedBy = "id_Producto_fk")
	private List<Devolucion> devolucion;
	
	@OneToMany(mappedBy = "id_Producto_fk")
	private List<Compra> compra;
	
	@OneToMany(mappedBy = "id_Producto_fk")
	private List<Venta> venta;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getId_Categoria_fk() {
		return id_Categoria_fk;
	}

	public void setId_Categoria_fk(Categoria id_Categoria_fk) {
		this.id_Categoria_fk = id_Categoria_fk;
	}

	public Talla getId_Talla_fk() {
		return id_Talla_fk;
	}

	public void setId_Talla_fk(Talla id_Talla_fk) {
		this.id_Talla_fk = id_Talla_fk;
	}

	public Color getId_Color_fk() {
		return id_Color_fk;
	}

	public void setId_Color_fk(Color id_Color_fk) {
		this.id_Color_fk = id_Color_fk;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Genero getId_Genero_fk() {
		return id_Genero_fk;
	}

	public void setId_Genero_fk(Genero id_Genero_fk) {
		this.id_Genero_fk = id_Genero_fk;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public List<Inventario> getInventario() {
		return inventario;
	}

	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}

	public List<Devolucion> getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(List<Devolucion> devolucion) {
		this.devolucion = devolucion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
