package org.generation.aphrodite.model;

public class Usuario {
	private String nombre;
	private String correo;
	private String telefono;
	private int id;
    private static int total = 0;
    
    
	public Usuario(String nombre, String correo, String telefono) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		Usuario.total++;
		id = Usuario.total;
		}//constructor	
    
	public Usuario( ) {
		Usuario.total++;
		id = Usuario.total;
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

	public int getId() {
		return id;
	}//getId

	public void setId(int id) {
		this.id = id;
	}//setId

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", id=" + id + "]";
	}//toString
	
}//class Usuario
