package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Cardao;
import com.DigitalContentV2.DigitalContentv2.modelo.Car_items;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@Controller
public class CarController {

	@Autowired
	private Cardao cardao;

	@GetMapping("/carrito")
	public String carritoCompras(Model modelo, HttpSession session) {
		Usuario logueado = (Usuario) session.getAttribute("usersession");
		List<Car_items> cartItems = cardao.listCarItems(logueado);
		modelo.addAttribute("cartItems", cartItems);
		modelo.addAttribute("pageTitle", "ShoppingCart");
		return "/car";
	}
} 
