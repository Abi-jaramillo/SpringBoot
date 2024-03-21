package org.generation.aphrodite.service;

import java.util.ArrayList;

import org.generation.aphrodite.model.Pedido;
import org.springframework.stereotype.Service;

@Service //Indica que es un servicio, va antes que cualquier controlador
public class PedidoService {
	public final ArrayList<Pedido> list = new ArrayList<Pedido>();
	
	public PedidoService() {
		list.add(new Pedido(10,"calle 4 no.33 col.Carlos Hank González"));
		list.add(new Pedido(5,"Av. Dr. Río de la Loza 148, Doctores, Cuauhtémoc, 06720 Ciudad de México, CDMX"));
		list.add(new Pedido(25,"Museo 150, San Pablo Tepetlapa, Coyoacán, 04620 Ciudad de México, CDMX"));
		list.add(new Pedido(10,"Pedregal de Carrasco Secc 5ta, Coyoacán, 04700 Mexico City"));
		list.add(new Pedido(11,"Av. Coyoacán 518, Col del Valle Centro, Benito Juárez, 03100 Ciudad de México, CDMX"));
	}

	public ArrayList<Pedido> getAllPedidos() {
		
		return list;
	}//getAllProducts

	public Pedido getPedido(int pedId) {
		Pedido tmpPed = null;
		for (Pedido pedido : list) {
			if(pedido.getNo_pedido() == pedId) {
				tmpPed=pedido;
				break;
				}//if
		}//forEach
		return tmpPed;
	}//getPedido

	public Pedido addPedido(Pedido pedido) {
		Pedido tmpPed=null;
		if(list.add(pedido)) {
			tmpPed=pedido;
		}//if
		return tmpPed;
	}//addPedido

	public Pedido deletePedido(int pedId) {
		Pedido tmpPed = null;
		for (Pedido pedido : list) {
			if(pedido.getNo_pedido() == pedId) {
				tmpPed=pedido;
				list.remove(pedido); //Borra el producto de la lista
				break;
				}//if
		}//forEach
		return tmpPed;
	}//deletePedido

	public Pedido updatePedido(int pedId,int cantidad_productos, String direccion) {
		Pedido tmpPed = null;
		Integer cant_prod = cantidad_productos;
		
		for (Pedido pedido : list) {
			if(pedido.getNo_pedido() == pedId) {
				if (cant_prod != null) pedido.setCantidad_productos(cantidad_productos);
				if (direccion!=null) pedido.setDireccion(direccion);
				tmpPed=pedido;
				break;
				}//if
		}//forEach
		return tmpPed;
		
	}
		
	
	
}
