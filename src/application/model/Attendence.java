package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Attendence {
	jdbc JDBC;

 public void  markAttendence(String emp_id)
{
	 String query=null;
	 int value=0;
	JDBC =new jdbc();
	Random rand = new Random();
	int month=13;
	int days=0;
	for(int j=1;j<month;j++)
	{   days=0;
		for(int i=0;i<31;i++)
		{
			 value = rand.nextInt(2);
			 query="insert into Attendence values("+emp_id+","+j+","+days+","+value+")";
			 System.out.println(query);
			 try {
				JDBC.stat.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				break;
			}
			 days++;
		}
	}
	{
		
	}
	
	//String query="insert into Att values("+emp.emp_id+",
}
public List<Double> view_Attendence(String emp_id)
{   JDBC =new jdbc();
	String query=null;
	List <Double>  list=new ArrayList<Double>();
	//int var=1;
	//List<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
	System.out.println("The emp_id is "+emp_id);
	for(int i=1;i<13;i++)
	{
		double counter=0;
		query="select  Present from Attendence where emp_id="+emp_id+" AND month="+i;
		try {
			ResultSet rs=JDBC.stat.executeQuery(query);
			while(rs.next())
			{   
				String value=rs.getString(1);
				if(value.equals("1"))
				{
					counter++;
				}
			}
			list.add(counter);
			// double val=((counter/30)*100);
			//list.add(String.format("%.2f", val)+" %");
		}
	      catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return list;
	
}
}
