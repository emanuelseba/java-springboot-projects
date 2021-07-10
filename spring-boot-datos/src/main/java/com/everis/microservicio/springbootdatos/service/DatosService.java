package com.everis.microservicio.springbootdatos.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.microservicio.springbootdatos.dto.Datos;
import com.everis.microservicio.springbootdatos.dto.PersonaDTO;

@Service
public class DatosService {
	@Autowired
	private PersonaProxy personaProxy;
	
	public Datos getDatos(String username) {
		PersonaDTO persona = personaProxy.findUsuario(username);
		
		Datos datos = new Datos();
		datos.setUsername(persona.getNombre());
		datos.setDireccion(persona.getDireccion());
		datos.setNombreCompleto(persona.getNombre()+" "+persona.getApellido());
		datos.setPort(persona.getPort());
		
		LocalDate actual = LocalDate.now();
		LocalDate nac = persona.getFechaNacimiento();
		
		datos.setEdad(Period.between(nac,actual).getYears());
		return datos;
	}

}
