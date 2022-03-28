package com.zensar.training.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionFactory {
	public static Connection createConnection()throws Exception{
		Connection connection=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/trainingDB";
		String userName="root";
		String password="Rajib@123";
		connection=DriverManager.getConnection(url,userName,password);
		return connection;
	}

}
