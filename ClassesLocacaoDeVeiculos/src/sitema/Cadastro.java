package sitema;

import java.util.ArrayList;
import java.util.Scanner;

import agregado.Endereco;
import agregado.Status;
import entidades.Aluguel;
import entidades.Automovel;
import entidades.Cliente;

public class Cadastro {
	
	private ArrayList<Automovel> listaCarro = new ArrayList<>();
	private ArrayList<Cliente> listaCliente = new ArrayList<>();
	
	public void novoCarro() {
		Scanner sc = new Scanner(System.in);
		System.out.println("placa: ");
		String placa = sc.next();
		System.out.println("marca: ");
		String marca = sc.next();
		System.out.println("modelo: ");
		String modelo = sc.next();
		System.out.println("status: ");
		boolean status = sc.nextBoolean();
		Status situacao = new Status(status);
		System.out.println("preço: ");
		double preco = sc.nextDouble();
		Automovel carro = new Automovel(placa, marca, modelo, situacao.getStatus(), preco);
		listaCarro.add(carro);
	}
	
	public void deletarCarro() {
		if (listaCarro.isEmpty()) {
		    System.out.println("A lista está vazia.");
		}
		else {
			Scanner sc = new Scanner(System.in);
			System.out.println("placa: ");
			String placa = sc.next();
			for (Automovel c : listaCarro) {
				if (c.getPlaca().equals(placa)) {
					listaCarro.remove(c);
					break;
				}
			}
		}
	}
	
	public boolean placa_existe(String placa) {
		for (Automovel c: listaCarro) {
			if (placa.equals(c.getPlaca())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean disponiblilidade(String placa) {
		for (Automovel c: listaCarro) {
			if (placa.equals(c.getPlaca())) {
				if (c.getStatus().equals("Alugado")) {
					return false;
				}
				break;
			}
		}
		return true;
	}
	
	
	public void mostrarListaCarro() {
		if (listaCarro.isEmpty()) {
		    System.out.println("A lista está vazia.");
		}
		for (Automovel c : listaCarro) {
			System.out.println(c);	
		}
	}
	
	public void novoCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nome: ");
		String nome = sc.next();
		System.out.println("endereço: ");
		Endereco endereco = new Endereco();
		String end = endereco.ruaNcasaBairro();
		System.out.println("telefone: ");
		String telefone = sc.next();
		Cliente cliente = new Cliente(listaCliente.size() + 1, nome, end, telefone);
		listaCliente.add(cliente);

	}
	
	public void deletarCliente() {
		if (listaCliente.isEmpty()) {
		    System.out.println("A lista está vazia.");
		}
		else {
			Scanner sc = new Scanner(System.in);
			System.out.println("id_cliente: ");
			int id_cliente = sc.nextInt();
			for (Cliente c : listaCliente) {
				if (c.getId_cliente() == id_cliente) {
					listaCliente.remove(c);
					break;
				}
			}
		}
	}
	
	public String retorna_nome_pelo_id(int id) {
		return listaCliente.get(id).getNome();
	}
	
	public double retorna_preco_pela_placa_automovel(String placa) {
		for (Automovel c: listaCarro) {
			if (c.getPlaca().equals(placa)) {
				return c.getPreco();
			}
		}
		return 0.0;
	}
	
	
	public void mostrarListaCliente() {
		if (listaCliente.isEmpty()) {
		    System.out.println("A lista está vazia.");
		}
		for (Cliente c : listaCliente) {
			System.out.println(c);	
		}
	}
	

	public ArrayList<Automovel> getListaCarro() {
		return listaCarro;
	}

	public void setListaCarro(ArrayList<Automovel> listaCarro) {
		this.listaCarro = listaCarro;
	}

	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	
	
	
	
	
	
	
	
	
}
