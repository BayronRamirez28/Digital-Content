package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.IGenero;
import com.DigitalContentV2.DigitalContentv2.modelo.Genero;
import com.DigitalContentV2.DigitalContentv2.repository.GeneroRepository;

@Service
public class Generodao implements IGenero {

	@Autowired
	private GeneroRepository generoRepository;
	
	@Override
	public List<Genero> encontrarTodo() {
		return this.generoRepository.findAll() ;
	}

	@Override
	public Genero encontrarId(Integer idGenero) {
		return this.generoRepository.getReferenceById(idGenero);
	}

	@Override
	public void crear(Genero genero) {
		this.generoRepository.save(genero);
	}

	@Override
	public void actualizar(Genero genero) {
		this.generoRepository.save(genero);
	}

	@Override
	public List<Genero> encontrarporEstado() {
		return this.generoRepository.buscarEstado();
	}

	@Override
	public void eliminar(Integer idGenero) {
		generoRepository.deleteById(idGenero);
		
	}

	@Override
	public void actualizarEstado(Genero genero) {
		this.generoRepository.save(genero);
		
	}

}
