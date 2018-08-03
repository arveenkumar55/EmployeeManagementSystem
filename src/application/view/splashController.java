package application.view;

import java.io.IOException;

import application.Login;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class splashController implements Runnable {
	
	private Login login;
	
	@FXML
	private AnchorPane rootPane;
	
	public void run()
	{
		try {
			Thread.sleep(2000);
		 Platform.runLater(new Runnable()
			{

					@Override
					public void run() {
						Parent rootLayout = null;
						try {
							rootLayout = FXMLLoader.load(Login.class.getResource("view/login.fxml"));
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
						rootPane.getScene().getWindow().hide();
						
					}
			 
		 });
		
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	
	@FXML
	public void initialize()
	{
		
          new Thread(this).start();	
	
		
}

}

