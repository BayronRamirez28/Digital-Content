package com.DigitalContentV2.DigitalContentv2.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigitalContentV2.DigitalContentv2.facade.IBarrio;
import com.DigitalContentV2.DigitalContentv2.modelo.Barrio;
import com.DigitalContentV2.DigitalContentv2.repository.BarrioRepository;

@Service
public class Barriodao implements IBarrio{

	@Autowired
	private BarrioRepository barrioRepository;
	
	@Override
	public List<Barrio> encontrarTodo() {
		
		return this.barrioRepository.findAll();
	}

	@Override
	public void crear(Barrio barrio) {
		this.barrioRepository.save(barrio);
		
	}

	@Override
	public void actualizar(Barrio barrio) {
		this.barrioRepository.save(barrio);
		
	}

	@Override
	public Barrio encontrarId(Integer idBarrio) {
		return this.barrioRepository.getReferenceById(idBarrio);
	}

	@Override
	public void eliminar(Integer idBarrio) {
		barrioRepository.deleteById(idBarrio);
		
	}

	@Override
	public void actualizarEstado(Barrio barrio) {
		this.barrioRepository.save(barrio);
	}

	@Override
	public List<Barrio> encontrarporEstado() {
		return this.barrioRepository.buscarEstado();
	}

}
