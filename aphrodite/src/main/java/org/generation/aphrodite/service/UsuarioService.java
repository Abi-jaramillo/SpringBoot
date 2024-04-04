package org.generation.aphrodite.service;

import java.util.List;
import java.util.Optional;

import org.generation.aphrodite.dto.ChangePassword;
import org.generation.aphrodite.model.Usuario;
import org.generation.aphrodite.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // Ésta detecta automáticamente durante la exploración de componentes y la gestiona como un bean de servicio.
public class UsuarioService {
	
	public final UsuariosRepository usuariosRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    public UsuarioService (UsuariosRepository usuariosRepository) {
    	this.usuariosRepository=usuariosRepository;
	}
	public List<Usuario> getAllUsuarios() {
		
		return usuariosRepository.findAll();
	}//constructor
	
	public Usuario getUsuario(Long usuaId) {
		return usuariosRepository.findById(usuaId).orElseThrow(
				()-> new IllegalArgumentException("El Usuario con el id ["+
						usuaId + "] no existe")
				);
				
	}//getUsuario
	
	public Usuario addUsuario(Usuario usuario) {
		Usuario tmpUsuario = null;
		if(usuariosRepository.findByCorreo(usuario.getCorreo()).isEmpty()) {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			tmpUsuario = usuariosRepository.save(usuario);
		}else {
			System.out.println("Ya existe el usuario con este correo ["+
					usuario.getCorreo()+ "]");	
		}//if
		return tmpUsuario;
	}//addUsuario
	
	public Usuario updateUsuario(Long usuaId, ChangePassword changePassword) {
		Usuario tmpUsuario = null;
		if (usuariosRepository.existsById(usuaId)){
	    	tmpUsuario = usuariosRepository.findById(usuaId).get();
	    	if(passwordEncoder.matches(changePassword.getPassword(),tmpUsuario.getPassword())) {
	    		tmpUsuario.setPassword(passwordEncoder.encode(changePassword.getNpassword()));
	    		usuariosRepository.save(tmpUsuario);
	    	}else {
	    		System.out.println("updateUser- El password del usuario ["+
	    				tmpUsuario.getId()+ "] no coincide");
	    		tmpUsuario=null;
	    	}//if equals
		}//if existById
	    return tmpUsuario;
	}//updateUsuario
	
	public Usuario deleteUsuario(Long usuaId) {
		Usuario tmpUsuario = null;
	    if (usuariosRepository.existsById(usuaId)){
	    	tmpUsuario = usuariosRepository.findById(usuaId).get();
	    	usuariosRepository.deleteById(usuaId);
	}//for
	    return tmpUsuario;  
	}//deleteUsuario
	
	public boolean validateUsuario(Usuario usuario) {
		Optional <Usuario> usuarioByCorreo = usuariosRepository.findByCorreo(usuario.getCorreo());
		if(usuarioByCorreo.isPresent()) {
			Usuario tmpUsuario = usuarioByCorreo.get();
			if(passwordEncoder.matches(usuario.getPassword(),tmpUsuario.getPassword())) {
				return true;
			}//if
		}//if
		return false;
	}//validateUsuario
	
	
}//UsuarioService
