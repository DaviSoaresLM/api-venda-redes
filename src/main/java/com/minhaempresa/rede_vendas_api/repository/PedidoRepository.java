package com.minhaempresa.rede_vendas_api.repository;

import com.minhaempresa.rede_vendas_api.data.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
