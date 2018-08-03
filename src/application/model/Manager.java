package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager extends Employee{

	jdbc   JDBC;
	
	
	
	public boolean addProject(String emp_id,Project project)
	{
		JDBC=new jdbc();
		
		
		String query="select * from Project";
		try {
			ResultSet rs=JDBC.stat.executeQuery(query);
			if(rs.next())
			{
				project.setP_id("10002");	
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
					project.setP_id(id);
	           }
				
				
			     	
			}
			else
			{
				project.setP_id("10001");
			}
			
			query="insert into Project values("+project.getP_id()+",'"+project.getName()+"',"+"'"+project.getStartDate()+"',"+"'"+project.getDueDate()+"',"+"'"+project.getDiscription()+"',"+emp_id+")";
			JDBC.stat.executeUpdate(query);                 //execute query
			System.out.println(query);
			System.out.println("record successfully inserted");
			return true;
		}
			catch(Exception ex)
			{
				return false;
			}
                     		
	}

	
	
	public void Notify()
	{
		
	}
	
	public void Supervise()
	{
		
	}
	


	public boolean ProjectAssign(Team team, String selected_PID, String duedate, String startDate, String emp_id)
	{
		JDBC=new jdbc();
		boolean flag=false;
		String []list=team.getList();
		String query="insert into Team values('"+team.getName()+"',"+selected_PID+","+"'"+startDate+"',"+"'"+duedate+"',"+emp_id+","+list[0]+","+list[1]+","+list[2]+")";
		System.out.println(query);
		try {
			JDBC.stat.executeUpdate(query);
			flag=true;
			System.out.println("Arveen");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("arveen");

			return false;
		}
		return flag;
		
	}



	



	
}
