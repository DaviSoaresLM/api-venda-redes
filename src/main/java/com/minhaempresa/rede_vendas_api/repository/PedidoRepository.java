package com.minhaempresa.rede_vendas_api.repository;

import com.minhaempresa.rede_vendas_api.data.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE MONTH(p.dataPedido) = :mes AND YEAR(p.dataPedido) = :ano")
    List<Pedido> findByMesAndAno(@Param("mes") int mes, @Param("ano") int ano);

}
