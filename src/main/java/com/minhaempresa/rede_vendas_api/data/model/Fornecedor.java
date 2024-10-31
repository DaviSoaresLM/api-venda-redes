package com.minhaempresa.rede_vendas_api.data.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_fornecedor")
@Data
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String contato;

    @Email
    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String produtoOferecido;
}
