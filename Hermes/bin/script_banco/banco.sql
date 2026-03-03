drop database if exists banco;
create database banco;

use banco;

create table Usuarios(
	ID INT primary key,
    NOME VARCHAR(255) not null,
    EMAIL varchar(255) not null,
    senha varchar(255) not null
);

insert into Usuarios VALUES(1, 'Yasmin', 'yasmin@email.com', '123');