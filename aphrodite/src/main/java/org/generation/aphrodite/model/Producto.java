package org.generation.aphrodite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String categoria; 
    private String descripcion;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false)
    private String URL_imagen;
    
    
    public Producto(String nombre, String categoria, String descripcion, double precio, String uRL_imagen) {
	super( );
	this.nombre = nombre;
	this.categoria = categoria;
	this.descripcion = descripcion;
	this.precio = precio;
	URL_imagen = uRL_imagen;
    }//constructor

    public Producto( ) {
    }//constructor vacío

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public Long getId() {
        return id;
    }


    public String getURL_imagen() {
        return URL_imagen;
    }


    public void setURL_imagen(String uRL_imagen) {
        URL_imagen = uRL_imagen;
    }


    @Override
    public String toString() {
	return "Producto [nombre=" + nombre + ", categoria=" + categoria + ", descripcion=" + descripcion + ", precio="
		+ precio + ", URL_imagen=" + URL_imagen + ", id=" + id + "]";
    }
}//class Product
