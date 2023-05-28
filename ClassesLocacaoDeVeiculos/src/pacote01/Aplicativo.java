package pacote01;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

import sitema.Alugar;
import sitema.Cadastro;
import sitema.RetornaCarro;

public class Aplicativo {

	public static void main(String[] args) {
		
		Cadastro cadastro = new Cadastro();
		Alugar aluguel = new Alugar();
		RetornaCarro retorno = new RetornaCarro(); 
		
		int x, y, z, w;
		boolean a = true;
		
		while (a) {
			Scanner sc = new Scanner(System.in);
			System.out.println("0 --- Sair");
			System.out.println("1 --- cadastro");
			System.out.println("2 --- Alugar ");
			System.out.println("3 --- Retorno");
			System.out.println("digite uma das opções: ");
			
			x = sc.nextInt();
			switch(x) {
			case 1:
				System.out.println("CADASTRO");
				System.out.println("0 --- menu");
				System.out.println("1 --- novo cliente");
				System.out.println("2 --- novo carro");
				System.out.println("3 --- apagar carro");
				System.out.println("4 --- apagar cliente");
				System.out.println("5 --- lista de carros");
				System.out.println("6 --- lista de clientes");
				System.out.println("digite uma das opções: ");
				y = sc.nextInt();
				switch(y) {
				case 1:
					System.out.println("1 --- novo cliente");
					cadastro.novoCliente();
					break;
				case 2:
					System.out.println("2 --- novo carro");
					cadastro.novoCarro();
					break;
				case 3:
					System.out.println("3 --- apagar carro");
					cadastro.deletarCarro();
					break;
				case 4:
					System.out.println("4 --- apagar cliente");
					cadastro.deletarCliente();
					break;
				case 5:
					System.out.println("5 --- lista de carros");
					cadastro.mostrarListaCarro();
					break;
				case 6:
					System.out.println("6 --- lista de clientes");
					cadastro.mostrarListaCliente();
					break;
				default:
					System.out.println("0 --- menu");
					break;
				}
				break;
			case 2:
				System.out.println("1 --- novo aluguel");
				System.out.println("2 --- mostrar lista de alugueis");
				System.out.println("digite uma das opções: ");
				
				
				w = sc.nextInt();
				switch(w) {
				case 1:
					System.out.println("novo Aluguel");
					aluguel.novoAluguel(cadastro);
					break;
				case 2:
					System.out.println("lista de alugueis");
					aluguel.mostrarListaAluguel();
					break;
				}
				break;
			case 3:
				System.out.println("1 --- novo retorno");
				System.out.println("2 --- mostrar lista de retornos");
				System.out.println("digite uma das opções: ");
				
				
				z = sc.nextInt();
				switch(z) {
				case 1:
					System.out.println("novo retorno");
					retorno.novoRetorno(aluguel, cadastro);
					break;
				case 2:
					System.out.println("lista de alugueis");
					retorno.mostrarListaRetorno();
					break;
				}
				break;
			default:
				a = false;
				System.out.println("SAINDO...");
			}	
		}
		
	}	
}

