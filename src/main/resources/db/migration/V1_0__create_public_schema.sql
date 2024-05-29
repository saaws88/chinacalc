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

CREATE TABLE IF NOT EXISTS chinacalc_order
(
        id                 BIGSERIAL PRIMARY KEY,
        creation_date      timestamp NOT NULL,
        receiver_city      text NOT NULL,
        weight             double precision NOT NULL,
        volume             double precision NOT NULL,
        purchase_cost      bigint NOT NULL,
        package_type       SMALLINT CHECK (package_type BETWEEN 0 and 2),
        status             SMALLINT CHECK (status BETWEEN 0 and 7),
        customer_id        bigint REFERENCES chinacalc_customer(id),
        packaged_weight    double precision,
        packaged_volume    double precision,
        insurance_cost     double precision,
        cost_to_yiwu       double precision,
        cost_to_russia_rur double precision,
        total_cost         double precision,
        purchase_link      text

);

COMMENT ON TABLE chinacalc_order IS 'Заказ';
COMMENT ON COLUMN chinacalc_order.id IS 'Идентификатор';
COMMENT ON COLUMN chinacalc_order.creation_date IS 'Дата создания заказа';
COMMENT ON COLUMN chinacalc_order.receiver_city IS 'Город-получатель';
COMMENT ON COLUMN chinacalc_order.weight IS 'Вес заказа';
COMMENT ON COLUMN chinacalc_order.volume IS 'Объем заказа';
COMMENT ON COLUMN chinacalc_order.purchase_cost IS 'Стоимость товара';
COMMENT ON COLUMN chinacalc_order.package_type IS 'Тип упаковки';
COMMENT ON COLUMN chinacalc_order.status IS 'Статус заказа';
COMMENT ON COLUMN chinacalc_order.customer_id IS 'Идентификатор клиента в БД';
COMMENT ON COLUMN chinacalc_order.packaged_weight IS 'Вес заказа в упаковке';
COMMENT ON COLUMN chinacalc_order.packaged_volume IS 'Объем заказа в упаковке';
COMMENT ON COLUMN chinacalc_order.insurance_cost IS 'Стоимость страховки';
COMMENT ON COLUMN chinacalc_order.cost_to_yiwu IS 'Стоимость доставки до ИУ';
COMMENT ON COLUMN chinacalc_order.cost_to_russia_rur IS 'Стоимость доставки до РФ';
COMMENT ON COLUMN chinacalc_order.total_cost IS 'Общая стоимость заказа';
COMMENT ON COLUMN chinacalc_order.purchase_link IS 'Ссылка на товар';


CREATE TABLE IF NOT EXISTS chinacalc_users
(
        id                 BIGSERIAL PRIMARY KEY,
        email              text NOT NULL,
        username           text NOT NULL,
        password           text NOT NULL,
        acc_not_expired    boolean NOT NULL,
        acc_not_locked     boolean NOT NULL,
        creds_not_expired  boolean NOT NULL
);

COMMENT ON TABLE chinacalc_users IS 'Пользователь';
COMMENT ON COLUMN chinacalc_users.id IS 'Идентификатор';
COMMENT ON COLUMN chinacalc_users.email IS 'Адрес электронной почты';
COMMENT ON COLUMN chinacalc_users.username IS 'Имя пользователя';
COMMENT ON COLUMN chinacalc_users.password IS 'Пароль';
COMMENT ON COLUMN chinacalc_users.acc_not_expired IS 'Аккаунт активен';
COMMENT ON COLUMN chinacalc_users.id IS 'Аккаунт не заблокирован';
COMMENT ON COLUMN chinacalc_users.id IS 'Доступы аккаунта активны';

CREATE TABLE user_role
(
    user_id bigint NOT NULL REFERENCES chinacalc_users(id),
    roles   SMALLINT CHECK (roles BETWEEN 0 and 1)
);

COMMENT ON TABLE user_role IS 'Роли пользователя';
COMMENT ON COLUMN user_role.user_id IS 'Идентификатор пользователя';
COMMENT ON COLUMN user_role.roles IS 'Роли';
