package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "talla")
public class Talla implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTalla;
	
	@Column(name = "nombreTalla", nullable = false, length = 70)
	private String nombreTalla;
	
	@Column(name = "estado", nullable = false, length = 70)
	private String estado;
	
	@OneToMany(mappedBy = "id_Talla_fk")
	private List<Producto> producto;

	public Integer getIdTalla() {
		return idTalla;
	}

	public void setIdTalla(Integer idTalla) {
		this.idTalla = idTalla;
	}

	public String getNombreTalla() {
		return nombreTalla;
	}

	public void setNombreTalla(String nombreTalla) {
		this.nombreTalla = nombreTalla;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
