package org.generation.aphrodite.service;

import java.util.ArrayList;

import org.generation.aphrodite.model.Producto;
import org.springframework.stereotype.Service;

@Service // Ésta detecta automáticamente durante la exploración de componentes y la gestiona como un bean de servicio.
public class ProductoService {
    public final ArrayList<Producto> list = new ArrayList<Producto>( ); 
    public ProductoService ( ) {
    	list.add(new Producto("Shampoo hidratante", "cabello", "Purifica tu cabello con este shampoo dejando una sensación de limpieza profunda. Ayuda a reequilibrar el exceso de grasa sin modificar la hidratación esencial del cabello", 260, "teatree.jpg"));
    	list.add(new Producto("Acondicionador", "cabello", "Descubre el secreto para un cabello radiante, suave y sedoso con nuestro acondicionador. Revitaliza, fortalece y elimina el frizz", 260, "acondicionador.jpg"));
    	list.add(new Producto("Maquillaje con Base de Quinoa", "maquillaje", "Con ingredientes naturales antiinflamatorios, base liviana de suave aplicación. Fórmula para dar una cobertura fina y natural con fijación y acabado mate uniforme", 190, "base.jpg"));
    	list.add(new Producto("Iluminador de Vainilla", "maquillaje", "Luce un increíble brillo en tu rostro con nuestro iluminador con extracto de vainilla", 150, "iluminador.jpg"));
    	list.add(new Producto("Ácido Hialurónico 2% + B5", "piel", "Proporciona una hidratación voluminosa instantánea para brindar una piel más suave, tersa y de aspecto saludable. Fórmula revitalizante e hidratante con durabilidad de 24 hrs", 300, "acidohia.jpg"));
    	list.add(new Producto("Kit de Rutina Diaria", "piel", "Kit de tres piezas para rutina diaria de skin care. El limpiador Squalane elimina el maquillaje. Hyaluronic Acid 2% + B5 favorece la hidratación de múltiples capas de la superficie de la piel", 450, "kit.jpg"));
	}

    public ArrayList<Producto> getAllProductos ( ) {
	return list;
    }

    public Producto getProducto(int prodId) {
	Producto tmpProd = null;
	    for (Producto producto : list) {
		if (producto.getId( ) == prodId) {
		    tmpProd = producto;
		    break;
		 }
	    }
	    return tmpProd;
    }

    public Producto addProducto(Producto producto) {
	 Producto tmpProd = null;
	   if( list.add(producto)) {
	       tmpProd = producto;
	   }
	    return tmpProd;
    }

    public Producto updateProducto(int prodId, String nombre, String categoria, String descripcion, Double precio,
	    String uRL_imagen) {
	Producto tmpProd = null;
	    for (Producto producto : list) {
		if (producto.getId ( ) == prodId) {
		    tmpProd = producto;
		    if (nombre != null) producto.setNombre(nombre);
		    if (categoria != null) producto.setCategoria(categoria);
		    if (descripcion != null) producto.setDescripcion(descripcion);
		    if (precio != null) producto.setPrecio(precio);
		    if (uRL_imagen != null) producto.setURL_imagen(uRL_imagen);
		    tmpProd = producto;
		    break;
		}
	    }
	    return tmpProd;
    }

    public Producto deleteProducto(int prodId) {
	Producto tmpProd = null;
	    for (Producto producto : list) {
		if (producto.getId() == prodId) {
		    tmpProd = producto;
		    list.remove(producto);
		    break;
		}
	    }
	    return tmpProd;
    }  
}
