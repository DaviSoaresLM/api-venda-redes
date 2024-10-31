package com.minhaempresa.rede_vendas_api.controller;

import com.minhaempresa.rede_vendas_api.data.dto.ProdutoDTO;
import com.minhaempresa.rede_vendas_api.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Operation(summary = "Cadastra os dados do Produto", tags = "Produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres da categoria do Produto é 100"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada.")
    })
    @PostMapping
    public ProdutoDTO create(@RequestBody ProdutoDTO produto) {
        return service.save(produto);
    }

    @Operation(summary = "Atualiza os dados de um Produto", tags = "Produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres da categoria do cliente é 100"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping
    public ProdutoDTO update(@RequestBody ProdutoDTO produto) {
        return service.save(produto);
    }

    @Operation(summary = "Lista todos os Produtos", tags = "Produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de produtos obtida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado")
    })
    @GetMapping("/produto/all")
    public List<ProdutoDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Exclui um produto pelo ID", tags = "Produto")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/produto/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Operation(summary = "Busca um produto pelo ID", tags = "Produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("/produto/{id}")
    public ProdutoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
}

