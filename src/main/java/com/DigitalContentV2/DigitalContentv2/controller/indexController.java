package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Categoriadao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Colordao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Generodao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Productodao;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Talladao;
import com.DigitalContentV2.DigitalContentv2.modelo.Categoria;
import com.DigitalContentV2.DigitalContentv2.modelo.Color;
import com.DigitalContentV2.DigitalContentv2.modelo.Genero;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;
import com.DigitalContentV2.DigitalContentv2.modelo.Talla;

@Controller
public class indexController {

	@Autowired
	private Productodao productoDao;
	
	@Autowired
	private Colordao colorDao;
	
	@Autowired
	private Categoriadao categoriaDao;
	
	@Autowired
	private Talladao tallaDao;
	
	@Autowired
	private Generodao generoDao;
	
	@GetMapping("/detail-product/{idProducto}")
	public String cantidadP(@PathVariable("idProducto") Integer idProducto, Model modelo) {
		Producto producto = productoDao.encontrarId(idProducto);
		modelo.addAttribute("producto", producto);
		
		List<Categoria> lstCat = categoriaDao.encontrarTodo();
		List<Talla> lstTalla = tallaDao.encontrarTodo();
		List<Color> lstCol = colorDao.encontrarTodo();
		List<Genero> lstGen = generoDao.encontrarTodo();
		
		modelo.addAttribute("lstCat", lstCat);
		modelo.addAttribute("lstTalla", lstTalla);
		modelo.addAttribute("lstCol", lstCol);
		modelo.addAttribute("lstGen", lstGen);
		return "Administration/Aproducto/detailP";
	}
}
