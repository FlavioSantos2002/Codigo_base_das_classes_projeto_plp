package crudBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Automovel;
import entidades.Cliente;
import factory.ConnectionFactory;

public class Agendamento implements AgendamentoDeCarros, AgendamentoDeClientes{
	//salvar carro
		public void save(Automovel carro) {
			String sql = "INSERT INTO carros(placa, marca, modelo, status_carro, preco) VALUES(?, ?, ?, ?, ?)";
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
			
			try {
				//cria conexão com o bd
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//cria uma PreparedStatement para executar uma query
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				
				pstm.setString(1, carro.getPlaca());
				pstm.setString(2, carro.getMarca());
				pstm.setString(3, carro.getModelo());
				pstm.setString(4, carro.getStatus());
				pstm.setDouble(5, carro.getPreco());
				
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

		//listar carros
		
		public List<Automovel> getCarros(){
			
			String sql = "SELECT * FROM listas.carros";
			
			List<Automovel> carros = new ArrayList<Automovel>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			//Classe que vai recuperar os dados do banco. ***SELECT****
			ResultSet rset = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					
					Automovel carro = new Automovel();
					
					//Recuperar placa
					carro.setPlaca(rset.getString("placa"));;
					//Recuperar marca
					carro.setMarca(rset.getString("marca"));
					//Recuperar modelo
					carro.setModelo(rset.getString("modelo"));
					//Recuperar status do carro
					carro.setStatus(rset.getString("status_carro"));
					//Recuperar preco
					carro.setPreco(rset.getDouble("preco"));
					
					
					carros.add(carro);
					
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
			
				return carros;
		}
		
		//editar
		
		public void update(Automovel carro) {
			
			String sql = "UPDATE carros SET marca = ?, modelo = ?, status_carro = ?, preco = ? " + 
			"WHERE placa = ?";
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
			
			try {
				//cria conexão
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//criar a classe para executar a query
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				//adicionar os valores para atualizar
				pstm.setString(1, carro.getMarca());
				pstm.setString(2, carro.getModelo());
				pstm.setString(3, carro.getStatus());
				pstm.setDouble(4, carro.getPreco());
				
				//qual id pra atualizar
				pstm.setString(5, carro.getPlaca());
				
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
		
		public void delete(String placa) {
			
			String sql = "DELETE FROM carros WHERE placa = ?";
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
			
			try {
				//cria conexão
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//criar a classe para executar a query
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setString(1, placa);
				
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
		
	//parte do cliente
		public void save(Cliente cliente) {
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
		
		public void delete(int id) {
			
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
