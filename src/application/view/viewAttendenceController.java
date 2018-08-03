package application.view;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import application.model.SystemContoller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class viewAttendenceController {

	@FXML
    private ComboBox<String> combobox;

    @FXML
    private Label percentage;

    static String emp_id;
    
    static List<String> list=new ArrayList<String>();
    
    void Set_EMp_ID(String id)
    {
    	emp_id=id;
    }
    //static  ObservableList<String> options = FXCollections.observableArrayList("January","February","March","April","May","June","July","August","September","October","November","December");
    static  ObservableList<String> options = FXCollections.observableArrayList();
    SystemContoller controller=SystemContoller.getInstance();
    
    @FXML
  	public void initialize()
  	{
    	
      List<Double>list1;
       list1=controller.viewAttendence(emp_id);
       for(int i=0;i<list1.size();i++)
       {
    	   double val=((list1.get(i)/30)*100);
    	   System.out.println(val);
		  list.add(String.format("%.2f", val)+" %");
       }
       
       String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
       // Convert it to a list and add it to our ObservableList of months.
       options.addAll(Arrays.asList(months));
       
       combobox.setItems(options);
       
       System.out.println("The soze of list is "+list.size());
       for(int i=0;i<list.size();i++)
       {
    	   System.out.println(list.get(i));
       }
       combobox.getSelectionModel().selectedItemProperty().addListener(
               (observable, oldValue, newValue) -> newPage(newValue));
  	}
  		
    
    private void newPage(String newValue) {
    	
    	if(newValue.equals("January"))
    	{
    		percentage.setText(list.get(0));
    	}
    	if(newValue.equals("February"))
    	{
    		percentage.setText(list.get(1));
    	}
    	if(newValue.equals("March"))
    	{
    		percentage.setText(list.get(2));
    	}
    	if(newValue.equals("April"))
    	{
    		percentage.setText(list.get(3));
    	}
    	if(newValue.equals("May"))
    	{
    		percentage.setText(list.get(4));
    	}
    	if(newValue.equals("June"))
    	{
    		percentage.setText(list.get(5));
    	}
    	if(newValue.equals("July"))
    	{
    		percentage.setText(list.get(6));
    	}
    	if(newValue.equals("August"))
    	{
    		percentage.setText(list.get(7));
    	}
    	if(newValue.equals("September"))
    	{
    		percentage.setText(list.get(8));
    	}
    	if(newValue.equals("October"))
    	{
    		percentage.setText(list.get(9));
    	}
    	if(newValue.equals("November"))
    	{
    		percentage.setText(list.get(10));
    	}
    	if(newValue.equals("December"))
    	{
    		percentage.setText(list.get(11));
    	}
    	
		
	}


	@FXML
    void backButton(ActionEvent event) {
    ((Node)event.getSource()).getScene().getWindow().hide();

    }
}
