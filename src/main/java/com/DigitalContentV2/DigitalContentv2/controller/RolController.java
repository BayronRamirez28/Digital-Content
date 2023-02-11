package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Roldao;

import com.DigitalContentV2.DigitalContentv2.modelo.Rol;

@Controller
public class RolController {

	@Autowired
	private Roldao rolDao;

	
	@GetMapping({"/rol"})
	public String allRol(Model modelo) {

		List<Rol> lstRol = this.rolDao.encontrarporEstado();
		modelo.addAttribute("listaR", lstRol);
		return "/Arol/rol";
	}

	@GetMapping("/rol/nuevoR")
	public String formularioCrear(Model modelo) {
		
		modelo.addAttribute("rolN",new Rol());
		return "Arol/formulario_cr";
	}

	@PostMapping("/rol")
	public String crearRol(@ModelAttribute("rolN") Rol rol) {
		rolDao.crear(rol);
		return "redirect:/rol";
	}
	
	@GetMapping("/rol/editar/{idRol}")
	public String formularioModificarB(@PathVariable("idRol") Integer idRol, Model modelo){
		
		Rol rol = rolDao.encontrarId(idRol);
		modelo.addAttribute("rol",rol);
		
		return "Arol/formulario_er";
	}
	
	@GetMapping("/rol/eliminar/{idRol}")
	public String eliminarRol(@PathVariable("idRol") Integer idRol, Model modelo){
		rolDao.eliminar(idRol);	
		return "redirect:/rol";
	}
	
	@GetMapping("/rol/eliminare/{idRol}")
	private String eliminarRol(@PathVariable("idRol") Integer idRol) {
		
		Rol rol = rolDao.encontrarId(idRol);
		this.rolDao.actualizarEstado(rol);
		return "redirect:/rol";
	}
}


