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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "localidad")
public class Localidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLocalidad;
	
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id_localidad_fk")
	private List<Barrio> barrio;

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Barrio> getBarrio() {
		return barrio;
	}

	public void setBarrio(List<Barrio> barrio) {
		this.barrio = barrio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
