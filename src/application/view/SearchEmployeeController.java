package application.view;

import java.io.IOException;

import application.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchEmployeeController {

	 	@FXML
	    private TextField emp_id;
	 	
	 	static String empId;
	 	
	public void setEmpID(String id)
	{
		empId=id;
	}

	    @FXML
	    void searchbutton(ActionEvent event) {
	    
	    String id=emp_id.getText();
	   ((Node)event.getSource()).getScene().getWindow().hide();

	    Parent rootLayout = null;
	   	 FXMLLoader loader=null;
	   	 loader = new FXMLLoader();
	 	PerformanceController controller=new PerformanceController();
	   	controller.SetEmp_ID(id);
	   
	   	 loader.setLocation(Login.class.getResource("view/Performance.fxml"));
	   	
	   	
	       try {
	   		rootLayout = (Parent) loader.load();
	   		
	   	
	   	} catch (IOException e) {
	   		// TODO Auto-generated catch block
	   		e.printStackTrace();
	   	}
	      
	     //  show the scene containing the root layout
	   // System.out.println("the Admin Controller is "+emp_id);
	   	Scene scene=new Scene(rootLayout);
	   	Stage primaryStage = new Stage();
	   	primaryStage.setScene(scene);
	   	primaryStage.setTitle("data");
	   	primaryStage.show();
	   	

	    }
}
