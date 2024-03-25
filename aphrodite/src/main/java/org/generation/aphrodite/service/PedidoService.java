package org.generation.aphrodite.service;


import java.util.List;
import java.util.Optional;

import org.generation.aphrodite.model.Pedido;
import org.generation.aphrodite.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Indica que es un servicio, va antes que cualquier controlador
public class PedidoService {
	public final PedidoRepository pedidoRepository;
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
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
		Optional<Pedido> tmpPed= pedidoRepository.findByNoPedido(pedido.getNoPedido());
		if(tmpPed.isEmpty()) {
			return pedidoRepository.save(pedido);
		}else {
			System.out.println("Ya existe el pedido con numero["
					+pedido.getNoPedido() +"]");
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

	public Pedido updatePedido(Long pedId,Long cantidadProductos, String direccion, String idProductos) {
		Pedido pedido = null;
		if(pedidoRepository.existsById(pedId)) {
			pedido= pedidoRepository.findById(pedId).get();
			if(idProductos.length()!=0) pedido.setProductos(idProductos);
			if(direccion.length()!=0) pedido.setDireccion(direccion);
			if(cantidadProductos.doubleValue()>0) pedido.setCantidadProductos(cantidadProductos);
			pedidoRepository.save(pedido);
		}
		return pedido;
		
	}
		
	
	
}
