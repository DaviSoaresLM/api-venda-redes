package com.minhaempresa.rede_vendas_api.service;

import com.minhaempresa.rede_vendas_api.data.dto.ClienteDTO;
import com.minhaempresa.rede_vendas_api.data.model.Cliente;
import com.minhaempresa.rede_vendas_api.dozer.DozerConverter;
import com.minhaempresa.rede_vendas_api.exception.CommonsException;
import com.minhaempresa.rede_vendas_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteDTO save(ClienteDTO clienteDTO) {
        if (clienteDTO.getNome().length() > 150) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "redevendas.service.cliente.request",
                    "O limite de caracteres do nome do cliente é 150");
        }

        // Converte ClienteDTO para Cliente
        Cliente entity = DozerConverter.parseObject(clienteDTO, Cliente.class);

        // Salva o Cliente na base de dados
        Cliente savedEntity = repository.save(entity);

        // Converte e retorna o Cliente salvo para ClienteDTO
        return DozerConverter.parseObject(savedEntity, ClienteDTO.class);
    }

    public List<ClienteDTO> findAll() {
        return DozerConverter.parseListObjects(
                repository.findAll(), ClienteDTO.class);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "redevendas.service.cliente.notfound",
                    "O cliente com a ID informada não foi encontrado");
        }
        repository.deleteById(id);
    }

    public ClienteDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new CommonsException(HttpStatus.NOT_FOUND,
                        "redevendas.service.cliente.notfound",
                        "O cliente com a ID informada não foi encontrado"));

        return DozerConverter.parseObject(entity, ClienteDTO.class);
    }
}

