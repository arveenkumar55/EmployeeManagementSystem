package application.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.Login;
import application.model.Employee;
import application.model.SystemContoller;
import javafx.application.Platform;
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

public class AdminController implements Runnable{

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
	
	Login mainapp=new Login();
	String emp_id=null;
	SystemContoller controller=SystemContoller.getInstance();
	Employee emp=new Employee();
	public  static ObservableList<String> Data = FXCollections.observableArrayList();
	
	public void createPage()
	{
		 Parent rootLayout = null;
		 FXMLLoader loader=null;
		 loader = new FXMLLoader();
		 loader.setLocation(Login.class.getResource("view/CreateEmployee.fxml"));
		
		
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
	
	public void UpdatePage()
	{
		 Parent rootLayout = null;
		 FXMLLoader loader=null;
		 loader = new FXMLLoader();
		 loader.setLocation(Login.class.getResource("view/updateEmployee.fxml"));
		
		
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
	private void DeletePage()
	{
		 Parent rootLayout = null;
		 FXMLLoader loader=null;
		 loader = new FXMLLoader();
		 loader.setLocation(Login.class.getResource("view/deleteEmployee.fxml"));
		
		
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
	
private void PasswordChangePage() {
	
	 Parent rootLayout = null;
	 FXMLLoader loader=null;
	 loader = new FXMLLoader();
	 loader.setLocation(Login.class.getResource("view/PasswordChange.fxml"));
	
	
    try {
		rootLayout = (Parent) loader.load();
		
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
  //  show the scene containing the root layout
    System.out.println("the Admin Controller is "+emp_id);
	PasswordChangController PCcontroller=new PasswordChangController();
	PCcontroller.SetEmp_id(emp_id);
	Scene scene=new Scene(rootLayout);
	Stage primaryStage = new Stage();
	primaryStage.setScene(scene);
	primaryStage.setTitle("data");
	primaryStage.show();
	

		
		
	}

public void viewAttendence()
{
	Parent rootLayout = null;
	 FXMLLoader loader=null;
	 loader = new FXMLLoader();
	 viewAttendenceController controller=new viewAttendenceController();
	 controller.Set_EMp_ID(emp_id);
	 loader.setLocation(Login.class.getResource("view/viewAttendence.fxml"));
	
	
   try {
		rootLayout = (Parent) loader.load();
		
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
 //  show the scene containing the root layout
    System.out.println("the Admin Controller is "+emp_id);
	Scene scene=new Scene(rootLayout);
	Stage primaryStage = new Stage();
	primaryStage.setScene(scene);
	primaryStage.setTitle("data");
	primaryStage.show();
	

}
	
	

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

	
	void setEmp_id(String id)
	{
		emp_id=id;
		System.out.println("The emp id is "+emp_id);
	}
	@FXML
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
	Data.add("CreateAccount");		
	Data.add("DeleteAccount");
	Data.add("UpdateAccount");
	Data.add("PasswordChange");
	Data.add("viewAttendance");
	Data.add("MarkAttendance");
	AdminTable.setItems(Data);
   
	
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date=new Date();
	  String  Timecreated=dateFormat.format(date);   
      Date.setText(Timecreated);
     
      AdminTable.getSelectionModel().selectedItemProperty().addListener(
              (observable, oldValue, newValue) -> newPage(newValue));

	
}
	
public void run()
{
		while(true)
		{
			Platform.runLater(new Runnable()
			{
			 @Override
			 public void run() 
			 {
			  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			  Date date=new Date();
			  String  Timecreated=dateFormat.format(date);   
		      Date.setText(Timecreated);
		      
		}
			});
}
}


	public void newPage(String newValue) {
		// TODO Auto-generated method stub
		System.out.println(newValue);
		//System.out.println("The id is "+emp_id);
		if(newValue.equals("CreateAccount"))
		{
			createPage();
		}
		else if(newValue.equals("UpdateAccount"))
		{
			UpdatePage();
		}
		else if(newValue.equals("DeleteAccount"))
		{
			DeletePage();
		}
		else if(newValue.equals("PasswordChange"))
		{
			
			
			PasswordChangePage();
		}
		else if(newValue.equals("MarkAttendance"))
		{
			controller.markAttendence(emp_id);
		}
		else if(newValue.equals("viewAttendance"))
	 	{
			   viewAttendence();
	 	}
		
	}

	
	@FXML
	public void Logout(ActionEvent event)
	{
		((Node)event.getSource()).getScene().getWindow().hide();
		mainapp.initRootLayout();
	}
	

}