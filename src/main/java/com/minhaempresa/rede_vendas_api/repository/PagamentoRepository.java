package com.minhaempresa.rede_vendas_api.repository;

import com.minhaempresa.rede_vendas_api.data.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
