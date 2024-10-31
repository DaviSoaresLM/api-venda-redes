package com.minhaempresa.rede_vendas_api.service;

import com.minhaempresa.rede_vendas_api.data.dto.ProdutoDTO;
import com.minhaempresa.rede_vendas_api.data.model.Produto;
import com.minhaempresa.rede_vendas_api.dozer.DozerConverter;
import com.minhaempresa.rede_vendas_api.exception.CommonsException;
import com.minhaempresa.rede_vendas_api.repository.ProdutoRepository; // Importando o repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository; // Adicionando o repositório

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        if (produtoDTO.getCategoria().length() > 100) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "redevendas.service.produto.request",
                    "O limite de caracteres para a categoria do produto é 100");
        }

        // Converte ProdutoDTO para Produto
        Produto entity = DozerConverter.parseObject(produtoDTO, Produto.class);

        // Salva o Produto na base de dados
        Produto savedEntity = repository.save(entity);

        // Converte e retorna o Produto salvo para ProdutoDTO
        return DozerConverter.parseObject(savedEntity, ProdutoDTO.class);
    }

    public List<ProdutoDTO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), ProdutoDTO.class);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "redevendas.service.produto.notfound", // Alterando a chave para produto
                    "O produto com a ID informada não foi encontrado");
        }
        repository.deleteById(id);
    }

    public ProdutoDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new CommonsException(HttpStatus.NOT_FOUND,
                        "redevendas.service.produto.notfound", // Alterando a chave para produto
                        "O produto com a ID informada não foi encontrado"));

        return DozerConverter.parseObject(entity, ProdutoDTO.class);
    }
}

