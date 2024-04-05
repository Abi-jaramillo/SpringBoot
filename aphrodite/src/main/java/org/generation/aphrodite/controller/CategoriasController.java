package org.generation.aphrodite.controller;

import java.util.List;

import org.generation.aphrodite.model.Categoria;
import org.generation.aphrodite.service.CategoriasService;
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

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500", "https://abi-jaramillo.github.io/Aphrodite/"})
@RestController
@RequestMapping (path="/api/categorias/")
public class CategoriasController {
private final CategoriasService categoriasService;
@Autowired 

public CategoriasController (CategoriasService categoriasService) {
	this.categoriasService = categoriasService;	
}//Constructor 

@GetMapping 
public List<Categoria> getCategorias (){
	return categoriasService.getAllProducts();
}//Get 1

@GetMapping(path = "{catId}")
public Categoria getCategoria (@PathVariable ("catId") Long catId) {
	return categoriasService.getCategoria(catId);
}//Get 2

@PostMapping 
public Categoria addCategoria (@RequestBody Categoria categoria ) {
	return categoriasService.addCategoria(categoria);
}//Post 

@DeleteMapping (path = "{catId}")
public Categoria deleteCategoria(@PathVariable ("catId") Long catId) {
	return categoriasService.deleteCategoria(catId);
}//Delete

@PutMapping (path = "{catId}")
public Categoria updateCategoria(@PathVariable ("catId") Long catId,
		@RequestBody Categoria categoria) {
	return categoriasService.updateCategoria(catId, categoria.getNombre());
}//Put



}//class categorias controller
