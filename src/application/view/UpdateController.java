package application.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import application.model.Employee;
import application.model.SystemContoller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateController {
	
	@FXML
	private TextField Name;
	@FXML
	private TextField PhoneNo;
	@FXML
	private TextField Sex;
	@FXML
	private TextField Role;
	@FXML
	private TextField emp_id;
	@FXML
	private Label lblMassage;
	@FXML
	private Label Time;
	
	SystemContoller controller=SystemContoller.getInstance();
	Employee emp=new Employee();
	@FXML
	public void initialize()
	{
	   lblMassage.setText("");
	  //********************************Set Date On paGe**************************************//
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();               
	    String  Timecreated=dateFormat.format(date);   
	    Time.setText(Timecreated);
	    
	    emp_id.setText("AAA-"); 
	    //*********************************get emp id on update page validatation*********************//
	    emp_id.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		        	System.out.println("The old value is " +oldValue);
		        	System.out.println("The new value is " +newValue);
		        	if(newValue.length()<5)
		        	{
		        		emp_id.setText("AAA-");
		        	}
		        	else if(newValue.length()<=9)
		        	{
		        		String string=emp_id.getText();
		        		String[] value=string.split("-");
		        		try
		        		{
		        		int id=Integer.valueOf(value[1]);
		        		}
		        		catch(Exception ex)
		        		{
		        			System.out.println("Exception occurs");
		        			emp_id.setText(oldValue);
		        			
		        		}
		        		
		        	}
		        	
		        	else if(newValue.length()>9) 
		            	
		            	emp_id.setText(oldValue);
		            
		        	
		            
		            
		            
		        }
		        
		);
	   
		
	}
	@FXML
	public void searchButton()
	{
		if(emp_id.getText().length()==9)
		{	
			String []s=emp_id.getText().split("-");
			emp.SetEmpId(s[1]);
			controller.ViewProfile(emp);
			Name.setText(emp.GetEmpName());
			PhoneNo.setText(emp.GetPhoneNo());
			Sex.setText(emp.getGender()+" ");
			if(emp.GetEmpRole().equals("Admin"))
				{
				
					Role.setText("0");
				
				}
			else if(emp.GetEmpRole().equals("Manager"))
			{
			
				Role.setText("1");
			
			}
			else if(emp.GetEmpRole().equals("Simple Employee"))
			{
			
				Role.setText("2");
			
			}

			
		}
		else
		{
			lblMassage.setText("enter correct employee id");
			
		}
	}
	@FXML
	public void UpdateButton(ActionEvent event)
	{
		emp.SetName(Name.getText());
		String a=Sex.getText();
		System.out.println(a.charAt(0));
		emp.SetGender(a.charAt(0));
		emp.SetPhoneNo(PhoneNo.getText());
		String role=Role.getText();
		if(role.equals("0") && (Sex.getText().equals("M") || Sex.getText().equals("F")) && PhoneNo.getText().length()==11)
		{
			emp.SetRole("Admin");
			controller.update(emp);
			lblMassage.setText("successfullyUpdated");
		}
		else if(role.equals("1") && (Sex.getText().equals("M") || Sex.getText().equals("F")) && PhoneNo.getText().length()==11)
		{
			emp.SetRole("Manager");
			 controller.update(emp);
			 lblMassage.setText("successfullyUpdated");
		}
		else if(role.equals("2") && (Sex.getText().equals("M") || Sex.getText().equals("F")) && PhoneNo.getText().length()==11 )
		{
			emp.SetRole("SimpleEmployee");
			 controller.update(emp);
			 lblMassage.setText("successfullyUpdated");
		}
		else
			 lblMassage.setText("please fill correct form");
		//emp.SetRole(role);
	   
	}
	@FXML	
	public void BackButton(ActionEvent event)
	{
		((Node)event.getSource()).getScene().getWindow().hide();
	}
	
	
}
