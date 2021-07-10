package com.everis.asignatura.springbootasignatura.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.asignatura.springbootasignatura.controller.model.NotasRest;
import com.everis.asignatura.springbootasignatura.mapper.Notas;
import com.everis.asignatura.springbootasignatura.repository.IPersonaCursosNotasRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class NotasControler {

	@Autowired
	private IPersonaCursosNotasRepository notasRepository;

	// Para guardar nota, está creando un nuevo registro,

	@PostMapping("/notas") // {idPersona}/{idCurso}/
	public Notas save(@RequestBody Notas notas) {
		return notasRepository.save(notas);

	}

	// devuelve idNota, nota y fechaRendida
	@GetMapping("/cursos/{idCurso}/personas/{idPersona}")
	public List<NotasRest> findPersonaCurso(@PathVariable Integer idCurso, @PathVariable Integer idPersona) {

		List<Notas> notas = notasRepository.findByCurso_IdCursoAndPersona_IdPersona(idCurso, idPersona);

		List<NotasRest> listNotasRest = new ArrayList<>();

		notas.stream().forEach(nota -> {
			// nota.get
			NotasRest newNotasRest = new NotasRest();
			
			Date date =  new Date();
			date.setTime(nota.getFechaRendida().getTime());
			String fecha =  new SimpleDateFormat("yy-MM-dd HH:mm").format(date);
			
			newNotasRest.setFechaRendida(fecha);
			newNotasRest.setNota(nota.getNota());
			newNotasRest.setIdNota(nota.getIdNota());

			listNotasRest.add(newNotasRest);

		});

		return listNotasRest;
	}
	


	// Para eliminar nota, esta eliminando persona y notas
	@DeleteMapping("/notas/{idNota}")
	public ResponseEntity<HttpStatus> deleteNota(@PathVariable("idNota") Integer idNota) {
		try {
			notasRepository.deleteById(idNota);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

		//editar notas
	@PutMapping("/notas/{idNota}")
	public ResponseEntity<HttpStatus> updateNota(@PathVariable("idNota") Integer idNota, @RequestBody Notas nota) {
		try {
			Notas currentNota = notasRepository.findById(idNota).orElseThrow(RuntimeException::new);

			currentNota.setIdNota(idNota);
			currentNota.setNota(nota.getNota());
			notasRepository.save(currentNota);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
