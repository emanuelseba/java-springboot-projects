package com.everis.asignatura.springbootasignatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.asignatura.springbootasignatura.mapper.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Integer> {

	Persona findByIdPersona(Integer IdPersona);
	//List<Persona> findByIdCurso(Integer IdCurso);

	Persona findByAsignacion_Curso_IdCurso(Integer idCurso);
}

