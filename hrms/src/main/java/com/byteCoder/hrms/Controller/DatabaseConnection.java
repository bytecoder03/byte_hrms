package com.byteCoder.hrms.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection 
{
	public static Statement DBconnectore() throws ClassNotFoundException, SQLException
	{
		System.out.println("inside DbConnection");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky","root","root");
		
		Statement st= con.createStatement();
		return st;
	}

}
