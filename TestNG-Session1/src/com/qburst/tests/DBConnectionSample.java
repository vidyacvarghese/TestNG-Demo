package com.qburst.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionSample {
	private Connection connection = null;
	private ResultSet rs = null;
	private String query;
	private Statement stmt = null;
	private PreparedStatement psStmt = null;

	public void setUp() throws ClassNotFoundException, SQLException {
		String portName = "3306";
		String url = "jdbc:mysql://localhost:" + portName + "/";
		String dbName = "student";
		String userName = "root";
		String password = "qburst";

		// Loads the driver
		Class.forName("com.mysql.jdbc.Driver");

		// Establishes connection
		connection = DriverManager.getConnection(url + dbName, userName,
				password);
	}

	public void createStatement() throws SQLException {
		String query = "Select * FROM student_details where Name='Anu'";

		// Initialise statement class
		stmt = connection.createStatement();

		// execute sql query
		rs = stmt.executeQuery(query);
	}

	public void createPrepareStatement() throws SQLException {
		query = "Select * FROM student_details where Name=?";
		psStmt = connection.prepareStatement(query);
		psStmt.setString(1, "Anu");
		rs = psStmt.executeQuery();
	}

	public void displayResults() throws ClassNotFoundException, SQLException {

		while (rs.next()) {
			String rollNo = rs.getString(1);
			System.out.println("Roll No " + rollNo);
			String name = rs.getString("name");
			System.out.println("Name " + name);
		}
	}

	public void closeConnections() throws SQLException {
		rs.close();
		connection.close();
		stmt.close();
		// psStmt.close();
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		DBConnectionSample db = new DBConnectionSample();

		// setup for db connection
		db.setUp();

		// querying using prepare statement
		 db.createPrepareStatement();

		// querying using create statement
		//db.createStatement();

		// for displaying results
		db.displayResults();

		// close db connections
		db.closeConnections();
	}
}