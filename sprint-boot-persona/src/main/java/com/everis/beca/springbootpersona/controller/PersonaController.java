package com.everis.beca.springbootpersona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.beca.springbootpersona.mapper.Persona;
import com.everis.beca.springbootpersona.repository.IPersonaRepository;

/**
 * The Class PersonaController.
 */
@RestController
public class PersonaController {
	/** The repository. */
	@Autowired
	private IPersonaRepository repository;

	/**
	 * Find usuario.
	 *
	 * @param username the username
	 * @return the persona
	 */
	@GetMapping("/find/{username}")
	public Persona findUsuario(@PathVariable("username") String username) {
		return repository.findByUsername(username);
	}
	
	/**
	 * Save.
	 *
	 * @param persona the persona
	 * @return the persona
	 */
	@PostMapping("/save")
	public Persona save(@RequestBody Persona persona) {
		return repository.save(persona);
	}
	
	@GetMapping("/findApellido/{apellido}")
	public List<Persona> findApellido(@PathVariable("apellido") String apellido) {
		return repository.findByApellido(apellido); 
	}
	
	@GetMapping("/findDireccion/{direccion}")
	public List<Persona> findDireccion(@PathVariable("direccion") String direccion){
	return repository.findByDireccion(direccion);
	}
	
	
}
