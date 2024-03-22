package org.generation.aphrodite.repository;

import java.util.Optional;

import org.generation.aphrodite.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuariosRepository extends JpaRepository <Usuario, Long>
{
Optional<Usuario> findByCorreo (String correo);

}
