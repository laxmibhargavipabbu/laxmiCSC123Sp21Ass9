package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HeadsOrTails extends Application 
{
	private Random randy = new Random((new Random()).nextLong());
	private ImageView coin;
	int tossInput;
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			coin = new ImageView();
			this.coin.setFitHeight(200);
			this.coin.setFitWidth(200);
			Button tossButton = new Button("Toss");
			
			tossButton.setOnAction(event ->
			{
				tossInput = randy.nextInt(2);
				if(tossInput == 0)
				{
					File file = new File("/Users/abhilashchilukapally/LaxmiBhargaviPabbu/CSUDHCourses/CSC123SP2021/JavaFXPrograms/heads1.png");
				    Image image = new Image(file.toURI().toString());
					this.coin.setImage(image);
				}
				else
				{
					File file = new File("/Users/abhilashchilukapally/LaxmiBhargaviPabbu/CSUDHCourses/CSC123SP2021/JavaFXPrograms/tails1.png");
				    Image image = new Image(file.toURI().toString());
					this.coin.setImage(image);
				}
			});
			
			VBox verticalBox = new VBox(10,this.coin,tossButton);
			verticalBox.setAlignment(Pos.CENTER);
			verticalBox.setPadding(new Insets(10, 10, 10, 10));
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(verticalBox);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
