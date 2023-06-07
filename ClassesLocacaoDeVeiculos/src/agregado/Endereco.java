package agregado;

import java.util.Scanner;

public class Endereco {
	
	private String rua;
	private int numeroCasa;
	private String bairro;
	
	public Endereco() {
	}

	public Endereco(String rua, int numeroCasa, String bairro) {
		this.rua = rua;
		this.numeroCasa = numeroCasa;
		this.bairro = bairro;
	}
	
	public String ruaNcasaBairro() {
		Scanner sc = new Scanner(System.in);
		System.out.println("rua: ");
		String rua = sc.next();
		System.out.println("numero da Casa: ");
		int casa = sc.nextInt();
		System.out.println("Bairro: ");
		String bairro = sc.next();
		return " rua: " + rua + " N° casa: " + casa +  " Bairro: " + bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
	
}
