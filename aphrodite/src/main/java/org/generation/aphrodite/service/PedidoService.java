package org.generation.aphrodite.service;


import java.util.List;
import java.util.Optional;

import org.generation.aphrodite.model.Pedido;
import org.generation.aphrodite.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Indica que es un servicio, va antes que cualquier controlador
public class PedidoService {
	public final PedidosRepository pedidoRepository;
	@Autowired
	public PedidoService(PedidosRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}//Constructor

	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}//getAllProducts

	public Pedido getPedido(Long pedId) {
		return pedidoRepository.findById((pedId)).orElseThrow(
				()->new IllegalArgumentException("El pedido con numero ["+
						pedId+ "] no existe") );
	}//getPedido

	public Pedido addPedido(Pedido pedido) {
		Optional<Pedido> tmpPed= pedidoRepository.findByNo_pedido(pedido.getNo_pedido());
		if(tmpPed.isEmpty()) {
			return pedidoRepository.save(pedido);
		}else {
			System.out.println("Ya existe el pedido con numero["
					+pedido.getNo_pedido() +"]");
			return null;
		}//if
		
	}//addPedido

	public Pedido deletePedido(Long pedId ) {
		Pedido tmpPed = null;
		if(pedidoRepository.existsById(pedId)) {
			tmpPed = pedidoRepository.findById(pedId).get();
			pedidoRepository.deleteById(pedId);
		}
		return tmpPed;
	}//deletePedido

	public Pedido updatePedido(Long pedId,Long cantidad_productos, String direccion, String productos) {
		Pedido pedido = null;
		if(pedidoRepository.existsById(pedId)) {
			pedido= pedidoRepository.findById(pedId).get();
			if(productos.length()!=0) pedido.setProductos(productos);
			if(direccion.length()!=0) pedido.setDireccion(direccion);
			if(cantidad_productos.doubleValue()>0) pedido.setCantidad_productos(cantidad_productos);
			pedidoRepository.save(pedido);
		}
		return pedido;
		
	}
		
	
	
}
