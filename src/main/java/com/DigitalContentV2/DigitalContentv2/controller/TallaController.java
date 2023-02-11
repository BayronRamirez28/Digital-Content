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

import com.DigitalContentV2.DigitalContentv2.facadeImp.Talladao;
import com.DigitalContentV2.DigitalContentv2.modelo.Talla;

@RequestMapping("/admin")
@Controller
public class TallaController {
	
	@Autowired
	private Talladao tallaDao;
	
	@GetMapping({"/talla"})
	public String allTalla(Model modelo) {
		List<Talla> lstTalla = this.tallaDao.encontrarTodo();
		modelo.addAttribute("listaB", lstTalla);
		return "/Atalla/talla";
	}
	
	@PostMapping("/talla")
	public String crearTalla(@ModelAttribute("tallaN") Talla talla) {
		tallaDao.crear(talla);
		return "redirect:/talla";
	}
	
	@GetMapping("/talla/editar/{idTalla}")
	public String formularioModificarT(@PathVariable("idTalla") Integer idTalla, Model modelo){
		
		Talla talla = tallaDao.encontrarId(idTalla);
		modelo.addAttribute("talla",talla);
		return "Atalla/formulario_et";
	}
	
	@GetMapping("/talla/eliminar/{idTalla}")
	public String eliminarTalla(@PathVariable("idTalla") Integer idTalla, Model modelo){
		tallaDao.eliminar(idTalla);	
		return "redirect:/talla";
	}
	
	@GetMapping("/talla/eliminare/{idTalla}")
	private String eliminarTalla(@PathVariable("idTalla") Integer idTalla) {
		
		Talla talla = tallaDao.encontrarId(idTalla);
		
		talla.setEstado("Inactivo");
		this.tallaDao.actualizarEstado(talla);
		return "redirect:/talla";
	}
	

}
