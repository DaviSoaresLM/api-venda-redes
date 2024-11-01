CREATE TABLE tb_pagamento (
                              id SERIAL PRIMARY KEY,
                              pedido_id BIGINT NOT NULL,
                              valor DECIMAL(10, 2) NOT NULL,
                              data_pagamento DATE NOT NULL,
                              metodo_pagamento VARCHAR(50) NOT NULL,
                              FOREIGN KEY (pedido_id) REFERENCES tb_pedidos(id) ON DELETE CASCADE
);
