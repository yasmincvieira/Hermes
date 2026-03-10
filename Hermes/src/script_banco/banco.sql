drop database if exists banco;
create database banco;

use banco;

create table Usuarios(
	 id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null
);

insert into Usuarios VALUES(null, 'Yasmin', 'yasmin@email.com', '123');

