package entidades;

public class Cliente {
	private int id_cliente;
	private String nome;
	private String endereco; 
	private String telefone;
	
	public Cliente() {
	}

	public Cliente(int id_cliente, String nome, String endereco, String telefone) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	//sera que deve ter set do cliente????
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", endereco=" + endereco + ", telefone="
				+ telefone + "]";
	}
	
	
	
	
}
