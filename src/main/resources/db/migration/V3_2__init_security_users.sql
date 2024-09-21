ALTER TABLE salesman
    ADD COLUMN user_id INT,
    ADD FOREIGN KEY (user_id) REFERENCES car_dealership_user (user_id);

ALTER TABLE mechanic
    ADD COLUMN user_id INT,
    ADD FOREIGN KEY (user_id) REFERENCES car_dealership_user (user_id);

-- Salesmen
insert into car_dealership_user (user_id, user_name, email, password, active) values (1, 'jakub_sprzedazowy', 'jakub_sprzedazowy@example.pl', '$2a$12$/Frr7y4qSUyRNyEYIB1bH.ON0fmmWJdHla/0UFXMUxjrjylGNxYh6', true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (2, 'katarzyna_autoekspres', 'katarzyna_autoekspres@example.pl', '$2a$12$/Frr7y4qSUyRNyEYIB1bH.ON0fmmWJdHla/0UFXMUxjrjylGNxYh6', true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (3, 'michal_szybki', 'michal_szybki@example.pl', '$2a$12$/Frr7y4qSUyRNyEYIB1bH.ON0fmmWJdHla/0UFXMUxjrjylGNxYh6', true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (4, 'joanna_raty', 'joanna_raty@example.pl', '$2a$12$/Frr7y4qSUyRNyEYIB1bH.ON0fmmWJdHla/0UFXMUxjrjylGNxYh6', true);

-- Mechanics
insert into car_dealership_user (user_id, user_name, email, password, active) values (5, 'adam_klucz', 'adam_klucz@example.pl', '$2a$12$/Frr7y4qSUyRNyEYIB1bH.ON0fmmWJdHla/0UFXMUxjrjylGNxYh6', true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (6, 'pawel_naprawczy', 'pawel_naprawczy@example.pl', '$2a$12$/Frr7y4qSUyRNyEYIB1bH.ON0fmmWJdHla/0UFXMUxjrjylGNxYh6', true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (7, 'grzegorz_wymieniacz', 'grzegorz_wymieniacz@example.pl', '$2a$12$/Frr7y4qSUyRNyEYIB1bH.ON0fmmWJdHla/0UFXMUxjrjylGNxYh6', true);

insert into car_dealership_user (user_id, user_name, email, password, active) values (8, 'test_user', 'test_user@example.pl', '$2a$12$TwQsp1IusXTDl7LwZqL0qeu49Ypr6vRdEzRq2vAsgb.zvOtrnzm5G', true);


UPDATE salesman SET user_id = 1 WHERE pesel = '81050299875';
UPDATE salesman SET user_id = 2 WHERE pesel = '75081214578';
UPDATE salesman SET user_id = 3 WHERE pesel = '68012265892';
UPDATE salesman SET user_id = 4 WHERE pesel = '72051945621';

UPDATE mechanic SET user_id = 5 WHERE pesel = '74030467120';
UPDATE mechanic SET user_id = 6 WHERE pesel = '85040567124';
UPDATE mechanic SET user_id = 7 WHERE pesel = '69122398345';

insert into car_dealership_authority (authority_id, authority) values (1, 'SALESMAN'), (2, 'MECHANIC'), (3, 'REST_API');

insert into car_dealership_user_authority (user_id, authority_id) values (1, 1), (2, 1), (3, 1), (4, 1);
insert into car_dealership_user_authority (user_id, authority_id) values (5, 2), (6, 2), (7, 2);
insert into car_dealership_user_authority (user_id, authority_id) values (8, 3);

ALTER TABLE salesman
    ALTER COLUMN user_id SET NOT NULL;

ALTER TABLE mechanic
    ALTER COLUMN user_id SET NOT NULL;