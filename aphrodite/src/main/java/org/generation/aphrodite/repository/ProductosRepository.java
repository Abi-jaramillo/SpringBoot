package org.generation.aphrodite.repository;

import java.util.Optional;

import org.generation.aphrodite.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository <Producto, Long>
{
Optional<Producto> findByNombre (String nombre);

}