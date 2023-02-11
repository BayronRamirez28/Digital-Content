package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.ICategoria;
import com.DigitalContentV2.DigitalContentv2.modelo.Categoria;
import com.DigitalContentV2.DigitalContentv2.repository.CategoriaRepository;

@Service
public class Categoriadao implements ICategoria {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> encontrarTodo() {
		return this.categoriaRepository.findAll();
	}

	@Override
	public Categoria encontrarId(Integer idCategoria) {
		return this.categoriaRepository.getReferenceById(idCategoria);
	}

	@Override
	public void crear(Categoria categoria) {
		this.categoriaRepository.save(categoria);
	}

	@Override
	public void actualizar(Categoria categoria) {
		this.categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> encontrarporEstado() {
		return this.categoriaRepository.buscarEstado();
	}

	@Override
	public void eliminar(Integer idCategoria) {
		categoriaRepository.deleteById(idCategoria);
		
	}

	@Override
	public void actualizarEstado(Categoria categoria) {
		this.categoriaRepository.save(categoria);
	
	}

}
