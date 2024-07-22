package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	private JdbcUtil() {
		
	}static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	}
	
	//promotes logical connection
	public static Connection getJdbcConnection() throws IOException, SQLException {
		HikariConfig config=new HikariConfig("src/com/properties/db.properties");
		
		HikariDataSource datasource=new HikariDataSource(config);
		Connection connection=datasource.getConnection();
		return connection;
	}
	
	
	//promotes physical connection
//	private static Connection physicalConnection()throws FileNotFoundException,IOException{
//		FileInputStream fis=new FileInputStream("src/com/properties/db.properties");
//		Properties properties=new Properties();
//		properties.load(fis);
//		String url = properties.getProperty("url");
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//		Connection connection=DriverManager.getConnection(url,user,password);
//				return connection;
//	}

}
