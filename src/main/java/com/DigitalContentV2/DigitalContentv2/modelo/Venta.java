package com.DigitalContentV2.DigitalContentv2.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "precio", nullable = false)
	private float precio;
	
	@Column(name = "fecha", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "detalle_venta", joinColumns = @JoinColumn(name = "id_Venta_fk"), inverseJoinColumns = @JoinColumn(name = "id_Entreda_fk"))
	private List<Entrega> entrega = new ArrayList<Entrega>();
	
	@OneToMany(mappedBy = "id_Venta_fk")
	private List<Inventario> inventario;
	
	@ManyToOne
	@JoinColumn(name = "id_Producto_fk")
	private Producto id_Producto_fk;
}
