package com.everis.asignatura.springbootasignatura.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.asignatura.springbootasignatura.controller.model.CursoRest;
import com.everis.asignatura.springbootasignatura.controller.model.PersonasRest;
import com.everis.asignatura.springbootasignatura.mapper.Curso;
import com.everis.asignatura.springbootasignatura.mapper.Notas;
import com.everis.asignatura.springbootasignatura.mapper.Persona;
import com.everis.asignatura.springbootasignatura.repository.ICursosRepository;
import com.everis.asignatura.springbootasignatura.repository.IPersonaCursoRepository;
import com.everis.asignatura.springbootasignatura.repository.IPersonaCursosNotasRepository;
import com.everis.asignatura.springbootasignatura.repository.IPersonaRepository;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class CursoController {

	@Autowired
	private ICursosRepository repositoryCurso;

	@Autowired
	private IPersonaCursoRepository repositoryPersonaCurso;

	@Autowired
	private IPersonaRepository repositoryPersona;

	@Autowired
	private IPersonaCursosNotasRepository notasRepository;

	// Muestra todos los cursos (6)
	@GetMapping("/cursos")
	public List<Curso> findCurso() {
		return repositoryCurso.findAll();
	}

	// Muestra el curso por ID
	// @GetMapping("/cursos/{id}")
	// public Curso findCursosByPersona(@PathVariable(value = "id") Integer idCurso)
	// {
	// return repositoryCurso.findById(idCurso).get();
	// return repositoryCurso.findByNombreAndCapacidad("nombre", 1);
	// }

	@GetMapping("/cursos/{idCurso}")
	public CursoRest findCurso(@PathVariable Integer idCurso) {

		Persona profesor = repositoryPersona.findByAsignacion_Curso_IdCurso(idCurso);

		Curso curso = repositoryCurso.findById(idCurso).get();

		CursoRest newCursoRest = new CursoRest();
		newCursoRest.setIdPersona(profesor.getIdPersona());
		newCursoRest.setNombreProfesor(profesor.getNombre() + " " + profesor.getApellido());
		newCursoRest.setNombreCurso(curso.getNombre());

		return newCursoRest;
	}

	// Muestra las personas en los cursos
	@GetMapping("/cursos/{idCurso}/personas")
	public List<PersonasRest> findPersonaCurso(@PathVariable Integer idCurso) {

		List<Persona> personas = repositoryPersonaCurso.findByCursos_IdCurso(idCurso);

		List<PersonasRest> listNotasRest = new ArrayList<>();

		personas.stream().forEach(persona -> {
			// nota.get
			PersonasRest newPersonasRest = new PersonasRest();
			newPersonasRest.setIdPersona(persona.getIdPersona());
			newPersonasRest.setNombre(persona.getNombre());
			newPersonasRest.setApellido(persona.getApellido());
			Integer idPersona = persona.getIdPersona();

			List<Notas> notas = notasRepository.findByCurso_IdCursoAndPersona_IdPersona(idCurso, idPersona);

			int suma = 0;
			for (int x = 0; x < notas.size(); x++) {

				suma = suma + notas.get(x).getNota();
			};
			newPersonasRest.setPromedio(suma / notas.size());

			listNotasRest.add(newPersonasRest);
		});

		return listNotasRest;
	}

}
