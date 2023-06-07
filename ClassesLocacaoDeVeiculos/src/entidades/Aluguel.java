package entidades;

import java.time.LocalDate;

public class Aluguel {
	private int id_aluguel;
	private int id_cliente;
	private String placa;
	private String nome;
	private LocalDate data_aluguel;
	private LocalDate data_retorno;
	private double taxa;
	
	public Aluguel(){
	}
	

	public Aluguel(int id_aluguel, int id_cliente, String placa, String nome, LocalDate data_aluguel,
			LocalDate data_retorno, double taxa) {
		this.id_aluguel = id_aluguel;
		this.id_cliente = id_cliente;
		this.placa = placa;
		this.nome = nome;
		this.data_aluguel = data_aluguel;
		this.data_retorno = data_retorno;
		this.taxa = taxa;
	}





	public int getId_aluguel() {
		return id_aluguel;
	}

	public void setId_aluguel(int id_aluguel) {
		this.id_aluguel = id_aluguel;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_aluguel() {
		return data_aluguel;
	}

	public void setData_aluguel(LocalDate data_aluguel) {
		this.data_aluguel = data_aluguel;
	}

	public LocalDate getData_retorno() {
		return data_retorno;
	}

	public void setData_retorno(LocalDate data_retorno) {
		this.data_retorno = data_retorno;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	@Override
	public String toString() {
		return "Aluguel [id_aluguel=" + id_aluguel + ", id_cliente=" + id_cliente + ", placa=" + placa + ", nome="
				+ nome + ", data_aluguel=" + data_aluguel + ", data_retorno=" + data_retorno + ", taxa=" + taxa + "]";
	}
}
