package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Meteo 
{
	public static void writeToDb(double temp, double cisn, double wilg) 
	{
	    Connection conn = null;
	    String url = "jdbc:mysql://localhost:3306/";
	    String dbName = "java";
	    String driver = "com.mysql.jdbc.Driver";
	    String userName = "root"; 
	    String password = "";
	    try 
	    {
	      Class.forName(driver).newInstance();
	      conn = DriverManager.getConnection(url+dbName,userName,password);
	      Statement st = conn.createStatement();
	      String qrystring = "INSERT INTO meteo(temp, cisn, wilg) VALUES(\"+ temp + \", \"+ cisn +\", \"+ wilg +\")";
	      System.out.println("QRY: " + qrystring + "\n");
	      st.executeUpdate(qrystring );
	      conn.close();
	      System.out.println("Disconnected from database");
	    } catch (Exception e) { e.printStackTrace(); }
	}
	public static void readFromDb(){
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "java";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		try 
		{
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM meteo";

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				Double temp = rs.getDouble("temp");
				Double wilg = rs.getDouble("wilg");
				Double cisn = rs.getDouble("cisn");
				// print the results
				System.out.format("%s, %s, %s, %s, \n", id, temp, wilg, cisn);
			}
			st.close();
			conn.close();
		    System.out.println("Disconnected from database");
		} catch (Exception e) { e.printStackTrace(); }
	}
 
    public static void main( String[] args )
    {
    	DanePogodowe danePogodowe = new DanePogodowe();
    	DaneBiezace daneBiezace = new DaneBiezace(danePogodowe);
    	danePogodowe.ustaw(25, 34, 88);
    	writeToDb(25, 34, 88);
    	readFromDb();
    	
    }
}
