package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.modelo.Entrega;

public interface IEntrega {

	public List<Entrega> encontrarTodo();
	public void crear(Entrega entrega);
	public void actualizar(Entrega entrega);
	public void eliminar(Entrega entrega);
	
}
