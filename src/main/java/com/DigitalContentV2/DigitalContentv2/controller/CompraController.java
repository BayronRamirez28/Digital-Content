package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DigitalContentV2.DigitalContentv2.dto.CompraDTO;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Compradao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Productodao;
import com.DigitalContentV2.DigitalContentv2.modelo.Compra;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;

@RequestMapping("/admin")
@Controller
public class CompraController {

	@Autowired
	private Compradao compraDao;
	
	@Autowired
	private Productodao productoDao;
	
	@GetMapping("/compra")
	public String listaCompras(Model modelo) {
		List<Compra> lstCompra = this.compraDao.encontrarTodo();
		modelo.addAttribute("listC",lstCompra);
		return "Administration/Acompra/compra";
	}
	
	@GetMapping("/compra/nuevoC")
	public String formularioCompras(Model modelo) {
		List<Producto> lstPro = productoDao.encontrarEstado();
		List<Producto> lstPro2 = productoDao.encontrarEstado();
		
		modelo.addAttribute("lstPro", lstPro);
		modelo.addAttribute("lstPro2", lstPro2);
		modelo.addAttribute("compraN", new Compra());
		return "Administration/Acompra/formulario_cc";
	}
	
	@PostMapping("/compra")
	public String crearCompra(@ModelAttribute("compraN") CompraDTO compraDTO) {
		compraDao.save(compraDTO);
		return "redirect:/admin/compra";
	}
	
}
