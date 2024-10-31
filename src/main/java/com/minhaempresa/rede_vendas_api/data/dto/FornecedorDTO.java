package com.minhaempresa.rede_vendas_api.data.dto;


import lombok.Data;

@Data
public class FornecedorDTO {

    private Long Id;
    private String nome;
    private String contato;
    private String email;
    private String produtoOferecido;
}
