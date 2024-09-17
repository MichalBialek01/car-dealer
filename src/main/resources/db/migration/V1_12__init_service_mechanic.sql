CREATE TABLE service_mechanic
(
    service_mechanic_id SERIAL          NOT NULL,
    hours                   INT         NOT NULL,
    comment                 VARCHAR(32) NOT NULL,
    car_service_request_id  INT         NOT NULL,
    mechanic_id             INT         NOT NULL,
    service_id              INT         NOT NULL,
    PRIMARY KEY (service_mechanic_id),
    CONSTRAINT fk_service_mechanic_car_service_request
        FOREIGN KEY (car_service_request_id)
            REFERENCES car_service_request (car_service_request_id),
    CONSTRAINT fk_service_mechanic_mechanic
        FOREIGN KEY (mechanic_id)
            REFERENCES mechanic (mechanic_id),
    CONSTRAINT fk_service_mechanic_service
        FOREIGN KEY (service_id)
            REFERENCES service (service_id)
);