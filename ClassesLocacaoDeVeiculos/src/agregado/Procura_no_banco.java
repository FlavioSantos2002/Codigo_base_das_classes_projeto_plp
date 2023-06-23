package agregado;

import crudBD.Agendamento;
import crudBD.AlugarCarro;
import entidades.Aluguel;
import entidades.Automovel;
import entidades.Cliente;

public class Procura_no_banco {
	Agendamento banco = new Agendamento();
	
	public boolean procura_pelo_id_cliente(int id) {
		
		for (Cliente c: banco.getClientes() ) {
			if(id == c.getId_cliente()) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean procura_pela_placa_carro(String placa) {

		for (Automovel c: banco.getCarros() ) {
			if(placa.equals(c.getPlaca())) {
				return true;
			}
		}
		return false;
		
	}
	
	public String retorna_nome_pelo_Id(int id) {
	
		for (Cliente c: banco.getClientes()) {
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
