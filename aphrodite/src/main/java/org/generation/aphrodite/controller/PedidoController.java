package org.generation.aphrodite.controller;


import java.util.List;

import org.generation.aphrodite.model.Pedido;
import org.generation.aphrodite.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500", "https://abi-jaramillo.github.io/Aphrodite/", "https://abi-jaramillo.github.io/"})
@RestController
@RequestMapping(path="/api/pedidos/")//Permite asignar una ruta  http://localhost:8080/api/pedidos/
public class PedidoController {
	 
	private final PedidoService pedidoService;
	@Autowired //Conectado automatico: Se genera un servicio en este caso de la clase PedidoService 
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}//Cosntructor
	
	
	//GET Solicita todos los pedidos
	@GetMapping
	public List<Pedido> getPedidos() {
		return pedidoService.getAllPedidos();
	}//getPedido 
	
	//GET Solicita 1 solo pedido (el solicitado)
	@GetMapping (path="{pedId}")
	public Pedido getPedido(@PathVariable("pedId") Long pedId) { //http://localhost:8080/api/pedidos/ utiliza el URL y le agrega la variable (pedId)
		return pedidoService.getPedido(pedId);
	}
	
	//POST envia un pedido nuevo
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) { //Crea un producto en el cuerpo
		return pedidoService.addPedido(pedido);
	}//addPedido
		
	//PUT Regresa el pedio modificado
	//@PutMapping (path="{pedId}")
	//public Pedido updatePedido(@PathVariable("pedId") int pedId,
	//		@RequestBody Pedido pedido) {
	//		return pedidoService.updatePedido(pedId,pedido.getCantidad_productos(), pedido.getDireccion());
	//}//updatePedido
	
	@PutMapping
	public Pedido updatePedido(@PathVariable("pedId") Long pedId,
			@RequestParam (required=false)Long cantidadProductos,
			@RequestParam (required=false)String direccion,
			@RequestParam (required=false)String idProductos)
	{
			return pedidoService.updatePedido(pedId,cantidadProductos,direccion,idProductos);
	}//updatePedido
	
	//DELETE
	@DeleteMapping(path="{pedId}")
	public Pedido deletePedido(@PathVariable("pedId") Long pedId) { //http://localhost:8080/api/pedidos/ utiliza el URL y le agrega la variable (pedId)
		return pedidoService.deletePedido(pedId);
	}//DELETE
	
	
}//class PedidoController
