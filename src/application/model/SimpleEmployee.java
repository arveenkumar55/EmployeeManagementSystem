package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleEmployee {

	
	public List<String> getWorkingProject(String id, String string) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		String query=null;
		jdbc JDBC=new jdbc();
		
		if(string.equals("projects"))
		 query="select P_id from Team where emp_id1="+id+" OR emp_id2="+id+" OR emp_id2="+id;
		else if(string.equals("startdate"))
		 query="select startDate from Team where emp_id1="+id+" OR emp_id2="+id+" OR emp_id2="+id;
		else if(string.equals("duedate"))
		 query="select DueDate from Team where emp_id1="+id+" OR emp_id2="+id+" OR emp_id2="+id;
		else if(string.equals("supervisor"))
		 query="select emp_id from Team where emp_id1="+id+" OR emp_id2="+id+" OR emp_id2="+id;
		try {
			System.out.println(query);
			ResultSet rs=JDBC.stat.executeQuery(query);
			while (rs.next())
			{
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}			
}
