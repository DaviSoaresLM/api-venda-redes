package com.minhaempresa.rede_vendas_api.service;

import com.minhaempresa.rede_vendas_api.data.dto.PedidoDTO;
import com.minhaempresa.rede_vendas_api.data.model.Pedido;
import com.minhaempresa.rede_vendas_api.dozer.DozerConverter;
import com.minhaempresa.rede_vendas_api.exception.CommonsException;
import com.minhaempresa.rede_vendas_api.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public PedidoDTO save(PedidoDTO pedidoDTO) {
        if (pedidoDTO.getClienteId() == null || pedidoDTO.getProdutoId() == null) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "redevendas.service.pedido.request",
                    "IDs de cliente e produto não podem ser nulos");
        }

        // Converte PedidoDTO para Pedido
        Pedido entity = DozerConverter.parseObject(pedidoDTO, Pedido.class);

        // Salva o Pedido na base de dados
        Pedido savedEntity = repository.save(entity);

        // Converte e retorna o Pedido salvo para PedidoDTO
        return DozerConverter.parseObject(savedEntity, PedidoDTO.class);
    }

    public List<PedidoDTO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PedidoDTO.class);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "redevendas.service.pedido.notfound",
                    "O pedido com a ID informada não foi encontrado");
        }
        repository.deleteById(id);
    }

    public PedidoDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new CommonsException(HttpStatus.NOT_FOUND,
                        "redevendas.service.pedido.notfound",
                        "O pedido com a ID informada não foi encontrado"));

        return DozerConverter.parseObject(entity, PedidoDTO.class);
    }
}
