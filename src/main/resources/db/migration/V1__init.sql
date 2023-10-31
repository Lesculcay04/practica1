CREATE TABLE IF NOT EXISTS cliente(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS pedido(
    id SERIAL PRIMARY KEY,
    fecha_pedido DATE,
    total INT,
    cliente_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
    );
