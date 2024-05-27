CREATE DATABASE IF NOT EXISTS chinacalc;

CREATE TABLE IF NOT EXISTS chinacalc_customer
(
    id                 BIGSERIAL PRIMARY KEY,
    is_private_person  boolean NOT NULL,
    customer_name      text NOT NULL,
    contact_last_name  text NOT NULL,
    contact_first_name text NOT NULL,
    contact_patronymic text,
    city               text NOT NULL,
    email              text NOT NULL,
    phone_number       text NOT NULL,
    customer_category  SMALLINT NOT NULL,
    taxpayer_number    text
);

COMMENT ON TABLE chinacalc_customer IS 'Клиенты';
COMMENT ON COLUMN chinacalc_customer.id IS 'Идентификатор';
COMMENT ON COLUMN chinacalc_customer.is_private_person IS 'Частное лицо';
COMMENT ON COLUMN chinacalc_customer.customer_name IS 'Наименование';
COMMENT ON COLUMN chinacalc_customer.contact_last_name IS 'Фамилия контактного лица';
COMMENT ON COLUMN chinacalc_customer.contact_first_name IS 'Имя контактного лица';
COMMENT ON COLUMN chinacalc_customer.contact_patronymic IS 'Отчество контактного лица';
COMMENT ON COLUMN chinacalc_customer.city IS 'Город';
COMMENT ON COLUMN chinacalc_customer.email IS 'Электронная почта';
COMMENT ON COLUMN chinacalc_customer.phone_number IS 'Номер телефона';
COMMENT ON COLUMN chinacalc_customer.customer_category IS 'Категория клиента';
COMMENT ON COLUMN chinacalc_customer.taxpayer_number IS 'ИНН';
