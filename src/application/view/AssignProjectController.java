package application.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import application.model.SystemContoller;
import application.model.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AssignProjectController {
		@FXML
	    private DatePicker DueDate;

	    @FXML
	    private TextField TeamName;

	    @FXML
	    private TextField F_MemberID;

	    @FXML
	    private TextField S_MemberID;

	    @FXML
	    private TextField T_MemberID;
	    

	    @FXML
	    private ComboBox<String> combobox;

	    @FXML
	    private Label LabelMessage;

	    static String emp_id;
	    
	    static String startDate;
	    
	   static  ObservableList<String> options = FXCollections.observableArrayList();
	    
	    public static Team team=new Team();
	    
	    public static String[] teamName=new String[3];
	    
	    SystemContoller controller=SystemContoller.getInstance();
	    
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

	    
 	    public void setEmpId(String id)
		{
			emp_id=id;
			
		}
	    
	    
 	    @FXML
		public void initialize()
		{
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date=new Date();
		    startDate=dateFormat.format(date);   
		  //  emp_id=readFile("file.txt");
		    options.clear();
			List<String> list=controller.getProject(emp_id);
			System.out.println(list.get(0));
		     options.addAll(list);
		   System.out.println(options.get(0));
		    
			combobox.setItems(options);
			
			
		 
			
		}
		
	    @FXML
	    void AssignButton(ActionEvent event)
	    {
	    	String duedate=DueDate.getValue().toString();
	    	if(TeamName.getText().length()>4)
	    	{
	    	team.setName(TeamName.getText());
		    teamName[0]=F_MemberID.getText();
            teamName[1]=S_MemberID.getText();
            teamName[2]=T_MemberID.getText();
            team.setList(teamName);
            String Selected_PID=combobox.getValue();
            
          boolean flag=controller.assignProject(team, Selected_PID, duedate, startDate, emp_id);
           if(flag)
           {
        	   LabelMessage.setText("Assigned successfully");
           }
           else
           {
        	   LabelMessage.setText("You  entered wrong emp_id or already Assigned Project");
           }
	       }
	    	else
	    		LabelMessage.setText("please enter at least 5 digit teamName");
	    }

	    @FXML
	    void BackButton(ActionEvent event)
	    {
	    	((Node)event.getSource()).getScene().getWindow().hide();

	    }

	}


