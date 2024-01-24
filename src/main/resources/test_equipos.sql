CREATE TABLE EQUIPOS (
                         ID int not null AUTO_INCREMENT,
                         NOMBRE varchar(100) not null,
                         LIGA varchar(100) not null,
                         PAIS varchar(100) not null,
                         PRIMARY KEY (ID)
);

CREATE INDEX equipos_nombre ON EQUIPOS (NOMBRE);

INSERT INTO EQUIPOS
(NOMBRE, LIGA, PAIS)
VALUES
    ('Real Madrid', 'La Liga', 'España'),
    ('FC Barcelona', 'La Liga', 'España'),
    ('Manchester United', 'Premier League', 'Inglaterra'),
    ('Liverpool FC', 'Premier League', 'Inglaterra'),
    ('Juventus FC', 'Serie A', 'Italia'),
    ('AC Milan', 'Serie A', 'Italia'),
    ('Bayern Munich', 'Bundesliga', 'Alemania'),
    ('Borussia Dortmund', 'Bundesliga', 'Alemania'),
    ('Paris Saint-Germain', 'Ligue 1', 'Francia'),
    ('Atlético Madrid', 'La Liga', 'España');