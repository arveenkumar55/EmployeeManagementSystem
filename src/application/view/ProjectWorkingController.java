package application.view;

import java.util.List;

import application.model.SystemContoller;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProjectWorkingController
{
	
	    @FXML
	    private TableView<Person> table;

	    @FXML
	    private TableColumn<Person, String> ProjectNamecol;

	    @FXML
	    private TableColumn<Person, String> Supervisorcol;

	    @FXML
	    private TableColumn<Person,String> StartDatecol;

	    @FXML
	    private TableColumn<Person, String> DueDatecol;
	    
	    List<String>Projects;
	    
	    List<String>Startdate;
	    
	    List<String>Duedate;
	    
	    List<String>supervior;
	    
		public   ObservableList<Person> Data = FXCollections.observableArrayList();

	    
	    SystemContoller controller=SystemContoller.getInstance();
	    
	    static String emp_id;
	    
	    public void setEmp(String id)
	    {
	    	emp_id=id;
	    }
	   @FXML
	   public void initialize()
	   {
		   
		   Data.clear();
		   ProjectNamecol.setCellValueFactory(cellData -> cellData.getValue().getP_id());
		   Supervisorcol.setCellValueFactory(cellData -> cellData.getValue().getSupervisor_id());
		   StartDatecol.setCellValueFactory(cellData -> cellData.getValue().getStartdate());
		   DueDatecol.setCellValueFactory(cellData -> cellData.getValue().getDuedate());
		  
		   Projects=controller.calculate(emp_id,"projects");
		   Startdate=controller.calculate(emp_id,"startdate");
		   Duedate=controller.calculate(emp_id,"duedate");
		   supervior=controller.calculate(emp_id,"supervisor");
		   
		   System.out.println("The size of project is "+Projects.size());
		   
		   System.out.println("the start date is "+Startdate); 
		   
		   
		   for(int i=0;i<Projects.size();i++)
		   {
		           Data.add(new Person(Projects.get(i),Startdate.get(i), Duedate.get(i),supervior.get(i)));

		   }
		   			table.setItems(Data);
	   }
	    
	    @FXML
	    void backButton(ActionEvent event) 
	    {
	    	((Node)event.getSource()).getScene().getWindow().hide();

	    }

	}


