package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConn {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pedidos", "root",
					"i510635");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
}
