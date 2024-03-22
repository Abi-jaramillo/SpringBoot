package org.generation.aphrodite.service;

import java.util.List;

import org.generation.aphrodite.model.Producto;
import org.generation.aphrodite.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Ésta detecta automáticamente durante la exploración de componentes y la gestiona como un bean de servicio.
public class ProductoService {
    public final ProductoRepository productoRepository; 
    
    @Autowired
    public ProductoService (ProductoRepository productoRepository) {
	this.productoRepository = productoRepository;
    }//constructor

    public List <Producto> getAllProductos ( ) {
	return productoRepository.findAll( );
    }//getAllProductos

    public Producto getProducto(Long prodId) {
	return productoRepository.findById(prodId).orElseThrow(
		( ) -> new IllegalArgumentException ("El producto con el id [" + prodId +"] no existe"));
    }//getProducto

    public Producto addProducto(Producto producto) {
	 Producto tmpProd = null;
	   tmpProd = productoRepository.save(producto);
	   return tmpProd;
    }//addProducto

    public Producto updateProducto(Long prodId, String nombre, String categoria, String descripcion, Double precio,
	    String uRL_imagen) {
	Producto producto = null;
	    if (productoRepository.existsById(prodId)) {
		producto = productoRepository.findById(prodId).get( );
		    if (nombre != null) producto.setNombre(nombre);
		    if (categoria != null) producto.setCategoria(categoria);
		    if (descripcion != null) producto.setDescripcion(descripcion);
		    if (precio != null) producto.setPrecio(precio);
		    if (uRL_imagen != null) producto.setURL_imagen(uRL_imagen);
		    productoRepository.save(producto);
	    }
	    return producto;
    }//updateProducto

    public Producto deleteProducto(Long prodId) {
	Producto tmpProd = null;
	    if (productoRepository.existsById(prodId)) {
		tmpProd = productoRepository.findById(prodId).get( );
		productoRepository.deleteById(prodId);
		}
	    return tmpProd;
    }  
}//deleteProducto
