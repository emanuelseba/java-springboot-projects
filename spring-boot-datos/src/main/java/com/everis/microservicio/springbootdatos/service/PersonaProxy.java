package com.everis.microservicio.springbootdatos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.microservicio.springbootdatos.dto.PersonaDTO;


@FeignClient(name = "persona-service", url="http://localhost:8000")
public interface PersonaProxy {
	
	@GetMapping("/find/{username}")
	PersonaDTO findUsuario(@PathVariable("username") String username);

}
