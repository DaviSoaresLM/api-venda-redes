package com.minhaempresa.rede_vendas_api.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;
    private String email;

    @Column(unique = true)
    private String login;
    private String password;

}
