package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class ConnectionFactory {
	
	//nome do usuario myslq
	private static final String USERNAME = "root";
	
	//Seha do banco
	private static final String PASSWORD = "EmDezembroDe81(12/81)3x0";
	
	//caminho para o banco de dados 
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/listas";
	
	
	public static Connection createConnectionToMySQL() throws Exception { 
		//faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;	
	}
	
	public static void main(String[] args) throws Exception{
		// recuperar uma conexão com o bd
		Connection con = createConnectionToMySQL();
		
		//testa se a conexão é nula
		
		if (con != null) {
			System.out.println("conexão obtida com sucesso!!!!");
			con.close();
		}
	}
	
	
	
}
