package com.everis.asignatura.springbootasignatura.controller.model;

public class PersonasRest {

	private static final long serialVersionUID = 1L;

	private Integer idPersona;

	private String nombre;

	private String apellido;
	
	private Integer promedio;

	/**
	 * @return the idPersona
	 */
	public Integer getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the promedio
	 */
	public Integer getPromedio() {
		return promedio;
	}

	/**
	 * @param promedio the promedio to set
	 */
	public void setPromedio(Integer promedio) {
		this.promedio = promedio;
	}
	
	

	
}
