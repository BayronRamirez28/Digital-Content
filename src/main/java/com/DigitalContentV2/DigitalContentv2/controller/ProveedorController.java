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

import com.DigitalContentV2.DigitalContentv2.facadeImp.Proveedordao;
import com.DigitalContentV2.DigitalContentv2.modelo.Proveedor;


@Controller
@RequestMapping("/admin/")
public class ProveedorController {
	
	@Autowired
	private Proveedordao proveedorDao; 
	
	@GetMapping({"/proveedor"})
	public String allProveedor(Model modelo) {
		
		List<Proveedor> lstProveedor = this.proveedorDao.encontrarporEstado();
		modelo.addAttribute("listaP", lstProveedor);
		return "Administration/Aproveedor/proveedor";
	}
	
	@GetMapping("/proveedor/nuevoP")
	public String formularioCrear(Model modelo) {
		
		modelo.addAttribute("proveedorN",new Proveedor());
		return "Administration/Aproveedor/formulario_cp";
	}
	
	
	@PostMapping("/proveedor")
	public String crearProveedor(@ModelAttribute("proveedorN") Proveedor proveedor) {
		proveedorDao.crear(proveedor);
		return "redirect:/admin/proveedor";
	}
	
	@GetMapping("/proveedor/editar/{idProveedor}")
	public String formularioModificarP(@PathVariable("idProveedor") Integer idProveedor, Model modelo) {
		
		Proveedor proveedor = proveedorDao.encontrarId(idProveedor);
		modelo.addAttribute("proveedor", proveedor);
		
		return "Administration/Aproveedor/formulario_ep";
	}

	
	@GetMapping("/proveedor/eliminar/{idProveedor}")
	private String eliminarProveedor(@PathVariable("idProveedor") Integer idProveedor) {
		
		Proveedor proveedor = proveedorDao.encontrarId(idProveedor);
		
		proveedor.setEstado("Inactivo");
		this.proveedorDao.actualizarEstado(proveedor);
		return "redirect:/admin/proveedor";
	}
}
