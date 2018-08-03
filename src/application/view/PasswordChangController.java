package application.view;

import application.model.SystemContoller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PasswordChangController {
	
    @FXML
    private TextField currentPassword;
    @FXML
    private TextField NewPassword;
    @FXML
    private Label lblMessage;
    
    static String  emp_id;
    
    SystemContoller controller=SystemContoller.getInstance();;
    
    public void SetEmp_id(String id)
    {
    	System.out.println("the Password&id is "+id);
    	
    	emp_id=id;
    }
    @FXML
    public void initialize() 
    {
    	
    }
    
    @FXML
    public void SaveButton(ActionEvent event)
    {
    	String C_Password=currentPassword.getText();
    	String N_Password=NewPassword.getText();
    	if(C_Password.length()==8 && N_Password.length()==8)
    	{
    		System.out.println("The send_id is "+ emp_id);
             boolean flag=controller.ChangePassword(emp_id,C_Password,N_Password);
             if(flag==true)
             {
            	 lblMessage.setText("Successfully changed");
            	 currentPassword.setText("");
            	 NewPassword.setText("");
            	 
             }
             else
             {
            	 lblMessage.setText("You entered wrong Password");
             }
    	}
    	else if(C_Password.length()<8)
    	{
    		lblMessage.setText("You entered wrong current Password");		
    	}
    	else if(N_Password.length()<8)
    	{
    		lblMessage.setText("Please entered  exactly 8 digit Password");
    		
    	}
    }
    public void Backbutton(ActionEvent event)
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
    }

}
