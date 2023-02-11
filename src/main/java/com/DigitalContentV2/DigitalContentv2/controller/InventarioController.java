package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Inventariodao;
import com.DigitalContentV2.DigitalContentv2.modelo.Inventario;

@RequestMapping("/admin")
@Controller
public class InventarioController {

	@Autowired
	private Inventariodao inventariodao;
	
	@GetMapping("/inventario")
	public String listarInventario(Model modelo) {
		List<Inventario> lstIn = this.inventariodao.listarContado();
		modelo.addAttribute("lstIn", lstIn);
		return "Administration/Ainventario/inventario";
	}
}
