INSERT INTO CHAPTER (NAME, PARENT_LEGION)
VALUES ('Paul Atreides', 'Atreides'),
       ('Chani Kynes', 'Fremen'),
       ('Lady Jessica', 'Bene Gesserit'),
       ('Leto Atreides', 'Atreides');

INSERT INTO COORDINATES (X, Y)
VALUES (0, 0),
       (100, 100),
       (200, 200),
       (300, 300),
       (400, 400),
       (500, 500),
       (600, 600),
       (700, 700),
       (800, 800),
       (900, 900);

INSERT INTO SPACE_MARINE (NAME, COORDINATES, CREATION_DATE, HEALTH, HEART_COUNT, LOYAL, CATEGORY, CHAPTER)
VALUES ('Heighliner', 18, '2003-01-01', 4, 3, true , 'APOTHECARY', 25),
       ('Arcadia', 22, '2003-01-01', 11, 2, true, 'HELIX', 26),
       ('Black Hawk', 21, '2003-01-01', 11, 2, true, 'LIBRARIAN', 27),
       ('Charlotte', 27, '2021-01-01', 11, 1, true, 'LIBRARIAN', 27),
       ('Shark', 26, '2004-01-01', 3, 3, true, 'AGGRESSOR', 27);
