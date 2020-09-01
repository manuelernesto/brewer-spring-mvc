use brewer;

create table estilo
(
    codigo bigint(20) primary key auto_increment,
    nome   varchar(50) not null
) engine = InnoDB
  default charset = utf8;

insert into estilo(nome)
values ('Amber Lager'),
       ('Dark Lager'),
       ('Pale Lager'),
       ('Pilsner');

create table cerveja
(
    codigo         bigint(20) primary key auto_increment,
    sku            varchar(50)    not null,
    nome           varchar(80)    not null,
    descricao      text           not null,
    teor_alcoolico decimal(10, 2) not null,
    comissao       decimal(10, 2) not null,
    sabor          varchar(50)    not null,
    origem         varchar(50)    not null,
    codigo_estilo  bigint(20)     not null,
    foreign key (codigo_estilo) references estilo (codigo)

) engine = InnoDB
  default charset = utf8;