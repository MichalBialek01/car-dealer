insert into SALESMAN (name, surname, pesel)
values ('Jakub', 'Sprzedażowy', '81050299875'),
       ('Katarzyna', 'Autoekspres', '75081214578'),
       ('Michał', 'Szybki', '68012265892'),
       ('Joanna', 'Raty', '72051945621');

insert into MECHANIC (name, surname, pesel)
values ('Adam', 'Klucz', '74030467120'),
       ('Paweł', 'Naprawczy', '85040567124'),
       ('Grzegorz', 'Wymieniacz', '69122398345');

insert into CAR_TO_BUY (vin, brand, model, year, color, price)
values ('WBA5A7C50FD737019', 'Audi', 'A4', '2021', 'white', '25000'),
       ('WAUBFAFLXCA416702', 'Audi', 'A6', '2021', 'silver', '35000'),
       ('WBA4F9C58ED723938', 'Audi', 'A6', '2021', 'silver', '35000'),
       ('WBA4A7C52FD109567', 'Audi', 'A8', '2021', 'blue', '45000'),
       ('WAUCFAFL4EN731952', 'Audi', 'A8', '2021', 'blue', '45000'),
       ('WBA7E4C59GG110593', 'Audi', 'Q7', '2021', 'black', '65000');

insert into SERVICE (service_code, description, price)
values ('12345-678', 'Wymiana opony', '250.00'),
       ('98765-432', 'Kalibracja układu', '60.50'),
       ('00123-456', 'Wymiana filtra oleju', '160.25'),
       ('78901-234', 'Wymiana uszczelki', '20.00'),
       ('45678-901', 'Wymiana filtra kabinowego', '25.50');

insert into PART (serial_number, description, price)
values ('98761-2345', 'Opona', '350.00'),
       ('54320-123', 'Olej syntetyczny', '300.00'),
       ('67891-245', 'Uszczelka', '150.00'),
       ('13579-246', 'Filtr kabinowy', '100.00');
