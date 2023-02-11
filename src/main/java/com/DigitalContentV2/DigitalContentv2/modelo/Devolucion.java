package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

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

@Entity
@Table(name = "devolucion")
public class Devolucion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDevolucion;
	
	@Column(name = "descripcion", nullable = false, length = 200)
	private String descripcion;
	
	@Column(name = "fecha", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	
	/*
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "detalle_Devolucion", joinColumns = @JoinColumn(name = "id_Devolucion_fk"), inverseJoinColumns = @JoinColumn(name = "id_Producto_fk"))
	private List<Producto> producto = new ArrayList<Producto>();
	*/
	
	@ManyToOne
	@JoinColumn(name = "id_Producto_fk")
	private Producto id_Producto_fk;
	
	}
