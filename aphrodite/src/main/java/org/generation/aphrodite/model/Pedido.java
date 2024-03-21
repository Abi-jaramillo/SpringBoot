package org.generation.aphrodite.model;

public class Pedido {
	private int cantidad_productos;
	private String direccion;
	private int no_pedido;
	private static int total = 0;
	
	//1.Constructores
	public Pedido(int cantidad_productos, String direccion) {
		super();
		this.cantidad_productos = cantidad_productos;
		this.direccion = direccion;
		Pedido.total++;
		no_pedido = Pedido.total;
	}
	//Constructor vacio
	public Pedido() {
		Pedido.total++;
		no_pedido = Pedido.total;
	}
	
	//Getters&Setters
	public int getNo_pedido() {
		return no_pedido;
	}
	public int getCantidad_productos() {
		return cantidad_productos;
	}
	public void setCantidad_productos(int cantidad_productos) {
		this.cantidad_productos = cantidad_productos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Pedido [cantidad_productos=" + cantidad_productos + ", direccion=" + direccion + ", no_pedido="
				+ no_pedido + "]";
	}
	
	
}//class Pedido
