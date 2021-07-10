package com.everis.asignatura.springbootasignatura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.asignatura.springbootasignatura.mapper.Notas;

public interface IPersonaCursosNotasRepository extends JpaRepository<Notas, Integer> {

	List<Notas> findByCurso_IdCursoAndPersona_IdPersona(Integer IdCurso, Integer idPersona);

	List<Notas> findByPersona_IdPersona(Integer IdCurso);

}
