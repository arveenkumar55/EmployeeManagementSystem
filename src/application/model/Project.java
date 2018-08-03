package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Project {
	

	String StartDate;
	String DueDate;
	String Name;
	String Discription;
	public String P_id;
	
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return StartDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return DueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the discription
	 */
	public String getDiscription() {
		return Discription;
	}
	/**
	 * @param discription the discription to set
	 */
	public void setDiscription(String discription) {
		Discription = discription;
	}
	/**
	 * @return the p_id
	 */
	public String getP_id() {
		return P_id;
	}
	/**
	 * @param p_id the p_id to set
	 */
	public void setP_id(String p_id) {
		P_id = p_id;
	}

	public void set_attribute(String s_date,String D_date,String name,String disc)
	{
		StartDate=s_date;
		DueDate=D_date;
		Name=name;
		Discription=disc;
	}
	public List<String> getproject(String id) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();

		jdbc JDBC=new jdbc();
		
		String query="select P_id from Project where emp_id="+id;
		
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
	public List<String> calculate(String id, String string) {
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

	

