package com.vtiger.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * this class is created for to connect db and execute queries and closing the 
 * connection with db
 * 
 * @author Mayur
 */
public class DataBaseUtility {

	Connection conn;
	
	/** Parameterized Method to Connect with Database */
	public void getDBConnection(String url, String username, String password) throws SQLException {
		try {
			Driver dRef = new Driver();
			DriverManager.registerDriver(dRef);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}

	}
	
	/** Non Parameterized Method to Connect with Database */
	public void getDBConnection() {
		try {
			Driver dRef = new Driver();
			DriverManager.registerDriver(dRef);
			conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/ninza_hrm", "root@%", "root");
		} catch (Exception e) {
		}
	}
	
	/** Method to Close the Connect with Database */
	public void closeDBConnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
	
	/** Method to Execute Select Query  */
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {
		}
		return result;
	}
	
	/** Method to Execute Non Select Query */
	public int executeNonSelectQuery(String query) throws SQLException {
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
		}
		return result;
	}

}
