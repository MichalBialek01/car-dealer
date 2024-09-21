CREATE TABLE car_to_service
(
    car_to_service_id SERIAL      NOT NULL,
    vin               VARCHAR(20) NOT NULL,
    brand             VARCHAR(32) NOT NULL,
    model             VARCHAR(32) NOT NULL,
    production_year   SMALLINT    NOT NULL,
    PRIMARY KEY (car_to_service_id),
    UNIQUE (vin)
);