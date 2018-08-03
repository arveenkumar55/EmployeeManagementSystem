package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile {
	protected jdbc JDBC;
	
public void viewProfile(Employee emp)
{
	
	JDBC=new jdbc();
	String query="select * from  Employee where emp_id="+emp.emp_id;
	System.out.println(query);
	try {
		ResultSet rs=JDBC.stat.executeQuery(query);
		while(rs.next())
		{
			emp.Name=rs.getString(2);
			emp.phoneNo=rs.getString(3);
			emp.email=rs.getString(4);
			emp.Role=rs.getString(5);
		    String s=rs.getString(6);
		    emp.sex=s.charAt(0);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
