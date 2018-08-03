package application.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.Login;
import application.model.Employee;
import application.model.SystemContoller;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class EmployeeController {
	@FXML
	private TableView<String> AdminTable;
	@FXML
    TableColumn<String, String> Menu;
	@FXML
	private Label SerialNo;
	@FXML
	private Label Name;
	@FXML
	private Label Email;
	@FXML
	private Label PhoneNo;
	@FXML
	private Label Role;
	@FXML
	private Label Sex;
	@FXML
	private Label Date;
	
	Login login=new Login();
	public  static ObservableList<String> Data = FXCollections.observableArrayList();
	String emp_id=null;
	SystemContoller controller=SystemContoller.getInstance();
	Employee emp=new Employee();
private String readFile(String fileName) {
		// TODO Auto-generated method stub
		 String data="";
	        try {
	        
	        FileReader in;
	        in = new FileReader(fileName);
	        BufferedReader br = new BufferedReader(in);
	        String aLine =null; 
	       
	            while ((aLine = br.readLine()) != null) {
	                data=aLine;
	                
	            }
	             in.close();
	        }
	        catch (IOException ex) 
	        {
	            System.out.println("input output error occured");
	        }
			return data;

	}

public void initialize(){
	
	
    //System.out.println("The id is "+emp_id);
	emp_id=readFile("myfile.txt");
   	emp.SetEmpId(emp_id);
	controller.ViewProfile(emp);
	
	SerialNo.setText(emp.GetEmpId());
	Name.setText(emp.GetEmpName());
	Email.setText(emp.GetEmpEmail());
	PhoneNo.setText(emp.GetPhoneNo());
	Role.setText(emp.GetEmpRole());
	Sex.setText(emp.getGender()+" ");
	
	
	Menu.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
	
	Data.clear();
	Data.add("changePassword");		
	Data.add("NoofProjectWorking");
	Data.add("ApplyForLeave");
	Data.add("viewAttendance");
	Data.add("MarkAttendence");
	AdminTable.setItems(Data);
   
	
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date=new Date();
	  String  Timecreated=dateFormat.format(date);   
      Date.setText(Timecreated);
     
      AdminTable.getSelectionModel().selectedItemProperty().addListener(
              (observable, oldValue, newValue) -> newPage(newValue));

	
}

public void newPage(String newValue) {
	// TODO Auto-generated method stub
	System.out.println(newValue);
	if(newValue.equals("changePassword"))
	{
		changePage("view/PasswordChange.fxml");
	}
	else if(newValue.equals("NoofProjectWorking"))
	{
		changePage("view/ProjectWorking.fxml");
	}
	else if(newValue.equals("MarkAttendence"))
	{
		controller.markAttendence(emp_id);
	}
	else if(newValue.equals("viewAttendance"))
	{
		changePage("view/viewAttendence.fxml");
	}
}

private void changePage(String string) {

	Parent rootLayout = null;
	 FXMLLoader loader=null;
	 loader = new FXMLLoader();
	
	 	
	 if(string.equals("view/viewAttendence.fxml"))
	 	{
		   viewAttendenceController controller=new viewAttendenceController();
		   controller.Set_EMp_ID(emp_id);
	 	}
	 
	 else if(string.equals("view/PasswordChange.fxml"))
	 	{
		   PasswordChangController controller=new PasswordChangController();
		   controller.SetEmp_id(emp_id);
	 	}
	    
	    
	    
	    else if(string.equals("view/ProjectWorking.fxml"))
	 	{
	    	ProjectWorkingController controller=new ProjectWorkingController();
	   	    controller.setEmp(emp_id);
		}
		
	 loader.setLocation(Login.class.getResource(string));
	
	
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
	

@FXML
public void Logout(ActionEvent event)
{
	((Node)event.getSource()).getScene().getWindow().hide();
	login.initRootLayout();
}


}
