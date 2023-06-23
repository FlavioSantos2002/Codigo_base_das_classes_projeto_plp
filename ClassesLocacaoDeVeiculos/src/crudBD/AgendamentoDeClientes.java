package crudBD;

import java.util.List;

import entidades.Cliente;

interface AgendamentoDeClientes {
	
	public void save(Cliente cliente);

	public List<Cliente> getClientes();
	
	
	public void update(Cliente cliente);
	
	public void delete(int id) ;

}
