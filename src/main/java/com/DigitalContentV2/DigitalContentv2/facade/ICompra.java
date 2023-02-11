package com.DigitalContentV2.DigitalContentv2.facade;

import java.util.List;

import com.DigitalContentV2.DigitalContentv2.dto.CompraDTO;
import com.DigitalContentV2.DigitalContentv2.modelo.Compra;

public interface ICompra {

	public List<Compra> encontrarTodo();
	public Compra encontrarId(Integer idCompra);
	public void crear(Compra compra);
	public void actualizar(Compra compra);
	public void eliminar(Compra compra);
	public Compra save(CompraDTO compraDTO);
	
}
