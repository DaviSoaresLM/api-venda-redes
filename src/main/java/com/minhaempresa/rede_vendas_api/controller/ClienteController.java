package com.minhaempresa.rede_vendas_api.controller;

import com.minhaempresa.rede_vendas_api.data.dto.ClienteDTO;
import com.minhaempresa.rede_vendas_api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Operation(summary = "Cadastra os dados de um cliente", tags = "Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres do nome do cliente é 150"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada.")
    })
    @PostMapping
    public ClienteDTO create(@RequestBody ClienteDTO cliente) {
        return service.save(cliente);
    }

    @Operation(summary = "Atualiza os dados de um cliente", tags = "Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres do nome do cliente é 150"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @PutMapping
    public ClienteDTO update(@RequestBody ClienteDTO cliente) {
        return service.save(cliente);
    }

    @Operation(summary = "Lista todos os clientes", tags = "Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de clientes obtida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente encontrado")
    })
    @GetMapping("/all")
    public List<ClienteDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Exclui um cliente pelo ID", tags = "Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Operation(summary = "Busca um cliente pelo ID", tags = "Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
}

