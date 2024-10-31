package com.minhaempresa.rede_vendas_api.data.dto;

import lombok.Data;

@Data
public class ProdutoDTO {

    private Long id;
    private String categoria;
    private String material;
    private String cor;
    private String tamanho;
}
