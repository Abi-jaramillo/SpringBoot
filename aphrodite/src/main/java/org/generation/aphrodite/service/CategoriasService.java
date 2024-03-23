package org.generation.aphrodite.service;

import java.util.List;
import java.util.Optional;

import org.generation.aphrodite.model.Categoria;
import org.generation.aphrodite.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService { 
	public final CategoriasRepository categoriasRepository;
@Autowired
public CategoriasService ( CategoriasRepository categoriasRepository) {
	this.categoriasRepository=categoriasRepository;
	
}
public List<Categoria> getAllProducts() {
	
	return categoriasRepository.findAll();
}
public Categoria getCategoria(Long catId) {
	
	return categoriasRepository.findById(catId).orElseThrow(
			()->new IllegalArgumentException("La categoria con el ID [ " + 
				catId	+ "] no existe ")
			);
	
}

public Categoria addCategoria (Categoria categoria) {
			Optional<Categoria> tmpCat=categoriasRepository.findByNombre(categoria.getNombre());
			
			if(tmpCat.isEmpty()) {
				return categoriasRepository.save(categoria);
				
			}else {
				System.out.println("Ya existe la categoría  [ " + 
				categoria.getNombre()	+ "] ");
				return null;
			}
}
public Categoria deleteCategoria(Long catId) {
	Categoria tmpCat=null; 
	if(categoriasRepository.existsById(catId)) {
		tmpCat=categoriasRepository.findById(catId).get();
		categoriasRepository.deleteById(catId);
	}
	return tmpCat;
}
public Categoria updateCategoria(Long catId, String nombre) {
	Categoria categoria= null;
	if(categoriasRepository.existsById(catId)) {
		categoria=categoriasRepository.findById(catId).get();
		if (nombre.length()!=0)categoria.setNombre(nombre);
		categoriasRepository.save(categoria);
	}
	
	return categoria; 
}




	

}
