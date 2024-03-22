package org.generation.aphrodite.repository;

import java.util.Optional;

import org.generation.aphrodite.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository <Pedido, Long>
{
Optional<Pedido> findByNo_pedido(Long no_pedido);

}