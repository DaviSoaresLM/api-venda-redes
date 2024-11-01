package com.minhaempresa.rede_vendas_api.controller;

import com.minhaempresa.rede_vendas_api.data.dto.RelatorioVendasDTO;
import com.minhaempresa.rede_vendas_api.service.RelatorioVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioVendasController {

    @Autowired
    private RelatorioVendasService relatorioVendasService;

    @GetMapping("/{mes}/{ano}")
    public RelatorioVendasDTO gerarRelatorio(@PathVariable int mes, @PathVariable int ano) {
        return relatorioVendasService.gerarRelatorio(mes, ano);
    }
}
