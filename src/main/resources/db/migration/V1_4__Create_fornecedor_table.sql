CREATE TABLE tb_fornecedor (
                               id SERIAL PRIMARY KEY,
                               nome VARCHAR(100) NOT NULL,
                               contato VARCHAR(50) NOT NULL,
                               email VARCHAR(100) NOT NULL,
                               produto_oferecido VARCHAR(100) NOT NULL
);