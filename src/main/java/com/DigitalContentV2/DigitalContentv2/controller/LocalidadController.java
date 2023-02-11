package com.DigitalContentV2.DigitalContentv2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DigitalContentV2.DigitalContentv2.facadeImp.Localidaddao;
import com.DigitalContentV2.DigitalContentv2.modelo.Localidad;

@Controller
@RequestMapping(path = "/localidad/")
public class LocalidadController {

	@Autowired
	private Localidaddao localidadDao;

	@GetMapping("/all")
	public ResponseEntity<Map<String,Object>> allLocalidad(){
		Map<String,Object> respon=new HashMap<String,Object>();
		
		try {
			List<Localidad> lstloc=this.localidadDao.encontrarTodo();
			respon.put("Message", "Listado Correctamente");
			respon.put("data", lstloc);
			respon.put("Status", HttpStatus.OK);
		} catch (Exception e) {
			respon.put("Message", "Listado Fallido");
			respon.put("Status", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(respon,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(respon,HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createLocalidad(
			@RequestBody Map<String, Object>request){
		
		Map<String, Object> respon = new HashMap<String, Object>();
		
		try {
			Localidad loc = new Localidad();
			loc.setNombre((String) request.get("nombre"));
			
			respon.put("Message", "Se Creó correctamente");
			respon.put("data", request);
			respon.put("Status", HttpStatus.OK);
			this.localidadDao.crear(loc);
		} catch (Exception e) {
			respon.put("Message", "Error al crear");
			respon.put("Status", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(respon,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(respon,HttpStatus.OK);
	}
	
	@GetMapping(path = "/update/{idLocalidad}")
	public ResponseEntity<Map<String, Object>> updateLocalidad(
			@PathVariable String idLocalidad,
			@RequestBody Map<String, Object>request){
		Map<String, Object> respon = new HashMap<String, Object>();
		
		try {
			Localidad loc = this.localidadDao.encontrarId(Integer.parseInt(idLocalidad));
			
			loc.setNombre((String) request.get("nombre"));
			this.localidadDao.actualizar(loc);
			respon.put("Message", "Actualizado Correctamente");
			respon.put("data", request);
			respon.put("Status", HttpStatus.OK);
			
		} catch (Exception e) {
			respon.put("Message", "Actualizacion fallida");
			respon.put("Status", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(respon,HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(respon,HttpStatus.OK);
	}
	
	@GetMapping(path = "/delete/{idLocalidad}")
	public ResponseEntity<Map<String,Object>> elimiarLocalidad(
			@PathVariable String idLocalidad){
		Map<String, Object> respon = new HashMap<String, Object>();
		
		try {
			Localidad loc = this.localidadDao.encontrarId(Integer.parseInt(idLocalidad));
			this.localidadDao.eliminar(loc);
			respon.put("Message", "Eliminado Correctamente");
			List<Localidad> lstLoc = this.localidadDao.encontrarTodo();
			respon.put("data", lstLoc);
			respon.put("status", HttpStatus.OK);
		
		} catch (Exception e) {
			respon.put("Message", "Proceso fallido");
			respon.put("status", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(respon, HttpStatus.BAD_REQUEST);
		}	
		
		return new ResponseEntity<>(respon, HttpStatus.OK);
	}	
}