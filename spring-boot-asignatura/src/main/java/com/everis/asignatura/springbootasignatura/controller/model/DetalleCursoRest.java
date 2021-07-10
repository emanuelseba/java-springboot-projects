package com.everis.asignatura.springbootasignatura.controller.model;

public class DetalleCursoRest {

	private Integer idCurso;

	private String nombre;

	private Integer capacidad;
	
	

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
	
	
}
