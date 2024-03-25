package org.generation.aphrodite.repository;

import java.util.Optional;

import org.generation.aphrodite.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long>
{
Optional<Pedido> findByNoPedido(Long noPedido);

}