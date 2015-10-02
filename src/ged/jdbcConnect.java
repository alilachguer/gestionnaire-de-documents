package ged;


import java.sql.*;

public class jdbcConnect {
	public Connection  getConnection() throws ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("driver ok");
		Connection con = null;
		String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=GED; user=sa; password=1234;";
		System.out.println("connexion established");
		try {
			con = DriverManager.getConnection(conUrl);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			if (con != null) try { con.close(); } catch(Exception e) {}
		}
		return con;
	}
}