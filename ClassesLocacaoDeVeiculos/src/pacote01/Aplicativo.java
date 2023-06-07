package pacote01;

import java.time.LocalDate;

import crudBD.AgendamentoDeCarros;
import crudBD.AgendamentoDeClientes;
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
		
		AgendamentoDeClientes agendar = new AgendamentoDeClientes();
		AgendamentoDeCarros cadastro_carro = new AgendamentoDeCarros();
		AlugarCarro alugar = new AlugarCarro();
		
		//agendar.saveCliente(cliente); 
		
		//agendar.update(cliente);
		
		//carro.setMarca("fiat");
		//carro.setModelo("uno");
		//carro.setStatus("Disponível");
		//carro.setPreco(1500.50);
		//carro.setPlaca("BRB00C1");
		
		
		//cadastro_carro.saveCarro(carro);
		
		//aluguel.setData_aluguel(LocalDate.parse("2023-06-09"));
		//aluguel.setData_retorno(LocalDate.parse("2023-06-20"));
		//aluguel.setTaxa(1000.50);
		//alugar.alugarCarro(aluguel, carro, cliente, 6, "BRB00C1");
		//retorno.setData_retorno(LocalDate.parse("2023-06-30"));
		//retorno.setAtraso(4);
		//retorno.setMultaConta(4000);
		//alugar.retorna_carro(retorno, 5);
		//cadastro_carro.deleteByPLACA("BRB12C4");
		for (Retorno c: alugar.getRetornos()) {
			System.out.println(c);
		}
		//for (Automovel a: cadastro_carro.getCarros()) {
		//	System.out.println(a);
		//}
	}	
}

