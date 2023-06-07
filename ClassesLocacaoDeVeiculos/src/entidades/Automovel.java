package entidades;

import agregado.Status;

public class Automovel {
	
	private String placa;
	private String marca;
	private String modelo; 
	private String status;
	private double preco;
	
	public Automovel() {
	}
	
	public Automovel(String placa, String marca, String modelo, String status, Double preco) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.status = status;
		this.preco = preco;
	}
	
	public String situacao(boolean status) {
		Status s1 = new Status(status);
		return s1.getStatus();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Automovel [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", status=" + status
				+ ", preco=" + preco + "]";
	}

	

	

}
