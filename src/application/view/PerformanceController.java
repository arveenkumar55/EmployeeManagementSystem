package application.view;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import application.model.SystemContoller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

public class PerformanceController {
	
		

	    @FXML
	    private BarChart<String, Double> barChart;

	    @FXML
	    private CategoryAxis xAxis;

	   
	    static  ObservableList<String> options = FXCollections.observableArrayList("Jan","Feb","March","April","May","June","July","August","Sep","Oct","Nov","Dec");


	    static String emp_id;
	    
	    SystemContoller controller=SystemContoller.getInstance();

	    public void SetEmp_ID(String emp_id2)
	    {
	    	emp_id=emp_id2;
	    }
	    
	    @FXML
	    private void initialize() {
	        // Get an array with the English month names.
	        
	        // Convert it to a list and add it to our ObservableList of months.
	        //System.out.println("The length of month is" + months.length);
	        

	        // Assign the month names as categories for the horizontal axis.
	        xAxis.setCategories(options);
	        
	        List<Double>list=controller.viewAttendence(emp_id);
	        System.out.print("the size of list is "+list.size()); 
	        for(int i=0;i<list.size();i++)
	        {
	        	System.out.println(list.get(i));
	        }
	        XYChart.Series<String, Double> series = new XYChart.Series<>();
	        
	        // Create a XYChart.Data object for each month. Add it to the series.
	        for (int i = 0; i <list.size()-1; i++) {
	        	series.getData().add(new XYChart.Data<>(options.get(i), list.get(i)));
	        }

	        barChart.getData().add(series);
	        
	        
	        
	    }

	    
	   	

}
