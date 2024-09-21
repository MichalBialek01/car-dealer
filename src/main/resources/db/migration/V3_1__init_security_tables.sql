CREATE TABLE car_dealership_user
(
    user_id   SERIAL       NOT NULL PRIMARY KEY,
    user_name VARCHAR(32)  NOT NULL,
    email     VARCHAR(32)  NOT NULL,
    password  VARCHAR(128) NOT NULL,
    active    BOOLEAN      NOT NULL
);
CREATE TABLE car_dealership_authority
(
    authority_id SERIAL      NOT NULL PRIMARY KEY,
    authority    VARCHAR(20) NOT NULL
);

CREATE TABLE car_dealership_user_authority
(
    user_id      INT NOT NULL,
    authority_id INT NOT NULL,

    PRIMARY KEY (user_id, authority_id),

    CONSTRAINT fk_car_dealership_user_authority_user
        FOREIGN KEY (user_id)
            REFERENCES car_dealership_user (user_id),

    CONSTRAINT fk_car_dealership_user_authority_authority
        FOREIGN KEY (authority_id)
            REFERENCES car_dealership_authority (authority_id)
);
