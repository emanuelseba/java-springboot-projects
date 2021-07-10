package com.everis.asignatura.springbootasignatura.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Curso {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;

	@Column
	private String nombre;

	@Column
	private Integer capacidad;

	@ManyToMany( mappedBy = "cursos", fetch = FetchType.LAZY)
	private List<Persona> persona = new ArrayList<>();
	
	@OneToMany( mappedBy = "curso", fetch = FetchType.LAZY)	
	private List<Notas>  notas = new ArrayList<>();
	
	
	/**
	 * @return the idCurso
	 */
	public Integer getIdCurso() {
		return idCurso;
	}

	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the capacidad
	 */
	public Integer getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * @return the persona
	 */
	//public List<Persona> getPersona() {
	//	return persona;
	//}

	/**
	 * @param persona the persona to set
	 */
	//public void setPersona(List<Persona> persona) {
	//	this.persona = persona;
	//}

	
}
