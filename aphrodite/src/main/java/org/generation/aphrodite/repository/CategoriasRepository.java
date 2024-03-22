package org.generation.aphrodite.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository <Categorias, Long>
{
Optional<Categorias> findById (Long id);

} 
