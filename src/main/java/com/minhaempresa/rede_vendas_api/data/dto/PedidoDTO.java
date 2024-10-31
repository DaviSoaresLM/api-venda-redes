package com.minhaempresa.rede_vendas_api.data.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoDTO {

    private Long id;
    private Long clienteId;
    private Long produtoId;
    private Integer quantidade;
    private LocalDate dataPedido;

}
