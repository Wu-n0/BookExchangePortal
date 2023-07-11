package com.my.helper;
import java.sql.*;

public class ConnectionProvider {
	private static Connection con;
	public static Connection getConnection()
	{
		try
		{
			if(con==null)
			{
				//new com.mysql.jdbc.Driver();
				//Class.forName("com.mysql.jdbc.Driver");
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_exchange","root","root");
			}
			
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
