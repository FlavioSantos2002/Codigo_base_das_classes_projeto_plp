package pacote01;

import java.time.LocalDate;

import crudBD.Agendamento;
import crudBD.AlugarCarro;
import entidades.Aluguel;
import entidades.Automovel;
import entidades.Cliente;
import entidades.Retorno;

public class Aplicativo {

	public static void main(String[] args) {
		
		Aluguel aluguel = new Aluguel();
		Cliente cliente = new Cliente();
		Automovel carro = new Automovel();
		Retorno retorno = new Retorno();
		
		//cliente.setNome("juan");
		//cliente.setEndereco("rua 4; bairro: taruma; casa: 125");
		//cliente.setTelefone("91179671");
		
		AlugarCarro alugar = new AlugarCarro();
		Agendamento agenda = new Agendamento();
		//agendar.saveCliente(cliente); 
		
		//agendar.update(cliente);
		
		//carro.setMarca("Ferrari");
		//carro.setModelo("355 GTS F1");
		//carro.setStatus("Disponível");
		//carro.setPreco(3000.50);
		//carro.setPlaca("NER-6004");
		
		//agenda.save(carro);
		
		
		
		//aluguel.setData_aluguel(LocalDate.parse("2023-06-23"));
		//aluguel.setData_retorno(LocalDate.parse("2023-06-30"));
		//aluguel.setTaxa(400.50);
		//alugar.alugarCarro(aluguel, carro, cliente, 5, "NER-6004");
		retorno.setData_retorno(LocalDate.parse("2023-06-30"));
		retorno.setAtraso(9);
		retorno.setMultaConta(5000);
		alugar.retorna_carro(retorno, 6);
		//cadastro_carro.deleteByPLACA("BRB12C4");
		
		//for (Automovel a: cadastro_carro.getCarros()) {
		//	System.out.println(a);
		//}
	}	
}

