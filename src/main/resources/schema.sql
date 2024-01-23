CREATE TABLE EQUIPOS (
    ID int not null AUTO_INCREMENT,
    NOMBRE varchar(100) not null,
    LIGA varchar(100) not null,
    PAIS varchar(100) not null,
    PRIMARY KEY (ID)
);

CREATE INDEX equipos_nombre ON EQUIPOS (NOMBRE);

CREATE TABLE IF NOT EXISTS USERS (
    ID int not null PRIMARY KEY AUTO_INCREMENT,
    USERNAME varchar (30) not null,
    PASSWORD varchar (30) not null
);

CREATE INDEX IF NOT EXISTS users_username ON USERS (USERNAME);