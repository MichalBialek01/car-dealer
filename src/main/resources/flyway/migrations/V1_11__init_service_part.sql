CREATE TABLE service_part
(
    service_part_id         SERIAL   NOT NULL,
    quantity                INT      NOT NULL,
    car_service_request_id  INT      NOT NULL,
    part_id                 INT      NOT NULL,
    PRIMARY KEY (service_part_id),
    CONSTRAINT fk_service_part_service_request
        FOREIGN KEY (car_service_request_id)
            REFERENCES car_service_request (car_service_request_id),
    CONSTRAINT fk_service_part_part
        FOREIGN KEY (part_id)
            REFERENCES part (part_id)
);
