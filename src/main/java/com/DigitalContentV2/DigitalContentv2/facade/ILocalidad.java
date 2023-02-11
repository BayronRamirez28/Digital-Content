package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.modelo.Localidad;

public interface ILocalidad {

	public List<Localidad> encontrarTodo();
	public Localidad encontrarId(Integer idLocalidad);
	public void crear(Localidad localidad);
	public void actualizar(Localidad localidad);
	public void eliminar(Localidad localidad);
}
