package com.minhaempresa.rede_vendas_api.service;

import com.minhaempresa.rede_vendas_api.data.dto.FornecedorDTO;
import com.minhaempresa.rede_vendas_api.data.model.Fornecedor;
import com.minhaempresa.rede_vendas_api.dozer.DozerConverter;
import com.minhaempresa.rede_vendas_api.exception.CommonsException;
import com.minhaempresa.rede_vendas_api.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public FornecedorDTO save(FornecedorDTO fornecedorDTO) {
        // Valida o fornecedor (exemplo: verificar se o nome não é nulo ou vazio)
        if (fornecedorDTO.getNome() == null || fornecedorDTO.getNome().isEmpty()) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "redevendas.service.fornecedor.request",
                    "O nome do fornecedor não pode ser nulo ou vazio");
        }

        // Converte FornecedorDTO para Fornecedor
        Fornecedor entity = DozerConverter.parseObject(fornecedorDTO, Fornecedor.class);

        // Salva o Fornecedor na base de dados
        Fornecedor savedEntity = repository.save(entity);

        // Converte e retorna o Fornecedor salvo para FornecedorDTO
        return DozerConverter.parseObject(savedEntity, FornecedorDTO.class);
    }

    public List<FornecedorDTO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), FornecedorDTO.class);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "redevendas.service.fornecedor.notfound",
                    "O fornecedor com a ID informada não foi encontrado");
        }
        repository.deleteById(id);
    }

    public FornecedorDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new CommonsException(HttpStatus.NOT_FOUND,
                        "redevendas.service.fornecedor.notfound",
                        "O fornecedor com a ID informada não foi encontrado"));

        return DozerConverter.parseObject(entity, FornecedorDTO.class);
    }
}
