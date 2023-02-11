package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Barriodao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Localidaddao;
import com.DigitalContentV2.DigitalContentv2.modelo.Barrio;
import com.DigitalContentV2.DigitalContentv2.modelo.Localidad;

@RequestMapping("/admin")
@Controller
public class BarrioController {

	@Autowired
	private Barriodao barrioDao;

	@Autowired	
	private Localidaddao localidadDao;
	
	@GetMapping("/barrio")
	public String allBarrio(Model modelo) {

		List<Barrio> lstBarrio = this.barrioDao.encontrarporEstado();
		modelo.addAttribute("listaB", lstBarrio);
		return "Administration/Abarrio/barrio";
	}

	@GetMapping("/barrio/nuevoB")
	public String formularioCrear(Model modelo) {
		List<Localidad> lstLoc = localidadDao.encontrarTodo();
		
		modelo.addAttribute("lstLoc", lstLoc);
		modelo.addAttribute("barrioN",new Barrio());
		return "Administration/Abarrio/formulario_cb";
	}

	@PostMapping("/barrio")
	public String crearBarrio(@ModelAttribute("barrioN") Barrio barrio) {
		barrioDao.crear(barrio);
		return "redirect:/admin/barrio";
	}
	
	@GetMapping("/barrio/editar/{idBarrio}")
	public String formularioModificarB(@PathVariable("idBarrio") Integer idBarrio, Model modelo){
		
		Barrio barrio = barrioDao.encontrarId(idBarrio);
		modelo.addAttribute("barrio",barrio);
		
		List<Localidad> lstLoc = localidadDao.encontrarTodo();
		modelo.addAttribute("localidad",lstLoc);
		return "Administration/Abarrio/formulario_eb";
	}
	
	@GetMapping("/barrio/eliminar/{idBarrio}")
	public String eliminarBarrio(@PathVariable("idBarrio") Integer idBarrio, Model modelo){
		barrioDao.eliminar(idBarrio);	
		return "redirect:/admin/barrio";
	}
	
	@GetMapping("/barrio/eliminare/{idBarrio}")
	private String eliminarProducto(@PathVariable("idBarrio") Integer idBarrio) {
		
		Barrio barrio = barrioDao.encontrarId(idBarrio);
		
		barrio.setEstado("Inactivo");
		this.barrioDao.actualizarEstado(barrio);
		return "redirect:/barrio";
	}
}
