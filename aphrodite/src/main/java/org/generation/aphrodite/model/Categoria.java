package org.generation.aphrodite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Categorias")
public class Categoria {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column	(name = "id", unique = true, nullable = false)
private Long id;
@Column (nullable = false)
private String nombre;

public Categoria(String nombre) {
	super();
	this.nombre = nombre;
}//constructor

public Categoria() {
	
}// constructor 2

public String getNombre() {
	return nombre;
}// getter nombre

public void setNombre(String nombre) {
	this.nombre = nombre;
}// setter nombre

public Long getId() {
	return id;
}// getter id

@Override
public String toString() {
	return "Categoria [id=" + id + ", nombre=" + nombre + "]";
}//to string




}//class categoria


