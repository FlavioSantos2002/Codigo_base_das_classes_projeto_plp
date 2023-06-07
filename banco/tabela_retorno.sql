CREATE TABLE retorno (
  id int not null auto_increment primary key,
  id_aluguel int,
  placa varchar(40),
  nome VARCHAR(40),
  data_retorno varchar(40),
  atraso long,
  multaConta double
);