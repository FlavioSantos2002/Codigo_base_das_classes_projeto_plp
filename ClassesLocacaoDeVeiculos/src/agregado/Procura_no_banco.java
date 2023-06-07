package agregado;

import crudBD.AgendamentoDeCarros;
import crudBD.AgendamentoDeClientes;
import crudBD.AlugarCarro;
import entidades.Aluguel;
import entidades.Automovel;
import entidades.Cliente;

public class Procura_no_banco {
	
	public boolean procura_pelo_id_cliente(int id) {
		AgendamentoDeClientes bancoClientes = new AgendamentoDeClientes();
		
		for (Cliente c: bancoClientes.getClientes() ) {
			if(id == c.getId_cliente()) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean procura_pela_placa_carro(String placa) {
		AgendamentoDeCarros bancoCarros = new AgendamentoDeCarros();

		for (Automovel c: bancoCarros.getCarros() ) {
			if(placa.equals(c.getPlaca())) {
				return true;
			}
		}
		return false;
		
	}
	
	public String retorna_nome_pelo_Id(int id) {
		AgendamentoDeClientes bancoClientes = new AgendamentoDeClientes();

		for (Cliente c: bancoClientes.getClientes()) {
			if(c.getId_cliente() == id) {
				return c.getNome();
			}
		}
		return "";
		
	}
	
	public boolean procura_pelo_id_aluguel(int id) {
		AlugarCarro bancoAlugueis = new AlugarCarro();
		
		for (Aluguel c: bancoAlugueis.getAlugueis() ) {
			if(id == c.getId_aluguel()) {
				return true;
			}
		}
		return false;
		
	}
	
	public String placa_aluguel_pelo_id(int id) {
		AlugarCarro bancoAlugueis = new AlugarCarro();
		
		for (Aluguel c: bancoAlugueis.getAlugueis() ) {
			if(id == c.getId_aluguel()) {
				return c.getPlaca();
			}
		}
		return "";
	}
	
	public String nome_aluguel_pelo_id(int id) {
		AlugarCarro bancoAlugueis = new AlugarCarro();
		
		for (Aluguel c: bancoAlugueis.getAlugueis() ) {
			if(id == c.getId_aluguel()) {
				return c.getNome();
			}
		}
		return "";
	}
	
}
