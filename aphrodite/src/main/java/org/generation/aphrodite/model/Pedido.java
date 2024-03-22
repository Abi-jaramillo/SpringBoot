package org.generation.aphrodite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="no_pedido",unique=true,nullable=false)
	private long no_pedido;
	@Column(nullable=false)
	private long cantidad_productos;
	@Column(nullable=false)
	private String direccion;
	@Column(nullable=false)
	private String productos;
	
	
	
	//1.Constructores
	public Pedido(long cantidad_productos, String direccion, String productos) {
		super();
		this.cantidad_productos = cantidad_productos;
		this.direccion = direccion;
		this.productos = productos;
	}
	//Constructor vacio
	public Pedido() {}
	
	//Getters&Setters
	public String getProductos() {
		return productos;
	}
	public void setProductos(String productos) {
		this.productos = productos;
	}
		
	public Long getNo_pedido() {
		return no_pedido;
	}
	public Long getCantidad_productos() {
		return cantidad_productos;
	}
	public void setCantidad_productos(long cantidad_productos) {
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
		return "Pedido [no_pedido=" + no_pedido + ", cantidad_productos=" + cantidad_productos + ", direccion="
				+ direccion + ", productos=" + productos + "]";
	}
	
	
}//class Pedido
