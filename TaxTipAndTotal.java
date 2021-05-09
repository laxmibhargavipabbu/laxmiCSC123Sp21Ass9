package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;


public class TaxTipAndTotal extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Label mealCharge = new Label("Meal Charge:");
			TextField mealTxt = new TextField();
			HBox mealHBox = new HBox(10, mealCharge,mealTxt);
			mealHBox.setAlignment(Pos.CENTER_LEFT);
			
			Label tipLabel = new Label("Tip:");
			
			Label taxLabel = new Label("Tax:");
			
			Label totalLabel = new Label("Total:");
			
			Button calButton = new Button("Calculate");
			HBox calButtonHBox = new HBox(calButton);
			calButtonHBox.setAlignment(Pos.CENTER);
			
			calButton.setOnAction(event ->
			{
				final double TAX_RATE = 0.09;
				final double TIPRATE = 0.21;
				double mealcharge = Double.parseDouble(mealTxt.getText());
				double tipAmount = mealcharge * TIPRATE;
				double taxAmount = mealcharge * TAX_RATE;
				double total = mealcharge + tipAmount + taxAmount;
				tipLabel.setText(String.format("Tip: $%.2f",tipAmount));
				taxLabel.setText(String.format("Tax: $%.2f", taxAmount));
				totalLabel.setText(String.format("Total: $%.2f", total));
			});
			
			HBox btnBox = new HBox(calButton);
			btnBox.setAlignment(Pos.CENTER);
			
			VBox verticalBox = new VBox(10, mealHBox, tipLabel, taxLabel, totalLabel, btnBox);
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
