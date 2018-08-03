package application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class jdbc
{
		protected Connection conn;
		protected Statement stat;
	public jdbc()
	{	
		String userName = "root";

		/** The password for the MySQL account (or empty for anonymous) */
		String password = "12345";

		/** The name of the computer running MySQL */
		String serverName = "localhost";

		/** The port of the MySQL server (default is 3306) */
		int portNumber = 3306;

		/**
		 * The name of the database we are testing with (this default is
		 * installed with MySQL)
		 */
		String dbName = "myschema";
		try 
		{
		    conn = null;
	
			Properties connectionProps = new Properties();
			connectionProps.put("user", userName);
			connectionProps.put("password", password);
			System.out.println("trying to get connection!! ");
			conn = DriverManager.getConnection("jdbc:mysql://" + serverName
					+ ":" + portNumber + "/" + dbName, connectionProps);
		     stat=conn.createStatement();	 
			System.out.println("..........Connection Successfully Created...........");
		

		}
		catch(Exception ex)
		{
			ex.printStackTrace();

		}

	}
}
