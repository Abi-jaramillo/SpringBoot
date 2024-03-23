package org.generation.aphrodite.repository;

import java.util.Optional;

import org.generation.aphrodite.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository <Categoria, Long>
{
Optional<Categoria> findByNombre (String nombre);

} 
