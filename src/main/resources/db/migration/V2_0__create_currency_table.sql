CREATE TABLE IF NOT EXISTS currency
(
    id BIGSERIAL PRIMARY KEY,
    code text,
    rate DOUBLE PRECISION
);

COMMENT ON TABLE currency IS 'Курсы валют';
COMMENT ON COLUMN currency.id IS 'Идентификатор';
COMMENT ON COLUMN currency.code IS 'Код валюты в формате ISO 4217';
COMMENT ON COLUMN currency.rate IS 'Курс валюты';