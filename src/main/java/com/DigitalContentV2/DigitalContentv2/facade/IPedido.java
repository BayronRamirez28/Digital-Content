package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.modelo.Pedido;

public interface IPedido {

	public List<Pedido> encontrarTodo();
	public void crear(Pedido pedido);
	public void actualizar(Pedido pedido);
	public void eliminar(Pedido pedido);
}
