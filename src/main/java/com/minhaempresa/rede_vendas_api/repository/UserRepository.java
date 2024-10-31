package com.minhaempresa.rede_vendas_api.repository;

import com.minhaempresa.rede_vendas_api.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
