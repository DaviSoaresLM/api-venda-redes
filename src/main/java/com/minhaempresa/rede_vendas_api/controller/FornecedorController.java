package com.minhaempresa.rede_vendas_api.controller;

import com.minhaempresa.rede_vendas_api.data.dto.FornecedorDTO;
import com.minhaempresa.rede_vendas_api.service.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @Operation(summary = "Cadastra os dados de um fornecedor", tags = "Fornecedor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Fornecedor cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para o fornecedor")
    })
    @PostMapping
    public FornecedorDTO create(@RequestBody FornecedorDTO fornecedor) {
        return service.save(fornecedor);
    }

    @Operation(summary = "Atualiza os dados de um fornecedor", tags = "Fornecedor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Fornecedor atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para o fornecedor"),
            @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado")
    })
    @PutMapping
    public FornecedorDTO update(@RequestBody FornecedorDTO fornecedor) {
        return service.save(fornecedor);
    }

    @Operation(summary = "Lista todos os fornecedores", tags = "Fornecedor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de fornecedores obtida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum fornecedor encontrado")
    })
    @GetMapping("/all")
    public List<FornecedorDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Exclui um fornecedor pelo ID", tags = "Fornecedor")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Fornecedor deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Operation(summary = "Busca um fornecedor pelo ID", tags = "Fornecedor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Fornecedor encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado")
    })
    @GetMapping("/{id}")
    public FornecedorDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
