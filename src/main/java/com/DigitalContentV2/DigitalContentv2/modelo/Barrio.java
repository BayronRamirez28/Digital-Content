package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
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

@Entity
@Table(name = "barrio")
public class Barrio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBarrio;
	
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@Column(name = "estado", nullable = false, length = 40)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_localidad_fk")
	private Localidad id_localidad_fk;
	
	@OneToMany(mappedBy = "id_Barrio_fk")
	private List<Usuario> persona;
	
	@OneToMany(mappedBy = "id_Barrio_fk")
	private List<Entrega> entrega;

	public Integer getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(Integer idBarrio) {
		this.idBarrio = idBarrio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Localidad getId_localidad_fk() {
		return id_localidad_fk;
	}

	public void setId_localidad_fk(Localidad id_localidad_fk) {
		this.id_localidad_fk = id_localidad_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}