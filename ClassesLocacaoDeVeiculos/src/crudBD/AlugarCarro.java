package crudBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agregado.Procura_no_banco;
import entidades.Aluguel;
import entidades.Automovel;
import entidades.Cliente;
import entidades.Retorno;
import factory.ConnectionFactory;
import java.time.LocalDate;

public class AlugarCarro {
	//Alugar carro
	public void alugarCarro(Aluguel aluguel, Automovel carro, Cliente cliente, int id_cliente, String placa) {
		Procura_no_banco procurar = new Procura_no_banco();
		if (procurar.procura_pelo_id_cliente(id_cliente) && procurar.procura_pela_placa_carro(placa)) {
			String sql = "INSERT INTO alugueis(id_cliente, placa_carro, nome, data_aluguel, data_retorno, taxa) VALUES(?, ?, ?, ?, ?, ?)";
			String sql2 = "UPDATE carros SET status_carro = ?"+
			"WHERE placa = ?";
			Connection conn = null;
			
			PreparedStatement pstm = null;
			PreparedStatement pstm2  = null;
			
			
			try {
				//cria conexão com o bd
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//cria uma PreparedStatement para executar uma query
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm2 = (PreparedStatement) conn.prepareStatement(sql2);
				
				pstm2.setString(1, "Alugado");
				pstm2.setString(2, placa);
				
				pstm.setInt(1, id_cliente);
				pstm.setString(2, placa);
				pstm.setString(3, procurar.retorna_nome_pelo_Id(id_cliente));
				pstm.setString(4, aluguel.getData_aluguel().toString());
				pstm.setString(5, aluguel.getData_retorno().toString());
				pstm.setDouble(6, aluguel.getTaxa());
				
				//Executa query
				pstm.execute();
				pstm2.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//fecha conexoes
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (pstm2 != null) {
						pstm2.close();
					}
					if (conn != null) {
						conn.close();
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("nao encontrado correspondente");
		}	
	}
	
	
	public List<Aluguel> getAlugueis(){
		
		String sql = "SELECT * FROM listas.alugueis";
		
		List<Aluguel> listaAlugueis = new ArrayList<Aluguel>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Aluguel aluguel = new Aluguel();
				
				//Recuperar id aluguel
				aluguel.setId_aluguel(rset.getInt("id"));
				//Recuperar id cliente
				aluguel.setId_cliente(rset.getInt("id_cliente"));
				//Recuperar placa
				aluguel.setPlaca(rset.getString("placa_carro"));
				//Recuperar nome
				aluguel.setNome(rset.getString("nome"));
				//Recuperar da
				aluguel.setData_aluguel(LocalDate.parse(rset.getString("data_aluguel")));
				//Recuperar dr
				aluguel.setData_retorno(LocalDate.parse(rset.getString("data_retorno")));
				//Recuperar taxa
				aluguel.setTaxa(rset.getDouble("taxa"));
				
				
				listaAlugueis.add(aluguel);
				
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
		
		return listaAlugueis;
	}
	
	public void retorna_carro(Retorno retorno, int id_aluguel) {
		Procura_no_banco procurar = new Procura_no_banco();
		if (procurar.procura_pelo_id_aluguel(id_aluguel)) {
			String sql = "INSERT INTO retorno(id_aluguel, placa, nome, data_retorno, atraso, multaConta) VALUES(?, ?, ?, ?, ?, ?)";
			String sql2 = "UPDATE carros SET status_carro = ?"+
			"WHERE placa = ?";
			String sql3 = "DELETE FROM alugueis WHERE id = ?";
			Connection conn = null;
			
			PreparedStatement pstm = null;
			PreparedStatement pstm2  = null;
			PreparedStatement pstm3  = null;
			
			
			try {
				//cria conexão com o bd
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//cria uma PreparedStatement para executar uma query
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm2 = (PreparedStatement) conn.prepareStatement(sql2);
				pstm3 = (PreparedStatement) conn.prepareStatement(sql3);
				
				pstm3.setInt(1, id_aluguel);
				
				
				pstm2.setString(1, "Disponível");
				pstm2.setString(2, procurar.placa_aluguel_pelo_id(id_aluguel));
				
				pstm.setInt(1, id_aluguel);
				pstm.setString(2, procurar.placa_aluguel_pelo_id(id_aluguel));
				pstm.setString(3, procurar.nome_aluguel_pelo_id(id_aluguel));
				pstm.setString(4, retorno.getData_retorno().toString());
				pstm.setLong(5, retorno.getAtraso());//fazer o calculo
				pstm.setDouble(6, retorno.getMultaConta());//fazer o calculo
				
				//Executa query
				pstm.execute();
				pstm2.execute();
				pstm3.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//fecha conexoes
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (pstm2 != null) {
						pstm2.close();
					}
					if (conn != null) {
						conn.close();
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("nao encontrado correspondente");
		}	
	}
	
	public List<Retorno> getRetornos(){
		
		String sql = "SELECT * FROM listas.retorno";
		
		List<Retorno> listaRetorno = new ArrayList<Retorno>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Retorno retorno = new Retorno();
				
				//Recuperar id retorno
				retorno.setId_retorno(rset.getInt("id"));
				//Recuperar id aluguel
				retorno.setId_aluguel(rset.getInt("id_aluguel"));
				//Recuperar placa
				retorno.setPlaca(rset.getString("placa"));
				//Recuperar nome
				retorno.setNome(rset.getString("nome"));
				//Recuperar dr
				retorno.setData_retorno(LocalDate.parse(rset.getString("data_retorno")));
				//Recuperar atraso
				retorno.setAtraso(rset.getLong("atraso"));
				//Recuperar multaConta
				retorno.setMultaConta(rset.getDouble("multaConta"));
				
				
				listaRetorno.add(retorno);
				
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
		
		return listaRetorno;
	}
}
