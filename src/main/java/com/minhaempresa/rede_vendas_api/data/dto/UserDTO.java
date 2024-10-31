package com.minhaempresa.rede_vendas_api.data.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String login;
    private String password;

}
