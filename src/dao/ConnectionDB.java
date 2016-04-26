package dao;

/**
 * @author André Marques Guedes
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	/**
	 * O nome do host
	 */
	private String host;
	
	/**
	 * O schema do banco de dados
	 */
	private String database;
	
	/**
	 * O nome do usuário
	 */
	private String username;
	
	/**
	 * A senha do usuário
	 */
	private String password;
	
	/**
	 * A classe de conexão
	 */
	private Connection connection;
	
	
	/**
	 * Constroi uma conexão a partir das informações necessárias: host, database, username, password
	 * 
	 * @param host
	 * @param database
	 * @param username
	 * @param password
	 */
	public ConnectionDB(String host, String database, String username, String password) {
		this.host = host;
		this.database = database;
		this.username = username;
		this.password = password;

		try {        	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao registrar driver.");
		}

		try {
			this.connection =  DriverManager.getConnection("jdbc:mysql://" + this.host + 
				"/" + this.database , this.username, this.password);
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao obter conexao:" + ex.getMessage());
		}
	}

        public ConnectionDB() {
          this("localhost","leiosempre","root","");
        }
        
	/**
	 * @return A conexão gerada
	 */
	public Connection getConnection() {
            if(this.connection == null){
               this.connection = new ConnectionDB().getConnection();
            }

            return this.connection;


	}

	/**
	 * Fecha a conexão
	 */
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao fechar conexão.");
		}
	}
}
