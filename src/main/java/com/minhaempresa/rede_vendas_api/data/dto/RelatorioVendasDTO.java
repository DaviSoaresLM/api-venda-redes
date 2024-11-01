package com.minhaempresa.rede_vendas_api.data.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RelatorioVendasDTO {
    private int totalVendas;
    private BigDecimal totalArrecadado;
    private String produtoMaisVendido;
}
