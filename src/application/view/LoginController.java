package application.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import application.Login;
import application.model.Account;
import application.model.Employee;
import application.model.SystemContoller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController  {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    


    @FXML
    private Label lblMessage;
    
   
    
    SystemContoller controller=SystemContoller.getInstance();
    
    
    Employee employee=new Employee();
    
    private Stage primaryStage;
	private BorderPane rootLayout;
	
	
	 public void file_write(String file,String strArray) 
	    {
	        BufferedWriter writer = null;
	    try {

	        writer = new BufferedWriter(new FileWriter(file));
	        
	          writer.write(strArray);
	          writer.newLine();
	          writer.flush();
	        }      
	    
	      catch(IOException ex) {
	        ex.printStackTrace();
	    } 
	    finally{
	        if(writer!=null){
	            try {
	                writer.close();
	            } catch (IOException ex) {
	                System.out.println("input output error occur");
	            }
	        }  
	        
	    }
	    }	
	
	
	  
	public void initialize()
	{
		
		//txtUsername.setText("AAA-");
		
		txtUsername.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		        	System.out.println("The old value is " +oldValue);
		        	System.out.println("The new value is " +newValue);
		        	if(newValue.length()<5)
		        	{
		        		txtUsername.setText("AAA-");
		        	}
		        	else if(newValue.length()<=9)
		        	{
		        		String string=txtUsername.getText();
		        		String[] value=string.split("-");
		        		try
		        		{
		        		int id=Integer.valueOf(value[1]);
		        		}
		        		catch(Exception ex)
		        		{
		        			System.out.println("Exception occurs");
		        			txtUsername.setText(oldValue);
		        			
		        		}
		        		
		        	}
		        	
		        	else if(newValue.length()>9) 
		            	
		            	txtUsername.setText(oldValue);
		            
		        	
		            
		            
		            
		        }
		        
		);
		txtPassword.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > 8) txtPassword.setText(oldValue);
		        }
		);
		
	}
    @FXML
    void btnLoginAction(ActionEvent event)
    {
        
    	//Account account=new Account();
    	String  value=txtUsername.getText();
    	
    	String[] Name=value.split("-");
    	
    	String name=Name[1];
    	
    	System.out.println("The name is "+name);
    	String Password=txtPassword.getText();
    	 
    	if(name.length()==5 && Password.length()==8)
    	{
    		boolean flag=controller.isExistAccount(name, Password);
    		if(flag==true)
    		{
    			//lblMessage.setText("Acccount Exist");
    			file_write("myfile.txt",name);
    			((Node)event.getSource()).getScene().getWindow().hide();
    			String Role=employee.getRole(name);
				if(Role.equals("Admin")) 
    			  PageShow("view/Admin.fxml");
				else if(Role.equals("Manager")) 
	    		  PageShow("view/Manager.fxml");
				else if(Role.equals("Simple Employee")) 
	    		  PageShow("view/EMployee.fxml");

			
				 
    		}
    		else
    		{
    			lblMessage.setText("name or Password  incorrect");
    		}
    	}
    	else if(name.length()<9)
    	{
    		lblMessage.setText("length of name is incorrect");
    	}
    	else if(Password.length()<8)
    	{
    		lblMessage.setText("length of Password is incorrect");
    	}
    	
    }
	


	private void PageShow(String filename) {
		 Parent rootLayout = null;
		 FXMLLoader loader=null;
		 loader = new FXMLLoader();
		 loader.setLocation(Login.class.getResource(filename));
		
		
	      try {
			rootLayout = (Parent) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	    //  show the scene containing the root layout
		Scene scene=new Scene(rootLayout);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setTitle("data");
		primaryStage.show();
	 
	}

/*	public static void main(String[] args) {
		launch(args);
		
	}
*/
}
