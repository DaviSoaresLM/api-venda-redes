package com.minhaempresa.rede_vendas_api.controller;

import com.minhaempresa.rede_vendas_api.data.dto.PagamentoDTO;
import com.minhaempresa.rede_vendas_api.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @Operation(summary = "Cadastra os dados de um pagamento", tags = "Pagamento")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pagamento cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para o pagamento"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public PagamentoDTO create(@RequestBody PagamentoDTO pagamento) {
        return service.save(pagamento);
    }

    @Operation(summary = "Atualiza os dados de um pagamento", tags = "Pagamento")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pagamento atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para o pagamento"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    @PutMapping
    public PagamentoDTO update(@RequestBody PagamentoDTO pagamento) {
        return service.save(pagamento);
    }

    @Operation(summary = "Lista todos os pagamentos", tags = "Pagamento")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de pagamentos obtida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum pagamento encontrado")
    })
    @GetMapping("/all")
    public List<PagamentoDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Exclui um pagamento pelo ID", tags = "Pagamento")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pagamento deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Operation(summary = "Busca um pagamento pelo ID", tags = "Pagamento")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pagamento encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    @GetMapping("/{id}")
    public PagamentoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
