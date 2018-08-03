package application.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;
import java.security.SecureRandom;
import java.math.BigInteger;


public class rough {
//protected Connection conn;
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   
	//protected Statement stat;
	static SecureRandom rnd = new SecureRandom();

	String randomString( int len ){
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		}

	
	public rough()
	{
	

			
	}
	public static void main(String [] args)
	{
		
		rough Rough=new rough();
		String s=Rough.randomString(5);
		System.out.println(s);
	}
  
}
