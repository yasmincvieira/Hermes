drop database if exists banco;
create database banco;

use banco;

create table Usuarios(
	 id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null
);
SELECT * FROM banco.Usuarios;

insert into Usuarios VALUES(null, 'Yasmin', 'yasmin@email.com', '123');

create table novoChamado(
	idChamado INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(255) not null,
    lugar varchar(255) not null,
    idPatrimonio int(255),
    descricao text not null
);
select * from banco.novochamado;

create table chamado(
	idChamado INT AUTO_INCREMENT PRIMARY KEY,
    status enum ('Inativo', 'Em análise', 'Resolvido', 'Inválido') not null,
    descricao text not null
);
    
insert into chamado VALUES(null, 'Inativo', 'A mesa está com um dos pé quebrado');


create table patrimonio(
	idPatrimonio INT AUTO_INCREMENT PRIMARY KEY,
    status enum ('Inativo', 'Ativo', 'Em manutenção') not null,
    nome varchar(255) not null
    );
    
insert into patrimonio VALUES(null, 'Em manutenção', 'Cadeira');

create table espacos(
nome_local varchar(255) PRIMARY KEY,
bloco char(20) not null,
andar char(20) not null
);

insert into espacos VALUES ('Corredor', 'bloco 1', 'Térreo'); 
    