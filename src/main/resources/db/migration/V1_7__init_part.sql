CREATE TABLE part
(
    part_id       SERIAL            NOT NULL,
    serial_number VARCHAR(32)       NOT NULL,
    description   VARCHAR(64)       NOT NULL,
    price         NUMERIC(19, 2)    NOT NULL,
    PRIMARY KEY (part_id),
    UNIQUE (serial_number)
);