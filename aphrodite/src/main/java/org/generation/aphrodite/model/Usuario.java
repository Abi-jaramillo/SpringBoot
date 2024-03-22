package org.generation.aphrodite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id", unique=true, nullable=false)
	private Long id;
	@Column (nullable=false)
	private String nombre;
	@Column (unique=true, nullable=false)
	private String correo;
	@Column (nullable=false)
	private String telefono;
	@Column (nullable=false)
	private String password;
    
	public Usuario(String nombre, String correo, String telefono, String password) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
		}//constructor	
    
	public Usuario( ) {
	    }//constructor vacío

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getCorreo() {
		return correo;
	}//getCorreo

	public void setCorreo(String correo) {
		this.correo = correo;
	}//setCorreo

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	public Long getId() {
		return id;
	}//getId

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", password=" + password + "]";
	}//toString
	
}//class Usuario
