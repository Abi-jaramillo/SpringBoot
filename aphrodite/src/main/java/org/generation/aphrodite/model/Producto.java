package org.generation.aphrodite.model;

public class Producto {
    private String nombre;
    private String categoria; // enum?
    private String descripcion;
    private double precio;
    private String URL_imagen;
    private int id;
    private static int total = 0;
    
    public Producto(String nombre, String categoria, String descripcion, double precio, String uRL_imagen) {
	super( );
	this.nombre = nombre;
	this.categoria = categoria;
	this.descripcion = descripcion;
	this.precio = precio;
	URL_imagen = uRL_imagen;
	Producto.total++;
	id = Producto.total;
    }//constructor

    public Producto( ) {
	Producto.total++;
	id = Producto.total;
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


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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
