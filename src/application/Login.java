package application;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Login extends Application  {
	private Stage primaryStage;
	//private BorderPane rootLayout;
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("AddressApp");
		initRootLayout();
		//showPersonOverview();
	}
	
	
	
	
	public void initRootLayout()
	{
		Parent rootLayout = null;
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("view/splashScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//show the scene containing the root layout
		Scene scene=new Scene(rootLayout);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setTitle("data");
		primaryStage.show();
		
	}
	public void createPage()
	{
		 Parent rootLayout = null;
		 FXMLLoader loader=null;
		 loader = new FXMLLoader();
		// loader.setLocation(getClass().getResource("view/CreateEmployee.fxml"));
		
		
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

	
	
	public static void main(String[] args) {
		launch(args);
	}
}