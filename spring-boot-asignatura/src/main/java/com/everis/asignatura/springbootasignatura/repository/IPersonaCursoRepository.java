package com.everis.asignatura.springbootasignatura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.asignatura.springbootasignatura.mapper.Persona;

public interface IPersonaCursoRepository extends JpaRepository<Persona, Integer>{
	
	List<Persona> findByCursos_IdCurso(Integer IdCurso);
	

		
}
 