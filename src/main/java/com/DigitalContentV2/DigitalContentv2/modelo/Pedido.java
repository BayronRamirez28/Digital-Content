package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
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
@Table(name = "pedido")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;
	
	@Column(name = "precio", nullable = false)
	private float precio;
	
	@Column(name = "fecha", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "detalle_pedido", joinColumns = @JoinColumn(name = "id_Pedido_fk"), inverseJoinColumns = @JoinColumn(name = "id_Producto_fk"))
	private List<Producto> producto = new ArrayList<Producto>();
	
	@ManyToOne
	@JoinColumn(name = "id_Usuario_fk")
	private Usuario id_Usuario_fk;
	
	@OneToMany(mappedBy = "id_Pedido_fk")
	private List<Entrega> entrega;
}
