CREATE TABLE car_to_buy
(
    car_to_buy_id   SERIAL         NOT NULL,
    vin             VARCHAR(20)    NOT NULL,
    brand           VARCHAR(32)    NOT NULL,
    model           VARCHAR(32)    NOT NULL,
    production_year SMALLINT       NOT NULL,
    color           VARCHAR(32),
    price           NUMERIC(19, 2) NOT NULL,
    PRIMARY KEY (car_to_buy_id),
    UNIQUE (vin)
);