package com.projectdev.openstore.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    
    private static final String URL = "jdbc:mysql://localhost:3306/storedb";
    private static final String USER = "root";
    private static final String PASS = "admin";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
    	
    	Connection conexao = null;
    	
    	Class.forName(DRIVER_CLASS);
    	
    	conexao = DriverManager.getConnection(URL, USER, PASS);
        conexao.setAutoCommit(false);
    	
    	
    	return conexao;
    	
    }

}
