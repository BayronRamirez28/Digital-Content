package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "entrega")
public class Entrega implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEntrega;
	
	@ManyToOne
	@JoinColumn(name = "id_Pedido_fk")
	private Pedido id_Pedido_fk;
	
	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "id_Barrio_fk")
	private Barrio id_Barrio_fk;
	
	@ManyToOne
	@JoinColumn(name = "id_Usuario_fk")
	private Usuario id_Usuario_fk;
	
	@Column(name = "fecha", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fecha;
	
	@ManyToMany(mappedBy = "entrega")
	private List<Venta> venta = new ArrayList<Venta>();
	
	@Column(name = "estado", nullable = false, length = 30)
	private String estado;

}
