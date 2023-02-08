package com.jsp.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {
	String url = "jdbc:mysql://localhost:3306/school";
	String username = "root";
	String password = "root";
	Connection c = null;

	public Connection getConnection() {
		try {
			// register
			Class.forName("com.mysql.cj.jdbc.Driver");

			c = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
