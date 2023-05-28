package sitema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import entidades.Aluguel;
import entidades.Automovel;

public class Alugar {
	
	private ArrayList<Aluguel> listaAluguel = new ArrayList<>();
	
	public void novoAluguel(Cadastro cadastro) {
		Scanner sc = new Scanner(System.in);
		System.out.println("id cliente: ");
		int idC = sc.nextInt();
		System.out.println("placa: ");
		String placa = sc.next();
		System.out.println("nome: colocado apartir do id");
		String nome = cadastro.retorna_nome_pelo_id(idC-1);
		
		System.out.println("Data aluguel: ");
		LocalDate dA = LocalDate.parse(sc.next());
		System.out.println("Data Retorno: ");
		LocalDate dR = LocalDate.parse(sc.next());
		System.out.println("taxa aluguel: ");
		double taxa = sc.nextDouble();
		
		if (cadastro.placa_existe(placa) && cadastro.disponiblilidade(placa)) {
			for (Automovel c: cadastro.getListaCarro()) {
				if (placa.equals(c.getPlaca())) {
					c.setStatus("Alugado");
				}
			}
			System.out.println("aluguel realizado");
			Aluguel aluguel = new Aluguel(listaAluguel.size() + 1, idC, placa, nome, dA, dR, taxa);
			listaAluguel.add(aluguel);
		}
		else {
			System.out.println("cadastro indisponivel para esse veiculo");
		}
			
	}
	
	public void mostrarListaAluguel() {
		if (listaAluguel.isEmpty()) {
		    System.out.println("A lista está vazia.");
		}
		for (Aluguel c : listaAluguel) {
			System.out.println(c.toString());	
		}
	}
	
	public String retorna_placa_pelo_id_aluguel(int id) {
		for (Aluguel c: listaAluguel) {
			if (c.getId_aluguel() == id) {
				return c.getPlaca();
			}
		}
		return "placa errada";
		
	}
	
	public String retorna_nome_pelo_id_aluguel(int id) {
		for (Aluguel c: listaAluguel) {
			if (c.getId_aluguel() == id) {
				return c.getNome();
			}
		}
		return "nome errada";
	}
	
	public LocalDate retorna_dA_pelo_id_aluguel(int id) {
		for (Aluguel c: listaAluguel) {
			if (c.getId_aluguel() == id) {
				return c.getData_aluguel();
			}
		}
		return LocalDate.now();
	}
	
	public double retorna_taxa_pelo_id_aluguel(int id) {
		for (Aluguel c: listaAluguel) {
			if (c.getId_aluguel() == id) {
				return c.getTaxa();
			}
		}
		return 0.0;
	}
	
	public void deletar_pelo_id(int id) {
		for (Aluguel c: listaAluguel) {
			if (c.getId_aluguel() == id) {
				listaAluguel.remove(c);
				break;
			}
		}
	}
	
	public ArrayList<Aluguel> getListaAluguel() {
		return listaAluguel;
	}

	public void setListaAluguel(ArrayList<Aluguel> listaAluguel) {
		this.listaAluguel = listaAluguel;
	}
	
}
