package application.model;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mainClass {

	protected jdbc JDBC;
public mainClass()
{
	JDBC=new jdbc();
}
public void  initilizeTable()
{
	int size=5;
	String []TableName=new String[size];
	String []query=new String[size];
	TableName[0]="Employee";
	TableName[1]="Account";
	TableName[2]="Project";
	TableName[3]="Team";
	TableName[4]="Attendence";
	query[0]="create Table Employee(emp_id VARCHAR(255) not null primary key,Name VARCHAR(255),phoneNo VARCHAR(255),email VARCHAR(255),Role VARCHAR(255),sex VARCHAR(1))";
	query[1]="create Table Account(emp_id VARCHAR(255) not null primary key,Password VARCHAR(255), foreign key(emp_id) references employee(emp_id))";
	query[2]="create Table Project(P_id VARCHAR(255) not null,P_Name VARCHAR(255),startDate VARCHAR(255),DueDate VARCHAR(255),Discription VARCHAR(255),emp_id VARCHAR(255), foreign key(emp_id) references employee(emp_id))";
	query[3]="create Table Team(TeamName VARCHAR(255),P_id VARCHAR(255) not null primary Key ,startDate VARCHAR(255),DueDate VARCHAR(255),emp_id VARCHAR(255),emp_id1 VARCHAR(255),emp_id2 VARCHAR(255),emp_id3 VARCHAR(255), foreign key(emp_id) references employee(emp_id),foreign key(emp_id1) references employee(emp_id),foreign key(emp_id2) references employee(emp_id),foreign key(emp_id3) references employee(emp_id))";
	query[4]="create Table Attendence(emp_id VARCHAR(255),month INTEGER, SerialNo INTEGER,Present INTEGER,foreign key(emp_id) references employee(emp_id))";
	DatabaseMetaData dbm = null;
	try 
	{
		dbm = JDBC.conn.getMetaData();
		ResultSet tables;
		for(int i=0;i<size;i++)
		{
			tables = dbm.getTables(null, null, TableName[i], null);
			if (tables.next())
			{
				System.out.println("Table already exist in database Table");	 
			}
		   else
		   {        
			    System.out.println("Table doesnot exist");
			    JDBC.stat.executeUpdate(query[i]);
			    if(i==2)
			    {
			    	String sql="ALTER TABLE "+TableName[i]+" ADD PRIMARY KEY(P_id,emp_id)";
			    	System.out.println(sql);
			    	JDBC.stat.executeUpdate(sql);
			    	System.out.println(" create Successfully Composite Key");
			    }
			    if(i==4)
			    {
			    	String sql="ALTER TABLE "+TableName[i]+" ADD PRIMARY KEY(emp_id,month,SerialNo)";
			    	System.out.println(sql);
			    	JDBC.stat.executeUpdate(sql);
			    	System.out.println(" create Successfully Composite Key");
			    }
				System.out.println("Table create Successfully");
				  
		   }
			
		}
	} 
	catch (SQLException e) 
	{
		
		e.printStackTrace();
	}
	
	
}
	
public static void main(String []args)
{
	mainClass Class=new mainClass();
	Class.initilizeTable();
}
}
