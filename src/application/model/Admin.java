package application.model;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

public class Admin extends Employee{
	
	Account account;

	static final String string="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	protected jdbc JDBC;
	public Admin()
	{
	
		JDBC=new jdbc();
		account=new Account();
	
	}
	
String randomString( int length )
{
		 StringBuilder sb = new StringBuilder( length );
		 for( int i = 0; i < length; i++ )                            //generate password
		    sb.append( string.charAt( rnd.nextInt(string.length()) ) );
		   return sb.toString();
}	
			//functions	
 public void createAccount(Employee emp)
  {
	     //traverse database table
	 	String query="select * from employee";
		try {
			ResultSet rs=JDBC.stat.executeQuery(query);
			if(rs.next())
			{
				emp.emp_id="10002";
				String id="";
				boolean flag=false;
				while(rs.next())
				{
					id=rs.getString(1);
					flag=true;
				    
				}
				
	           if(flag)
	           {
	        	   long value=Integer.valueOf(id);
					value=value+1;
					id=String.valueOf(value);                 //assign employee id
					emp.emp_id=id;
	           }
				
				
			     	
			}
			else
			{
				emp.emp_id="10001";
			}
			emp.email=emp.emp_id+"@AAA.edu.pk";           //assign email
			//query="insert into employee values("+emp.emp_id+",NULL,NULL,"   + "'"+emp.email+"'"+",NULL,NULL)";
			query="insert into employee values("+emp.emp_id+",'"+emp.Name+"',"+"'"+emp.phoneNo+"',"+"'"+emp.email+"',"+"'"+emp.Role+"',"+"'"+emp.sex+"'"+")";
			JDBC.stat.executeUpdate(query);                 //execute query
			System.out.println(query);
			System.out.println("record successfully inserted");
			
			String password=randomString(8);
			
			account.set_attribute(emp.emp_id, password);
			
			account.createAccount();
             
			
		//	query="insert into Account values("+emp.emp_id+",'"+password+"')";
		//	System.out.println(query);                     
			//execute query
			//JDBC.stat.executeUpdate(query); 
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	 
	 
  }
 
 public void UpdateAccount(Employee emp)
 {

 	 String query="UPDATE employee SET Name='"+emp.GetEmpName()+"',phoneNo='"+emp.GetPhoneNo()+"',Role='"+emp.GetEmpRole()+"',sex='"+emp.getGender()+"' where emp_id="+emp.GetEmpId();
     System.out.println(query);
     try {
		JDBC.stat.executeUpdate(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }

 @SuppressWarnings("finally")
public boolean deleteAccount(String string2)
 {
	 int count=0;
	 boolean flag=false;
    String query1="DELETE FROM employee WHERE emp_id="+string2;		
	String query2="DELETE FROM Account WHERE emp_id="+string2;	
	try {
		JDBC.stat.executeUpdate(query2);
		JDBC.stat.executeUpdate(query1);
		//flag=true;
		count=2;
		System.out.println("Successfully deleted");	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	//	flag=false;
		count=1;
	
	}
	finally
	{
		if(count==1)
		return false;
		else
			return true;
	}
 }

 
  public void GenerateReport()
  {
	  
  }

  public void ManageAccount()
  {
	   
  }
  public static void main(String [] args)
	{
		Admin admin=new Admin();
		//Employee emp=new Employee();
		//String query="insert into employee values("W+emp.emp_id+",'"+emp.Name+"',"+"'"+emp.phoneNo+"',"+"'"+emp.email+"',"+"'"+emp.Role+"',"+"'"+emp.sex+"'"+")";
		//System.out.println(query);
	   admin.deleteAccount("10001");
	}



}
