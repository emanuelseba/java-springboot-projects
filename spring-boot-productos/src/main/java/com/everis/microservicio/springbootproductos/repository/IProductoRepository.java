package com.everis.microservicio.springbootproductos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.microservicio.springbootproductos.mapper.Producto;


public interface IProductoRepository extends JpaRepository<Producto, String>{
	Producto findByNombre(String nombre);
	
	/**
	 * Find by tipo.
	 *
	 * @param apellido the tipo
	 * @return the list
	 */
	List<Producto> findByTipo(String tipo);
	
	/**
	 * Find by precio.
	 *
	 * @param precio the producto
	 * @return the list
	 */
	List<Producto> findByPrecio(int precio);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Producto> findAll();
	
}
