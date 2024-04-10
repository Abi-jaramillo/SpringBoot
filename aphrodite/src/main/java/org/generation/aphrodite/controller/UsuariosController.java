package org.generation.aphrodite.controller;

import java.util.List;

import org.generation.aphrodite.dto.ChangePassword;
import org.generation.aphrodite.model.Usuario;
import org.generation.aphrodite.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500", "https://abi-jaramillo.github.io/Aphrodite/", "https://abi-jaramillo.github.io/"})
	@RestController // Se utiliza para crear controladores y devuelven directamente datos en lugar de vistas.

	@RequestMapping (path = "/api/usuarios/") // Se utiliza para asignar solicitudes HTTP a métodos de controlador específicos o a controladores completos. Especifica la URL a la que responderá el método o la clase anotada.

	public class UsuariosController {
	    private final UsuarioService usuarioService;
	    
	   @Autowired // Ésta inyecta dependencias automáticamente en un componente Spring. 
	   public UsuariosController (UsuarioService usuarioService) {
		    this.usuarioService = usuarioService;
		}//Constructor
	  
	    @GetMapping // Ésta mapea las solicitudes HTTP GET a métodos específicos del controlador.
	    public List <Usuario> getUsuarios ( ) {
			return usuarioService.getAllUsuarios( );
	    }//primer GET
	    
	  	@GetMapping (path = "{usuaId}") 
	  	public Usuario getUsuario ( @PathVariable("usuaId") Long usuaId ) {  // Permite capturar valres dinámicos de la URL y utilizarlos dentro del controlador.
	  	    	return usuarioService.getUsuario ( usuaId );
	  	}//segundo GET
	  	
	  	@PostMapping // Ésta mapea las solicitudes HTTP POST a métodos específicos del controlador. 
	  	public Usuario addUsuario (@RequestBody Usuario usuario) { // Los datos relevantes se envían en el cuerpo de la solicitud en lugar de la URL.
		    return usuarioService.addUsuario(usuario);
	  	}//POST
	  	
	  	@PutMapping(path = "{usuaId}") // Ésta mapea las solicitudes HTTP PUT a métodos específicos del controlador.
	  	public Usuario updateUsuario(@PathVariable("usuaId") Long usuaId,
				@RequestBody ChangePassword changePassword) {
			    	return usuarioService.updateUsuario( usuaId, changePassword);
			}//PUT
	  	
	  	@DeleteMapping(path = "{usuaId}") // Ésta mapea las solicitudes HTTP DELETE a métodos específicos del controlador.
		public Usuario deleteUsuario (@PathVariable("usuaId") Long usuaId ) {
		    return usuarioService.deleteUsuario(usuaId);
		}//DELETE
	
}//Class UsuariosController
