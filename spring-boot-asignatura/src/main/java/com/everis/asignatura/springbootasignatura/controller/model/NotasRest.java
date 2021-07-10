package com.everis.asignatura.springbootasignatura.controller.model;

import java.io.Serializable;

public class NotasRest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idNota;

	private Integer nota;

	private String fechaRendida;

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
	public String getFechaRendida() {
		return fechaRendida;
	}

	/**
	 * @param fechaRendida the fechaRendida to set
	 */
	public void setFechaRendida(String fechaRendida) {
		this.fechaRendida = fechaRendida;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
