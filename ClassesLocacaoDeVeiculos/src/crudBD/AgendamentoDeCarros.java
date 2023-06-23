package crudBD;

import java.util.List;

import entidades.Automovel;

interface AgendamentoDeCarros {
	
	//salvar carro
	void save(Automovel carro);

	//listar carros
	
	List<Automovel> getCarros();
	
	//editar
	
	void update(Automovel carro);
	
	//deletar carro pela placa
	
	void delete(String placa);
}
