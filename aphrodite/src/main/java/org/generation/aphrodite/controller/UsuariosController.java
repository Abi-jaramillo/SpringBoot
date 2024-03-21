package org.generation.aphrodite.controller;

import java.util.ArrayList;

import org.generation.aphrodite.model.Usuario;
import org.generation.aphrodite.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


	@RestController
	@RequestMapping (path = "/api/usuarios/")
	public class UsuariosController {
	    private final UsuarioService usuarioService;
	    
	   @Autowired
	   public UsuariosController (UsuarioService usuarioService) {
		    this.usuarioService = usuarioService;
		}//Constructor
	  
	    @GetMapping
	    public ArrayList <Usuario> getUsuarios ( ) {
			return usuarioService.getAllUsuarios( );
	    }//primer GET
	    
	  	@GetMapping (path = "{usuaId}") 
	  	public Usuario getUsuario ( @PathVariable("usuaId") int usuaId ) {
	  	    	return usuarioService.getUsuario ( usuaId );
	  	}//segundo GET
	  	
	  	@PostMapping
	  	public Usuario addUsuario (@RequestBody Usuario usuario) {
		    return usuarioService.addUsuario(usuario);
	  	}//POST
	  	
	  	@PutMapping(path = "{usuaId}")
	  	public Usuario updateUsuario(@PathVariable("usuaId") int usuaId,
				@RequestParam (required = false) String nombre,
				@RequestParam (required = false) String correo,
				@RequestParam (required = false) String telefono) {
			    	return usuarioService.updateUsuario( usuaId, nombre, correo, telefono);
			}//PUT
	  	
	  	@DeleteMapping(path = "{usuaId}")
		public Usuario deleteUsuario (@PathVariable("usuaId") int usuaId ) {
		    return usuarioService.deleteUsuario(usuaId);
		}//DELETE
	
}//Class UsuariosController
