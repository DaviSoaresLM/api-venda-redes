package com.minhaempresa.rede_vendas_api.service;

import com.minhaempresa.rede_vendas_api.data.dto.RelatorioVendasDTO;
import com.minhaempresa.rede_vendas_api.data.model.Pedido;
import com.minhaempresa.rede_vendas_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RelatorioVendasService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public RelatorioVendasDTO gerarRelatorio(int mes, int ano) {
        List<Pedido> pedidos = pedidoRepository.findByMesAndAno(mes, ano);
        RelatorioVendasDTO relatorio = new RelatorioVendasDTO();

        // Total de vendas
        relatorio.setTotalVendas(pedidos.size());

        // Total arrecadado
        BigDecimal totalArrecadado = pedidos.stream()
                .map(Pedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        relatorio.setTotalArrecadado(totalArrecadado);

        // Produto mais vendido
        String produtoMaisVendido = pedidos.stream()
                .flatMap(p -> p.getItens().stream())
                .collect(Collectors.groupingBy(item -> item.getProduto().getCategoria(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum produto vendido");

        relatorio.setProdutoMaisVendido(produtoMaisVendido);

        return relatorio;
    }
}
