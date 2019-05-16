package Hibernate.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionTest {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/pluto.coffee?userSSL=false";
		String user = "plutocoffee";
		String password = "plutocoffee";

		try {
			System.out.println("Connecting to database : " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			connection.close();
			
			System.out.println("Connection successful !!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
