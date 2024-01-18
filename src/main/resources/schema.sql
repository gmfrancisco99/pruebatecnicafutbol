CREATE TABLE EQUIPO (
    ID int not null AUTO_INCREMENT,
    NOMBRE varchar(100) not null,
    LIGA varchar(100) not null,
    PAIS varchar(100) not null,
    PRIMARY KEY (ID)
);

CREATE INDEX equipos_nombre ON EQUIPO (NOMBRE);