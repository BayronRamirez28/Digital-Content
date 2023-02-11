package com.DigitalContentV2.DigitalContentv2.dto;

public class RolRegistroS {

	private Integer idRol;
	private String nombre;
	private String estado;

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public RolRegistroS(Integer idRol) {
		super();
		this.idRol = idRol;
	}
	
	

}
