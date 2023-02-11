package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.dto.CompraDTO;
import com.DigitalContentV2.DigitalContentv2.facade.ICompra;
import com.DigitalContentV2.DigitalContentv2.modelo.Compra;
import com.DigitalContentV2.DigitalContentv2.modelo.Inventario;
import com.DigitalContentV2.DigitalContentv2.repository.CompraRepository;
import com.DigitalContentV2.DigitalContentv2.repository.InventarioRepository;

@Service
public class Compradao implements ICompra {

	@Autowired
	private InventarioRepository inventarioRepository;

	@Autowired
	private CompraRepository compraRepository;

	@Override
	public List<Compra> encontrarTodo() {
		return this.compraRepository.findAll();
	}

	@Override
	public void crear(Compra compra) {
		this.compraRepository.save(compra);
	}

	@Override
	public void actualizar(Compra compra) {
		this.compraRepository.save(compra);
	}
	@Override
	public void eliminar(Compra compra) {
		this.compraRepository.save(compra);
	}

	@Override
	public Compra encontrarId(Integer idCompra) {
		return this.compraRepository.getReferenceById(idCompra);
	}

	@Override
	public Compra save(CompraDTO compraDTO) {
		Compra compra = new Compra(compraDTO.getFecha(), compraDTO.getCantidad(), compraDTO.getPrecioU(),
				compraDTO.getInventario(), compraDTO.getId_Producto_fk());
		Inventario inventario = new Inventario();
		inventario.setId_Compra_fk(compra);
		inventario.setStock(compraDTO.getCantidad());
		inventario.setId_Producto_fk(compraDTO.getId_Producto_fk());
		
		this.inventarioRepository.save(inventario);
		return this.compraRepository.save(compra);
	}

}
