package com.minhaempresa.rede_vendas_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "API Venda de Redes",
                version = "1.0",
                description = "Trata-se de uma API que está sendo desenvolvida na disicplina TEPW",
                contact = @Contact(
                        name = "Davi",
                        email = "davisoaresdasilva1203@gmail.com",
                        url = "https://github.com/DaviSoaresLM")
        )
)

@SpringBootApplication
public class RedeVendasApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedeVendasApplication.class, args);
    }

}
