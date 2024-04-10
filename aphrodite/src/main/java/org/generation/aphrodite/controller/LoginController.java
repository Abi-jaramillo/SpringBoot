package org.generation.aphrodite.controller;

import javax.servlet.ServletException;

import org.generation.aphrodite.config.JwtFilter;
import org.generation.aphrodite.dto.Token;
import org.generation.aphrodite.model.Usuario;
import org.generation.aphrodite.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500", "https://abi-jaramillo.github.io/Aphrodite/", "https://abi-jaramillo.github.io/"})
@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	
	private final UsuarioService usuarioService;
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}//constructor
	
	@PostMapping
	public Token loginUsuario(@RequestBody Usuario usuario) throws ServletException {
		if(usuarioService.validateUsuario(usuario)) {
			System.out.println("Usuario válido " + usuario.getCorreo());
			return new Token(generateToken(usuario.getCorreo()));
		}//if de validateUsuario
		throw new ServletException("Nombre de usuario o constraseña incorrectos " + usuario.getCorreo());
	}//loginUsuario
	
	private String generateToken(String usuarioNombre) {
			Calendar calendar = Calendar.getInstance();//Fecha hora actual
			calendar.add(Calendar.HOUR, 20); // Pruebas
			//calendar.add(Calendar.MINUTE, 30);// Producción
			return Jwts.builder().setSubject(usuarioNombre).claim("role", "usuario")
			.setIssuedAt(new Date())
			.setExpiration(calendar.getTime())
			.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
			.compact();
		}//generateToken
	
	
	
	
	
}//class LoginController
