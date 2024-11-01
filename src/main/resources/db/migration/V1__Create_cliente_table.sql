CREATE TABLE tb_cliente (
                            id BIGSERIAL PRIMARY KEY,
                            nome VARCHAR(100) NOT NULL,
                            email VARCHAR(255),
                            telefone VARCHAR(15),
                            endereco VARCHAR(255)
);