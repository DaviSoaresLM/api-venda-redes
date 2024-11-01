package com.minhaempresa.rede_vendas_api.controller;

import com.minhaempresa.rede_vendas_api.data.dto.PedidoDTO;
import com.minhaempresa.rede_vendas_api.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Operation(summary = "Cadastra os dados de um pedido", tags = "Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para o pedido"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public PedidoDTO create(@RequestBody PedidoDTO pedido) {
        return service.save(pedido);
    }

    @Operation(summary = "Atualiza os dados de um pedido", tags = "Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para o pedido"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    @PutMapping
    public PedidoDTO update(@RequestBody PedidoDTO pedido) {
        return service.save(pedido);
    }

    @Operation(summary = "Lista todos os pedidos", tags = "Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de pedidos obtida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum pedido encontrado")
    })
    @GetMapping("/all")
    public List<PedidoDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Exclui um pedido pelo ID", tags = "Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pedido deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Operation(summary = "Busca um pedido pelo ID", tags = "Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    @GetMapping("/{id}")
    public PedidoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }


}
