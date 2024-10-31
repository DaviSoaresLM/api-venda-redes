package com.minhaempresa.rede_vendas_api.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_pedidos")
@Data
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String cliente_id;
    private String produto_id;
    private String quantidade;
    private String data_pedido;





}
