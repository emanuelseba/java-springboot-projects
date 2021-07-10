package com.everis.asignatura.springbootasignatura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.asignatura.springbootasignatura.mapper.Persona;

public interface IAsignaturaRepository extends JpaRepository<Persona, String> {

	List<Persona> findAll();
	
	

}
