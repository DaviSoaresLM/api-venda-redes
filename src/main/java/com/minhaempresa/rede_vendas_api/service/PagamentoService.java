package com.minhaempresa.rede_vendas_api.service;

import java.math.BigDecimal;
import com.minhaempresa.rede_vendas_api.data.dto.PagamentoDTO;
import com.minhaempresa.rede_vendas_api.data.model.Pagamento;
import com.minhaempresa.rede_vendas_api.dozer.DozerConverter;
import com.minhaempresa.rede_vendas_api.exception.CommonsException;
import com.minhaempresa.rede_vendas_api.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;



// ...

    public PagamentoDTO save(PagamentoDTO pagamentoDTO) {
        // Verifica se o valor é menor ou igual a zero
        if (pagamentoDTO.getValor() == null || pagamentoDTO.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "redevendas.service.pagamento.request",
                    "O valor do pagamento deve ser maior que zero");
        }

        // Converte PagamentoDTO para Pagamento
        Pagamento entity = DozerConverter.parseObject(pagamentoDTO, Pagamento.class);

        // Salva o Pagamento na base de dados
        Pagamento savedEntity = repository.save(entity);

        // Converte e retorna o Pagamento salvo para PagamentoDTO
        return DozerConverter.parseObject(savedEntity, PagamentoDTO.class);
    }


    public List<PagamentoDTO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PagamentoDTO.class);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "redevendas.service.pagamento.notfound",
                    "O pagamento com a ID informada não foi encontrado");
        }
        repository.deleteById(id);
    }

    public PagamentoDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new CommonsException(HttpStatus.NOT_FOUND,
                        "redevendas.service.pagamento.notfound",
                        "O pagamento com a ID informada não foi encontrado"));

        return DozerConverter.parseObject(entity, PagamentoDTO.class);
    }
}
