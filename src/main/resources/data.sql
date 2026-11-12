INSERT INTO BEFOGADO (nev, neme, sz_datum, telefon_szam, email)
VALUES
('Kovács Anna', 'FEMALE', '1990-04-12', '+36301234561', 'anna.kovacs@example.com'),
('Nagy Péter', 'MALE', '1985-08-21', '+36301234562', 'peter.nagy@example.com'),
('Szabó Eszter', 'FEMALE', '1995-02-10', '+36301234563', 'eszter.szabo@example.com'),
('Tóth Gábor', 'MALE', '1980-11-05', '+36301234564', 'gabor.toth@example.com'),
('Varga Réka', 'FEMALE', '1992-06-18', '+36301234565', 'reka.varga@example.com'),
('Kiss Bence', 'MALE', '1988-09-30', '+36301234566', 'bence.kiss@example.com'),
('Molnár Dóra', 'FEMALE', '1998-01-15', '+36301234567', 'dora.molnar@example.com'),
('Horváth Ádám', 'MALE', '1983-03-25', '+36301234568', 'adam.horvath@example.com'),
('Farkas Zsófia', 'FEMALE', '1991-07-09', '+36301234569', 'zsofia.farkas@example.com'),
('Balogh Márk', 'MALE', '1994-12-02', '+36301234570', 'mark.balogh@example.com');


INSERT INTO DOLGOZO (nev, neme, sz_datum, telefon_szam, email, beosztas)
VALUES
('Kovács Tamás', 'MALE', '1985-03-14', '+36302000001', 'tamas.kovacs@example.com', 'Gondozó'),
('Nagy Judit', 'FEMALE', '1990-06-22', '+36302000002', 'judit.nagy@example.com', 'Gondozó'),
('Szabó András', 'MALE', '1982-09-11', '+36302000003', 'andras.szabo@example.com', 'Gondozó'),
('Tóth Erika', 'FEMALE', '1993-01-28', '+36302000004', 'erika.toth@example.com', 'Állatorvosi asszisztens'),
('Varga Péter', 'MALE', '1987-12-07', '+36302000005', 'peter.varga@example.com', 'Adminisztrátor');

INSERT INTO ALLATOK
(nev, fajta, allat_tipus, neme, sz_datum, arrival_date,
 fogadasi_allapot, egeszseg_allapot, adopter_id)
VALUES
('Morzsi', 'Labrador', 'Kutya', 'MALE', '2021-05-10', '2025-01-10', 'ADOPTALHATO', 'EGESZSEGES', NULL),
('Luna', 'Beagle', 'Kutya', 'FEMALE', '2020-08-15', '2025-01-12', 'ADOPTALHATO', 'GYOGYULAS_FELE', NULL),
('Cirmi', 'Házi macska', 'Macska', 'FEMALE', '2022-03-20', '2025-02-01', 'ADOPTALT', 'EGESZSEGES', 1),
('Buksi', 'Német juhász', 'Kutya', 'MALE', '2019-11-02', '2025-02-05', 'NEM_BEFOGADHATO', 'KEZELES_ALAT', NULL),
('Mici', 'Házi macska', 'Macska', 'FEMALE', '2023-06-12', '2025-02-10', 'ADOPTALHATO', 'EGESZSEGES', NULL),
('Max', 'Golden retriever', 'Kutya', 'MALE', '2021-09-25', '2025-03-01', 'ADOPTALT', 'EGESZSEGES', 2),
('Bella', 'Uszkár', 'Kutya', 'FEMALE', '2020-04-18', '2025-03-05', 'ADOPTALHATO', 'KRITIKUS', NULL),
('Pamacs', 'Házi macska', 'Macska', 'MALE', '2022-12-01', '2025-03-10', 'ADOPTALHATO', 'GYOGYULAS_FELE', NULL),
('Rex', 'Vizsla', 'Kutya', 'MALE', '2018-07-07', '2025-04-01', 'ADOPTALT', 'EGESZSEGES', 3),
('Hógolyó', 'Bichon', 'Kutya', 'MALE', '2023-01-15', '2025-04-05', 'ADOPTALHATO', 'EGESZSEGES', NULL),
('Folti', 'Házi macska', 'Macska', 'FEMALE', '2021-02-14', '2025-04-10', 'ADOPTALT', 'KEZELES_ALAT', 4),
('Daisy', 'Tacskó', 'Kutya', 'FEMALE', '2020-10-30', '2025-05-01', 'ADOPTALHATO', 'EGESZSEGES', NULL),
('Zokni', 'Házi macska', 'Macska', 'MALE', '2022-05-19', '2025-05-05', 'NEM_BEFOGADHATO', 'GYOGYULAS_FELE', NULL),
('Charlie', 'Border collie', 'Kutya', 'MALE', '2019-08-08', '2025-05-10', 'ADOPTALT', 'EGESZSEGES', 5),
('Nala', 'Házi macska', 'Macska', 'FEMALE', '2023-04-22', '2025-06-01', 'ADOPTALHATO', 'EGESZSEGES', NULL);

INSERT INTO GONDO_ALLAT_KAPCS
(dolgozo_id, animal_id, kezdet, eddig)
VALUES
(1, 1, '2025-01-10', NULL),
(1, 2, '2025-01-12', NULL),
(1, 3, '2025-02-01', '2025-06-01'),
(1, 4, '2025-02-05', NULL),
(1, 5, '2025-02-10', '2025-07-10'),

(2, 6, '2025-03-01', NULL),
(2, 7, '2025-03-05', NULL),
(2, 8, '2025-03-10', '2025-08-10'),
(2, 9, '2025-04-01', NULL),
(2, 10, '2025-04-05', '2025-09-05'),

(3, 11, '2025-04-10', NULL),
(3, 12, '2025-05-01', NULL),
(3, 13, '2025-05-05', '2025-10-05'),
(3, 14, '2025-05-10', NULL),
(3, 15, '2025-06-01', '2025-11-01');

INSERT INTO FELHASZNALO
(username, password, role, dolgozo_id, befogado_id)
VALUES
('anna.kovacs@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO',  NULL, 1),
('peter.nagy@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO',  NULL, 2),
('eszter.szabo@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO',  NULL, 3),
('gabor.toth@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO', NULL, 4),
('reka.varga@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO',  NULL, 5),
('bence.kiss@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO', NULL, 6),
('dora.molnar@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO',  NULL, 7),
('adam.horvath@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO',  NULL, 8),
('zsofia.farkas@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO', NULL, 9),
('mark.balogh@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'BEFOGADO',  NULL, 10),
('tamas.kovacs@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'DOLGOZO',  1, NULL),
('judit.nagy@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'DOLGOZO',  2, NULL),
('andras.szabo@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'DOLGOZO',  3, NULL),
('erika.toth@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'DOLGOZO',  4, NULL),
('peter.varga@example.com', '$2a$10$og0u90H680Y133uokTnQXOB4IrMJKVCTDuwcKn3qMqjQNKXGXXwd2', 'ADMIN', 5, NULL);









