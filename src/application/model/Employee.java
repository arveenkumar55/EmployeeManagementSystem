package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
	String emp_id;
	String Name;           // attribute of class
	String phoneNo;
	String email;
	char sex;
	String Role;
	Profile profile;
	
	public Employee()
	{
		  profile=new Profile();

		   emp_id=null;
		   Name=null;                             //default constructor
		   phoneNo=null;
		   email=null;
		   sex=' ';
		   Role=null;
	}
	Employee(String emp_id,String Name,String phone,String email,char sex,String role)
	{   
		 profile=new Profile();
         this.emp_id=emp_id;
		 this.Name=Name;                                                  //parametrize constructor
		 this.phoneNo=phone;
		 this.email=email;
		 this.sex=sex;
		 this.Role=role;
		 
	}
	void set_attribbute(String emp_id,String Name,String phone,String email,char sex,String Role)
	{
		 this.emp_id=emp_id;
		 this.Name=Name;                                                  //Function of set attribute
		 this.phoneNo=phone;
		 this.email=email;
		 this.sex=sex;
		 this.Role=Role;
	}
	public char getGender()
	{
		return sex;
	}
   public String GetEmpId()
   {
	      return emp_id;
   }
   public void SetEmpId(String id)
   {
	     emp_id=id;
   }
   public void SetName(String name)
   {
	     Name=name;
   }
   public void SetPhoneNo(String num)
   {
	     phoneNo=num;
   }
   public void SetGender(char sex)
   {
	     this.sex=sex;
   }
   public void SetRole(String role)
   {
	     Role=role;
   }
   
   public String GetEmpName()
   {                                                                          //getter function
	      return Name;
   }
  public String GetPhoneNo()
   {
	  return phoneNo;  
   }
   public String GetEmpEmail()
   {
	   return email;
   }
   public String GetEmpRole()
   {
	   return Role;
   }
   public String EmpNum()
   {
	   return phoneNo;
   }
 public  String getRole(String id)
   {
   	jdbc JDBC = new jdbc();
      String Role=null;
   	String query="select Role from Employee where emp_id="+id;
   	System.out.println(query);                     
   	//execute query
   	try {
   		ResultSet rs=JDBC.stat.executeQuery(query);
   		if(rs.next())
   		{
   			Role=rs.getString(1);
   			rs.close();
   		}
   	} catch (SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	} 
   	
   	return Role;
   }
   
 public  void viewProfile()
  {
	  profile.viewProfile(this);
	  
  }

}
