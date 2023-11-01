package br.com.petsec.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String username="RB-117";
	
	private static final String password="123RB117";
	
	private static final String DATABASE_URL="jdbc:mysql://localhost:3306/petsec";
	
	public static Connection createConnectionToSQL() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,username, password);	
		
		return connection;
		
			}	
	
}
