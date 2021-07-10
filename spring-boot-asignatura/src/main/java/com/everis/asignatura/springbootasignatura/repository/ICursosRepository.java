package com.everis.asignatura.springbootasignatura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.asignatura.springbootasignatura.mapper.Curso;

public interface ICursosRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByNombreAndCapacidad(String nombre, Integer capacidad);

	List<Curso> findAll();

	// List<Curso> findCursos();
}
