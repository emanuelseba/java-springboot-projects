package com.everis.microservicio.springbootdatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.microservicio.springbootdatos.dto.Datos;
import com.everis.microservicio.springbootdatos.service.DatosService;
@RestController
public class DatosController {
	@Autowired
	private DatosService datosService;
	
	@GetMapping("/find/{username}")
	public Datos getDatos(@PathVariable("username") String username) {
		return datosService.getDatos(username);
	}

}
