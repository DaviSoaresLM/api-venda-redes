package com.minhaempresa.rede_vendas_api.controller;

import com.minhaempresa.rede_vendas_api.data.dto.UserDTO;
import com.minhaempresa.rede_vendas_api.data.dto.UserLowDTO;
import com.minhaempresa.rede_vendas_api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Cadastra os dados de um usuário | role: [ADMIN]",
            tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres do nome do usuário é 150"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada. ")
    })
    @PostMapping
    public UserDTO create(@RequestBody UserDTO user) {
        return service.save(user);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO user) {
        return service.save(user);
    }

    @GetMapping("/all")
    public List<UserLowDTO> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }


}
