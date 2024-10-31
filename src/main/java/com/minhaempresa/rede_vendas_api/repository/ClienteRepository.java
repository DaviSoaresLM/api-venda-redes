package com.minhaempresa.rede_vendas_api.repository;

import com.minhaempresa.rede_vendas_api.data.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
