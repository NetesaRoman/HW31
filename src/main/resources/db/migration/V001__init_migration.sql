-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_shop;

-- Создание последовательности;
CREATE SEQUENCE IF NOT EXISTS my_shop.my_shop_seq;

-- Создание таблицы;
CREATE TABLE IF NOT EXISTS my_shop.product
(
    id serial PRIMARY KEY,
    name text,
    cost double precision

);








