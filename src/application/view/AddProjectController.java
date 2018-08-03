package application.view;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import application.model.Project;
import application.model.SystemContoller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddProjectController {

	@FXML
	private DatePicker DueDate;
	
	@FXML
	private TextField P_Name;
	
	@FXML
	private TextArea Discription;
	
	@FXML
	private Label lblMessage;
	
	static String startDate;
	
	static String emp_id;
	
	SystemContoller controller=SystemContoller.getInstance();
	
	Project project=new Project();

	
	public void setEmpId(String id)
	{
		emp_id=id;
	}
	
	@FXML
	public void initialize()
	{
		lblMessage.setText("");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
	    startDate=dateFormat.format(date);   
	    
		
	}
	
	
	@FXML
	void AddButton(ActionEvent event)
	{
		String duedate=DueDate.getValue().toString();
    	//SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   // String duedate=dateFormat.format(Duedate); 
	
		System.out.println("the date is "+duedate);
		String nameOfProject=P_Name.getText();
		String Disc=Discription.getText();
		if(P_Name.getText().length()>5)
		{
		project.set_attribute(startDate, duedate, nameOfProject, Disc);
		
		boolean flag=controller.addProject(emp_id,project);
		if(flag)
		{
			lblMessage.setText("Successfully add Project");
		}
		else
			lblMessage.setText("not successfully add Project");
		}
		else
		{	
			lblMessage.setText(" please enter at least 5 digit  Name");	
		}
		P_Name.setText("");
		Discription.setText("");
		
	}
	
	@FXML
	void BackButton(ActionEvent event)
	{
		((Node)event.getSource()).getScene().getWindow().hide();
	}
	
	
	
	

}
