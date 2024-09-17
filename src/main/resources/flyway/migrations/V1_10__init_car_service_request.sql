CREATE TABLE car_service_request
(
    car_service_request_id      SERIAL                      NOT NULL,
    car_service_request_number  VARCHAR(32)                 NOT NULL,
    received_date_time          TIMESTAMP WITH TIME ZONE    NOT NULL,
    completed_date_time         TIMESTAMP WITH TIME ZONE,
    customer_comment            TEXT,
    customer_id                 INT                         NOT NULL,
    car_to_service_id           INT                         NOT NULL,
    PRIMARY KEY (car_service_request_id),
    UNIQUE (car_service_request_number),
    CONSTRAINT fk_car_service_request_customer
        FOREIGN KEY (customer_id)
            REFERENCES customer (customer_id),
    CONSTRAINT fk_car_service_request_car
        FOREIGN KEY (car_to_service_id)
            REFERENCES car_to_service (car_to_service_id)
);