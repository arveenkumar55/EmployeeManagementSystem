package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {

	jdbc JDBC;
	String password;                                  //attribute
	String emp_id;
	
	public Account()
	{
		password=null;
		emp_id=null;                     //default constructor
	}
	public Account(String emp_id,String password)
	{
		this.emp_id=emp_id;
		this.password=password;                  //paramtrize constructor
	}
	public void set_attribute(String emp_id,String password)
	{
		this.emp_id=emp_id;
		this.password=password;                            //set attribute function
	}
	  String GetAccId()
	   {
		      return emp_id;                   //getter function
	   }
	  String GetAccPassword()
	  {
		  return password;
	  }

	  
public boolean isExistAccount(String id,String Password)
{
	
	boolean flag=false;
	JDBC=new jdbc();
	String query="select * from Account where emp_id="+id+" and Password ="+"'"+Password+"'";
	System.out.println(query);
    try {
		ResultSet rs=JDBC.stat.executeQuery(query);
		if(rs.next())
		{
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return flag;
	
}
public void createAccount()
{   
	JDBC=new jdbc();

	String query="insert into Account values("+emp_id+",'"+password+"')";
	System.out.println(query);                     
	//execute query
	try {
		JDBC.stat.executeUpdate(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}

public static void main(String[] args)
{
	
	Account account=new Account();
	boolean flag=account.isExistAccount("123","123");
}
public boolean ChangePassword(String emp_id2, String c_Password, String n_Password) {
	
	JDBC=new jdbc();

	boolean flag=false;
	
	String query="select * from Account where emp_id="+emp_id2+" and Password ="+"'"+c_Password+"'";
	System.out.println(query);
    
		try {
			ResultSet rs=JDBC.stat.executeQuery(query);
		    if(rs.next())
			{
				flag=true;
				query="UPDATE Account SET Password ='"+n_Password+"'"+" where emp_id="+emp_id2;
				System.out.println(query);;
				JDBC.stat.executeUpdate(query); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
    	
	
	return flag;
	
}
	
}
