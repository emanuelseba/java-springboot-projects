package com.everis.microservicio.springbootproductos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.microservicio.springbootproductos.mapper.Producto;
import com.everis.microservicio.springbootproductos.repository.IProductoRepository;

/**
 * The Class ProductoController.
 */
@RestController
public class ProductoController {
	/** The repository. */
	@Autowired
	private IProductoRepository repository;

	/**
	 * Find producto.
	 *
	 * @param nombre the producto
	 * @return the producto
	 */
	@GetMapping("/find/{nombre}")
	public Producto findNombre(@PathVariable("nombre") String nombre) {
		return repository.findByNombre(nombre);
	}
	
	/**
	 * Save.
	 *
	 * @param producto the producto
	 * @return the producto
	 */
	@PostMapping("/save")
	public Producto save(@RequestBody Producto producto) {
		return repository.save(producto);
	}
	
	/**
	 * Save.
	 *
	 * @param productos the productos
	 * @return the list
	 */
	@PostMapping("/saveAll")
	public List<Producto> save(@RequestBody List<Producto> productos) {
	return repository.saveAll(productos);
	}
	
	/**
	 * Find tipo.
	 *
	 * @param tipo the tipo
	 * @return the list
	 */
	@GetMapping("/findTipo/{tipo}")
	public List<Producto> findTipo(@PathVariable("tipo") String tipo) {
		return repository.findByTipo(tipo); 
	}
	
	/**
	 * Find precio.
	 *
	 * @param precio the precio
	 * @return the list
	 */
	@GetMapping("/findPrecio/{precio}")
	public List<Producto> findPrecio(@PathVariable("precio") int precio){
	return repository.findByPrecio(precio);
}
	
	@GetMapping("/findAll")
    public List<Producto> findAllProductos(){
        return repository.findAll();
    }
}
