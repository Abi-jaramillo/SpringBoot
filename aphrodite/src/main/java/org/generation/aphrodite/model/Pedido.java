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
	@Column(name="noPedido",unique=true,nullable=false)
	private Long noPedido;
	@Column(nullable=false)
	private Long cantidadProductos;
	@Column(nullable=false)
	private String direccion;
	@Column(nullable=false)
	private String idProductos;
	
	
	
	//1.Constructores
	public Pedido(Long cantidadProductos, String direccion, String idProductos) {
		super();
		this.cantidadProductos = cantidadProductos;
		this.direccion = direccion;
		this.idProductos = idProductos;
	}
	//Constructor vacio
	public Pedido( ) {
	}
	
	//Getters&Setters
	public String getProductos() {
		return idProductos;
	}
	public void setProductos(String idProductos) {
		this.idProductos = idProductos;
	}
		
	public Long getNoPedido() {
		return noPedido;
	}
	public Long getCantidadProductos() {
		return cantidadProductos;
	}
	public void setCantidadProductos(Long cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Pedido [noPedido=" + noPedido + ", cantidadProductos=" + cantidadProductos + ", direccion="
				+ direccion + ", idProductos=" + idProductos + "]";
	}
	
	
}//class Pedido
