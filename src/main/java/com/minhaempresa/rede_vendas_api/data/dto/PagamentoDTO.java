package com.minhaempresa.rede_vendas_api.data.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

    @Data
    public class PagamentoDTO {

        private Long id;
        private Long pedidoId;
        private BigDecimal valor; // BigDecimal p/ valor monetário
        private LocalDate dataPagamento;
        private String metodoPagamento;
    }

