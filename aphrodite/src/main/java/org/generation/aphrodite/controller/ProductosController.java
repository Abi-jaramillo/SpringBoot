package org.generation.aphrodite.controller;

import java.util.ArrayList;

import org.generation.aphrodite.model.Producto;
import org.generation.aphrodite.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/productos/")
public class ProductosController {
    private final ProductoService productoService;
    
   @Autowired
   public ProductosController (ProductoService productoService) {
	    this.productoService = productoService;
	}//Constructor
    
    // GET
    @GetMapping
    public ArrayList <Producto> getProductos ( ) {
		return productoService.getAllProductos( );
    }
    
  //GET
  	@GetMapping (path = "{prodId}") 
  	public Producto getProducto ( @PathVariable("prodId") int prodId ) {
  	    	return productoService.getProducto ( prodId );
  	}
  	
  	//POST
  	@PostMapping
  	public Producto addProducto (@RequestBody Producto producto) {
	    return productoService.addProducto(producto);
  	}
	    
	   //PUT
	   @PutMapping(path = "{prodId}")  // --> http://localhost:8080/api/products/1?price=70.20 //MODIFICA SOLO UN PARÁMETRO
		public Producto updateProduct(@PathVariable("prodId") int prodId,
			@RequestParam (required = false) String nombre,
			@RequestParam (required = false) String categoria,
			@RequestParam (required = false) String descripcion,
			@RequestParam (required = false) Double precio,
			@RequestParam (required = false) String URL_imagen) {
		    	return productoService.updateProducto( prodId, nombre, categoria, descripcion, precio, URL_imagen);
		}
	   
	 //DELETE
		@DeleteMapping(path = "{prodId}")
		public Producto deleteProducto (@PathVariable("prodId") int prodId ) {
		    return productoService.deleteProducto(prodId);
		}
	    
}
