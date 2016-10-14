package br.ifmg.trabalhopratico01.negocio;

import java.sql.*;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException {
    	
    	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    	
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maoamiga", "root","root");
 
    	return conn;
    }
}