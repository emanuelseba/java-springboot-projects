package com.everis.beca.springbootpersona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.beca.springbootpersona.mapper.Persona;

/**
 * The Interface IPersonaRepository.
 */
public interface IPersonaRepository extends JpaRepository<Persona, String> {
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the persona
	 */
	Persona findByUsername(String username);
	
	/**
	 * Find by apellido.
	 *
	 * @param apellido the apellido
	 * @return the list
	 */
	List<Persona> findByApellido(String apellido);
	
	/**
	 * Find by direccion.
	 *
	 * @param direccion the direccion
	 * @return the list
	 */
	List<Persona> findByDireccion(String direccion);
}
