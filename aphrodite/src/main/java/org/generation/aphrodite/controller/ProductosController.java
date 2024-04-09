package org.generation.aphrodite.controller;

import java.util.List;

import org.generation.aphrodite.model.Producto;
import org.generation.aphrodite.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500", "https://abi-jaramillo.github.io/Aphrodite/"})
@RestController // Se utiliza para crear controladores y devuelven directamente datos en lugar de vistas.
@RequestMapping (path = "/api/productos/") // Se utiliza para asignar solicitudes HTTP a métodos de controlador específicos o a controladores completos. Especifica la URL a la que responderá el método 
public class ProductosController {
    private final ProductoService productoService;
    
   @Autowired // Ésta inyecta dependencias automáticamente en un componente Spring.
   public ProductosController (ProductoService productoService) {
	    this.productoService = productoService;
	}//Constructor
    
    // GET
    @GetMapping // Ésta mapea las solicitudes HTTP GET a métodos específicos del controlador.
    public List <Producto> getProductos ( ) {
		return productoService.getAllProductos( );
    }
    
  //GET
  	@GetMapping (path = "{prodId}") 
  	public Producto getProducto ( @PathVariable("prodId") Long prodId ) {
  	    	return productoService.getProducto ( prodId );
  	}
  	
  	//POST
  	@PostMapping // Ésta mapea las solicitudes HTTP POST a métodos específicos del controlador. 
  	public Producto addProducto (@RequestBody Producto producto) {
	    return productoService.addProducto(producto);
  	}
	    
	   //PUT
	   @PutMapping(path = "{prodId}")  // --> http://localhost:8080/api/products/1?price=70.20 //MODIFICA SOLO UN PARÁMETRO  
	   //Ésta mapea las solicitudes HTTP PUT a métodos específicos del controlador.
		public Producto updateProducto(@PathVariable("prodId") Long prodId,
			@RequestParam (required = false) String nombre, // se utiliza para vincular los parámetros de una solicitud HTTP a los parámetros de un método de controlador. Cuando se recibe una solicitud HTTP con parámetros de consulta o formularios
			@RequestParam (required = false) String categoria,
			@RequestParam (required = false) String descripcion,
			@RequestParam (required = false) Double precio,
			@RequestParam (required = false) String URL_imagen) {
		    	return productoService.updateProducto( prodId, nombre, categoria, descripcion, precio, URL_imagen);
		}
	   
	 //DELETE
		@DeleteMapping(path = "{prodId}") // Ésta mapea las solicitudes HTTP DELETE a métodos específicos del controlador.
		public Producto deleteProducto (@PathVariable("prodId") Long prodId ) {
		    return productoService.deleteProducto(prodId);
		}
	    
}
