package sitema;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import agregado.Status;
import entidades.Aluguel;
import entidades.Automovel;
import entidades.Retorno;

public class RetornaCarro {
	private ArrayList<Retorno> listaRetorno = new ArrayList<>();
	
	public void novoRetorno(Alugar alugar, Cadastro cadastro) {
		Scanner sc = new Scanner(System.in);
		System.out.println("digite id_aluguel: ");
		int id_aluguel = sc.nextInt();
		String placa = alugar.retorna_placa_pelo_id_aluguel(id_aluguel);
		
		String nome = alugar.retorna_nome_pelo_id_aluguel(id_aluguel);
		System.out.println("digite data_retorno: ");
		LocalDate data_retorno = LocalDate.parse(sc.next());
		LocalDate data_aluguel = alugar.retorna_dA_pelo_id_aluguel(id_aluguel);
		
		long atraso = ChronoUnit.DAYS.between(data_aluguel, data_retorno);
		double taxa = alugar.retorna_taxa_pelo_id_aluguel(id_aluguel);
		double preco = cadastro.retorna_preco_pela_placa_automovel(placa);
		double multaConta = taxa + atraso*(taxa/2.0) + preco;
		
		for (Automovel c: cadastro.getListaCarro()) {
			if (placa.equals(c.getPlaca())) {
				c.setStatus("Disponível");
			}
		}
		
		alugar.deletar_pelo_id(id_aluguel);
		
		Retorno retorno = new Retorno(listaRetorno.size()+1, id_aluguel, placa, nome, data_retorno, atraso, multaConta);
		listaRetorno.add(retorno);
	}
	
	public void mostrarListaRetorno() {
		if (listaRetorno.isEmpty()) {
		    System.out.println("A lista está vazia.");
		}
		for (Retorno c : listaRetorno) {
			System.out.println(c.toString());	
		}
	}

	public ArrayList<Retorno> getListaRetorno() {
		return listaRetorno;
	}

	public void setListaRetorno(ArrayList<Retorno> listaRetorno) {
		this.listaRetorno = listaRetorno;
	}
	
}
