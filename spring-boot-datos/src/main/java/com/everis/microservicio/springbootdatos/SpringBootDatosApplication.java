package com.everis.microservicio.springbootdatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootDatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatosApplication.class, args);
	}

}
