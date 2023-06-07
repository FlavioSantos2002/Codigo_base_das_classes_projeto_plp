package crudBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import factory.ConnectionFactory;

public class AgendamentoDeClientes {
	
	public void saveCliente(Cliente cliente) {
		String sql = "INSERT INTO clientes(nome, endereco, telefone) VALUES(?, ?, ?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			//cria conexão com o bd
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//cria uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getTelefone());
			
			//Executa query
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//fecha conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	public List<Cliente> getClientes(){
			
			String sql = "SELECT * FROM listas.clientes";
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			//Classe que vai recuperar os dados do banco. ***SELECT****
			ResultSet rset = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					
					Cliente cliente = new Cliente();
					
					//Recuperar o id
					cliente.setId_cliente(rset.getInt("id"));;
					//Recuperar o nome
					cliente.setNome(rset.getString("nome"));
					//Recuperar a endereço
					cliente.setEndereco(rset.getString("endereco"));
					//Recuperar telefone
					cliente.setTelefone(rset.getString("telefone"));
					
					clientes.add(cliente);
					
				}
			}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rset!=null) {
							rset.close();
						}
						
						if(pstm!=null) {
							pstm.close();
						}
						
						if(conn!=null) {
							conn.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			
				return clientes;
		}
	
	
	public void update(Cliente cliente) {
		
		String sql = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ? " + 
		"WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			//cria conexão
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//adicionar os valores para atualizar
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getTelefone());
			
			//qual id pra atualizar
			pstm.setInt(4, cliente.getId_cliente());
			
			//executar
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void deleteByID(int id) {
		
		String sql = "DELETE FROM clientes WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			//cria conexão
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
