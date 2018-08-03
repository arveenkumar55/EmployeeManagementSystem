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
import javafx.scene.layout.GridPane;

public class CreateEmployeeController {
	
	@FXML
	private TextField NameOf;
	@FXML
	private TextField PhoneNoOf;
	@FXML
	private TextField SexOf;
	@FXML
	private TextField RoleOf;
	@FXML
	private Label lblMassage;
	@FXML
	private Label Time;
	@FXML
	SystemContoller controller=SystemContoller.getInstance();

	Employee emp=new Employee();
	@FXML
	public void initialize(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
	    String  Timecreated=dateFormat.format(date);   
	    Time.setText(Timecreated);
	   
	    PhoneNoOf.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		        	System.out.println("The old value is " +oldValue);
		        	System.out.println("The new value is " +newValue);
		
		        	 if(newValue.length()>11)
		        	{
		        		PhoneNoOf.setText(oldValue);
		        		
		        	}
		 
		        });
	    
	    
	    SexOf.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		        	System.out.println("The old value is " +oldValue);
		        	System.out.println("The new value is " +newValue);   //sex validatation
		        	
		        	 if(newValue.length()>1)
		        	{
		        		SexOf.setText(oldValue);
		        	}
		 
		        }); 
	    RoleOf.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		        	System.out.println("The old value is " +oldValue);
		        	System.out.println("The new value is " +newValue);
		   
		        	
		        	 if(newValue.length()>1)
		        	{
		        		RoleOf.setText(oldValue);
		        	}
		 
		        }); 
    
		
	}
	@FXML
	public void SaveButton(ActionEvent event)
	{
		if(PhoneNoOf.getText().length()==11 && SexOf.getText().length()==1   && RoleOf.getText().length()==1)
		{	emp.SetName(NameOf.getText());
			emp.SetPhoneNo(PhoneNoOf.getText());
			String a=SexOf.getText();
			System.out.println(a.charAt(0));
			emp.SetGender(a.charAt(0));
			String role=RoleOf.getText();
			if(role.equals("0") && (SexOf.getText().equals("M") || SexOf.getText().equals("F")))
			{
				emp.SetRole("Admin");
				controller.createEmployee(emp);
				lblMassage.setText("Account created Successfully");

			}
			else if(role.equals("1") && (SexOf.getText().equals("M") || SexOf.getText().equals("F")))
			{
				emp.SetRole("Manager");
				controller.createEmployee(emp);
				lblMassage.setText("Account created Successfully");

			}
			else if(role.equals("2") && (SexOf.getText().equals("M") || SexOf.getText().equals("F")))
			{
				emp.SetRole("Simple Employee");
				controller.createEmployee(emp);
				lblMassage.setText("Account created Successfully");

			}
			else
				lblMassage.setText("Please fill coorect form");
		}
		else if(PhoneNoOf.getText().length()<11)
		{
			lblMassage.setText("Please fill correct textfield in phoneNo"); 
		}
		else if(SexOf.getText().length()==0)
		{
			lblMassage.setText("Please fill Sex textField "); 
		}
		else if(RoleOf.getText().length()==0)
		{
			lblMassage.setText("Please fill Role textField "); 
		}
		
	}
@FXML	
public void BackButton(ActionEvent event)
{
	((Node)event.getSource()).getScene().getWindow().hide();
}
@FXML
public void clearButton(ActionEvent event)
{
	NameOf.setText("");
	PhoneNoOf.setText("");
	SexOf.setText("");
	RoleOf.setText("");
	lblMassage.setText("");
	
}
}
