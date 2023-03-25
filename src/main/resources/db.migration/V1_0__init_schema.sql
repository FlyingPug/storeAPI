CREATE TABLE products (
    id serial PRIMARY KEY,
    serial_number BIGINT NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    price BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    form_factor VARCHAR(255),
    screen_size INTEGER,
    diagonal INTEGER,
    disk_size_in_gb BIGINT
);
