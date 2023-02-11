package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.modelo.Barrio;

public interface IBarrio {

	public List<Barrio> encontrarTodo();
	public List<Barrio> encontrarporEstado();
	public Barrio encontrarId(Integer idBarrio);
	public void crear(Barrio barrio);
	public void actualizar(Barrio barrio);
	public void eliminar(Integer idBarrio); 
	public void actualizarEstado(Barrio barrio);
	
}
