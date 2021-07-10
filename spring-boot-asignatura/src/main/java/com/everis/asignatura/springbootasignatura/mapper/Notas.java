package com.everis.asignatura.springbootasignatura.mapper;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Notas {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNota;

	@Column
	private Integer nota;

	@CreationTimestamp
	@Column(name = "Fecha_Rendida")
	private Timestamp fechaRendida;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
	private Persona persona;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
	private Curso curso;

	/**
	 * @return the idNota
	 */
	public Integer getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	/**
	 * @return the nota
	 */
	public Integer getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Integer nota) {
		this.nota = nota;
	}

	/**
	 * @return the fechaRendida
	 */
	public Timestamp getFechaRendida() {
		return fechaRendida;
	}

	/**
	 * @param fechaRendida the fechaRendida to set
	 */
	public void setFechaRendida(Timestamp fechaRendida) {
		this.fechaRendida = fechaRendida;
	}

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
