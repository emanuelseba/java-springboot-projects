package com.everis.asignatura.springbootasignatura.mapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Asignacion {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
	private Persona persona;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
	private Curso curso;

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
	
}