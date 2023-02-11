package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;
	
	@Column(name = "nombre", nullable = false, length = 40)
	private String nombre;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuario = new ArrayList<Usuario>();

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Rol(Integer idRol, String nombre, List<Usuario> usuario) {
		super();
		this.idRol = idRol;
		this.nombre = nombre;
		this.usuario = usuario;
	}
	
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Rol(Integer idRol) {
		super();
		this.idRol = idRol;
	}

	public Rol() {
		super();
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
