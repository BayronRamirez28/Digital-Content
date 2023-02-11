package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.IColor;
import com.DigitalContentV2.DigitalContentv2.modelo.Color;
import com.DigitalContentV2.DigitalContentv2.repository.ColorRepository;

@Service
public class Colordao implements IColor {

	@Autowired
	private ColorRepository colorRepository;
	
	@Override
	public List<Color> encontrarTodo() {
		return this.colorRepository.findAll();
	}

	@Override
	public Color encontrarId(Integer idColor) {
		return this.colorRepository.getReferenceById(idColor);
	}

	@Override
	public void crear(Color color) {
		this.colorRepository.save(color);
	}

	@Override
	public void actualizar(Color color) {
		this.colorRepository.save(color);
	}


	@Override
	public List<Color> encontrarporEstado() {
		return this.colorRepository.buscarEstado();
	}


	@Override
	public void actualizarEstado(Color color) {
		this.colorRepository.save(color);
		
	}

	@Override
	public void eliminar(Integer idColor) {
		colorRepository.deleteById(idColor);
		
	}

}
