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

import com.DigitalContentV2.DigitalContentv2.facadeImp.Colordao;
import com.DigitalContentV2.DigitalContentv2.modelo.Color;

@RequestMapping("/admin/")
@Controller
public class ColorController {
	
	@Autowired
	private Colordao colorDao;
	
	@GetMapping("/color")
	public String allColor(Model modelo) {

		List<Color> lstColor = this.colorDao.encontrarporEstado();
		modelo.addAttribute("listaC", lstColor);
		return "Administration/Acolor/color";
	}
	
	@GetMapping("/color/nuevoC")
	public String formularioCrear(Model modelo) {
	
		modelo.addAttribute("colorN",new Color());
		return "Administration/Acolor/formulario_cc";
	}
	
	@PostMapping("/color")
	public String crearColor(@ModelAttribute("colorN") Color color) {
		colorDao.crear(color);
		return "redirect:/admin/color";
	}
	
	@GetMapping("/color/editar/{idColor}")
	public String formularioModificarC(@PathVariable("idColor") Integer idColor, Model modelo){
		
		Color color = colorDao.encontrarId(idColor);
		modelo.addAttribute("color",color);
		return "Administration/Acolor/formulario_ec";
	}
	
	@GetMapping("/color/eliminar/{idColor}")
	private String eliminarColor(@PathVariable("idColor") Integer idColor) {
		
		Color color = colorDao.encontrarId(idColor);
		
		color.setEstado("Inactivo");
		this.colorDao.actualizarEstado(color);
		return "redirect:/admin/color";
	}
	
	
}
