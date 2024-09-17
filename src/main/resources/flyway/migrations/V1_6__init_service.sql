CREATE TABLE service
(
    service_id   SERIAL         NOT NULL,
    service_code VARCHAR(32)    NOT NULL,
    description  VARCHAR(64)    NOT NULL,
    price        NUMERIC(19, 2) NOT NULL,
    PRIMARY KEY (service_id),
    UNIQUE (service_code)
);