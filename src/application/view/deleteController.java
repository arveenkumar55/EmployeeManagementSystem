package application.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import application.model.SystemContoller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class deleteController {
	
	@FXML 
	private TextField emp_id;
	@FXML
	private Label Message;
	@FXML
	private Label Time;
	
	SystemContoller controller=SystemContoller.getInstance();

	@FXML
	public void initialize()
	{
		//*********************Set Date On paGe**************************************//
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
	public void deleteButton(ActionEvent event)
	{
		if(emp_id.getText().length()==9)
		{
			String []s=emp_id.getText().split("-");
			boolean flag=controller.deleteEmployee(s[1]);
			if(flag)
			Message.setText("Successfully deleted");
			else
			Message.setText("Account doesont exist");
			emp_id.setText("");
			
		
		}
		else
		{
			Message.setText("enter correct employee id");
			
		}
		
	}
	
	
	
	
	@FXML	
	public void BackButton(ActionEvent event)
	{
		((Node)event.getSource()).getScene().getWindow().hide();
	}

}
