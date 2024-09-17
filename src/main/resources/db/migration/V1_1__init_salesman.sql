CREATE TABLE salesman
(
    salesman_id SERIAL      NOT NULL,
    name        VARCHAR(32) NOT NULL,
    surname     VARCHAR(32) NOT NULL,
    pesel       VARCHAR(32) NOT NULL,
    PRIMARY KEY (salesman_id)
);