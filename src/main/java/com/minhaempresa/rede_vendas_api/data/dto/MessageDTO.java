package com.minhaempresa.rede_vendas_api.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class MessageDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
    private String key;

}
