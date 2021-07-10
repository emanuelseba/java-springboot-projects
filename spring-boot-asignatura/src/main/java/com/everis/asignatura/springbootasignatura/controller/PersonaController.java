package com.everis.asignatura.springbootasignatura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.asignatura.springbootasignatura.controller.model.PersonasRest;
import com.everis.asignatura.springbootasignatura.mapper.Persona;
import com.everis.asignatura.springbootasignatura.repository.IAsignaturaRepository;
import com.everis.asignatura.springbootasignatura.repository.IPersonaRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PersonaController {

	@Autowired
	private IAsignaturaRepository repository;

	@Autowired
	private IPersonaRepository repositoryPersona;
	
	//guarda una lista de personas en Persona
	@PostMapping("/personas/saveall")
	public List<Persona> save(@RequestBody List<Persona> ListaPersona) {
		return repository.saveAll(ListaPersona);
	}

		
	
	//devuelve la tabla Persona, buscando por ID y que devuelva solo en mobre y apellido
	@GetMapping("/personas/{idPersona}")
	public PersonasRest findCurso(@PathVariable Integer idPersona) {

		Persona profesor = repositoryPersona.findByIdPersona(idPersona);

		//Curso curso = repositoryPersona.findById(idPersona).get();

		PersonasRest newPersonaRest = new PersonasRest();
		newPersonaRest.setIdPersona(profesor.getIdPersona());
		newPersonaRest.setNombre(profesor.getNombre());
		newPersonaRest.setApellido(profesor.getApellido());
		//newCursoRest.setNombreCurso(curso.getNombre());

		return newPersonaRest;
	}
	

	@DeleteMapping("/personas/{idPersona}")
	public ResponseEntity<HttpStatus> deletePersona(@PathVariable("idPersona") Integer idPersona) {
		try {
			repositoryPersona.deleteById(idPersona);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
