CREATE TABLE alugueis (
  id int not null auto_increment primary key,
  id_cliente int,
  placa_carro varchar(40),
  nome VARCHAR(40),
  data_aluguel varchar(40),
  data_retorno varchar(40),
  taxa double
);