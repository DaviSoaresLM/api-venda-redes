package com.minhaempresa.rede_vendas_api.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;
    private String email;

    @Column(length = 15)
    private String telefone;

    @Column(length = 255)
    private String endereco;

}
