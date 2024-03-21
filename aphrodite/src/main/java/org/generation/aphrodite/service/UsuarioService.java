package org.generation.aphrodite.service;

import java.util.ArrayList;

import org.generation.aphrodite.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	public final ArrayList<Usuario> list = new ArrayList<Usuario>( ); 
    public UsuarioService () {
    	list.add(new Usuario("Juan Torres", "juantorres@gmail.com", "5526354789"));
    	list.add(new Usuario("Maria Juanita", "ma.jua@gmail.com", "5567895314"));
    	list.add(new Usuario("Lupita Mendoza", "lupis@gmail.com", "5585631784"));
    	list.add(new Usuario("Rodrigo Duran", "rodrigod@gmail.com", "5578465329"));
    	list.add(new Usuario("Angelica Hernandez", "angie@gmail.com", "5598764532"));
	}
	public ArrayList<Usuario> getAllUsuarios() {
		
		return list;
	}//constructor
	
	public Usuario getUsuario(int usuaId) {
		Usuario tmpUsua = null;
	    for (Usuario usuario : list) {
		if (usuario.getId() == usuaId) {
		    tmpUsua = usuario;
		    break;
		 }//if
	    }//foreach
	    return tmpUsua;
	}//getUsuario
	
	public Usuario addUsuario(Usuario usuario) {
		Usuario tmpUsua = null;
		   if( list.add(usuario)) {
		       tmpUsua = usuario;
		   }//if
		    return tmpUsua;
	}//addUsuario
	
	public Usuario updateUsuario(int usuaId, String nombre, String correo, String telefono) {
		Usuario tmpUsua = null;
	    for (Usuario usuario : list) {
		if (usuario.getId ( ) == usuaId) {
		    tmpUsua = usuario;
		    if (nombre != null) usuario.setNombre(nombre);
		    if (correo != null) usuario.setCorreo(correo);
		    if (telefono != null) usuario.setTelefono(telefono);
		    tmpUsua = usuario;
		    break;
		}//if
	 }//foreach
	    return tmpUsua;
	}//updateUsuario
	
	public Usuario deleteUsuario(int usuaId) {
		Usuario tmpUsua = null;
	    for (Usuario usuario : list) {
		if (usuario.getId() == usuaId) {
		    tmpUsua = usuario;
		    list.remove(usuario);
		    break;
	}//if
	   }//foreach
	    return tmpUsua;  
	}//deleteUsuario
	
	
}//UsuarioService
