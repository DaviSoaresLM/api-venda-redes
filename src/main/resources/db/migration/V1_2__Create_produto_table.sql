CREATE TABLE tb_produto (
                            id SERIAL PRIMARY KEY,
                            categoria VARCHAR(100) NOT NULL,
                            material VARCHAR(255),
                            cor VARCHAR(255),
                            tamanho VARCHAR(255)
);
