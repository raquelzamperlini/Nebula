package br.com.nebula.dao;

import java.sql.*;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "nebulaADM", "fatec2016");
        } catch (SQLException | ClassNotFoundException e) {
		//} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public static void closeConnection(Connection connection) {
		
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
