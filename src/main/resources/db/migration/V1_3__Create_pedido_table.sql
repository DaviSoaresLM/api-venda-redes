CREATE TABLE tb_pedidos (
                            id SERIAL PRIMARY KEY,
                            data_pedido DATE NOT NULL,
                            valor_total DECIMAL(15, 2)
);