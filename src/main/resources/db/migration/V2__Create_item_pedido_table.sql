CREATE TABLE tb_itens_pedido (
                                 id SERIAL PRIMARY KEY,
                                 pedido_id BIGINT NOT NULL,
                                 produto_id BIGINT NOT NULL,
                                 quantidade INT NOT NULL,
                                 preco_unitario DECIMAL(10, 2) NOT NULL,
                                 FOREIGN KEY (pedido_id) REFERENCES tb_pedidos(id) ON DELETE CASCADE,
                                 FOREIGN KEY (produto_id) REFERENCES tb_produto(id) ON DELETE CASCADE

);

