package net.putfirstthingsfirst.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/putfirstthingsfirst?userSSL=false";
		String user = "putfirstthingsfirst";
		String password = "putfirstthingsfirst";

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
