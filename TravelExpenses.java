package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class TravelExpenses extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try
		{
			Label daysLabel = new Label("Days on the trip:");
			TextField daysText = new TextField();
			HBox daysHBox = new HBox(10,daysLabel,daysText);
			daysHBox.setAlignment(Pos.CENTER_LEFT);
			
			Label airfareLabel = new Label("Airfare:");
			TextField airfareText = new TextField();
			HBox airfareHBox = new HBox(10,airfareLabel,airfareText);
			airfareHBox.setAlignment(Pos.CENTER_LEFT);
			
			Label carRentalLabel = new Label ("Car Rental:");
			TextField carRentalText = new TextField();
			HBox carRentalHBox = new HBox(10,carRentalLabel,carRentalText);
			carRentalHBox.setAlignment(Pos.CENTER_LEFT);
			
			Label milesDrivenLabel = new Label("Miles Driven:");
			TextField milesDrivenText = new TextField();
			HBox milesDrivenHBox = new HBox(10,milesDrivenLabel,milesDrivenText);
			milesDrivenHBox.setAlignment(Pos.CENTER_LEFT);
			
			Label parkingFeesLabel = new Label("Parking Fees:");
			TextField parkingFeesText = new TextField();
			HBox parkingFeesHBox = new HBox(10,parkingFeesLabel,parkingFeesText);
			parkingFeesHBox.setAlignment(Pos.CENTER_LEFT);
			
			Label taxiChargesLabel = new Label("Taxi Fees:");
			TextField taxiChargesText = new TextField();
			HBox taxiChargesHBox = new HBox(10,taxiChargesLabel,taxiChargesText);
			taxiChargesHBox.setAlignment(Pos.CENTER_LEFT);
			
			Label registrationFeesLabel = new Label("Registration Fees:");
			TextField registrationFeesText = new TextField();
			HBox registrationFeesHBox = new HBox(10,registrationFeesLabel,registrationFeesText);
			registrationFeesHBox.setAlignment(Pos.CENTER_LEFT);
			
			Label nightlyLodgingFeesLabel = new Label("Nightly Lodging Fees:");
			TextField nightlyLodgingFeesText = new TextField();
			HBox nightlyLodgingFeesHBox = new HBox(10,nightlyLodgingFeesLabel,nightlyLodgingFeesText);
			nightlyLodgingFeesHBox.setAlignment(Pos.CENTER_LEFT);
			
			
			Label totalExpensesLabel = new Label("TotalExpenses:");
			Label allowableExpensesLabel = new Label("Allowable Expenses:");
			Label excessExpensesLabel = new Label("Excess Expenses:");
			Label savedExpensesLabel = new Label("Saved Expenses:");
			
			Button calculateButton = new Button("Calculate");
			HBox calButtonHBox = new HBox(10,calculateButton);
			calButtonHBox.setAlignment(Pos.CENTER);
			
			VBox verticalBox = new VBox(10, daysHBox,airfareHBox,carRentalHBox,milesDrivenHBox,parkingFeesHBox,taxiChargesHBox,registrationFeesHBox,nightlyLodgingFeesHBox,totalExpensesLabel,allowableExpensesLabel,excessExpensesLabel,savedExpensesLabel,calButtonHBox);
			verticalBox.setPadding(new Insets(10, 10, 10, 10));
			
			calculateButton.setOnAction(event ->
			{
				final double PER_MEAL = 38.0,
						PER_PARKING = 25.0,
						PER_TAXI = 49.0,
						PER_LODGING = 215.0,
						PER_MILE = 0.49;
				
				double days = Double.parseDouble(daysText.getText()),
						airfare = Double.parseDouble(airfareText.getText()),
							carRental = Double.parseDouble(carRentalText.getText()),
								milesdriven = Double.parseDouble(milesDrivenText.getText()),
									parkingFees = Double.parseDouble(parkingFeesText.getText()),
										taxiCharges = Double.parseDouble(taxiChargesText.getText()),
											registrationFees = Double.parseDouble(registrationFeesText.getText()),
												lodgingFees = Double.parseDouble(nightlyLodgingFeesText.getText()),
													foodCharges = PER_MEAL * days;
								
				double totalExpenses = 0.0,
						totalAllowable = 0.0,
								excessAmount = 0.0,
										savedAmount = 0.0;
				
				totalExpenses = airfare + carRental + (milesdriven * PER_MILE)  + parkingFees + taxiCharges + registrationFees + (lodgingFees * days) + foodCharges;
				totalAllowable = (days * PER_LODGING) + airfare + carRental + (milesdriven * PER_MILE)  + (days * PER_PARKING) + (days * PER_TAXI) + foodCharges + registrationFees;
				
				excessAmount = totalExpenses - totalAllowable;
				
				if (excessAmount < 0.0001)
				{
					excessAmount = 0.0;	
				}
				
				savedAmount = totalAllowable - totalExpenses;
				
				if (savedAmount < 0.0001)
				{
					savedAmount = 0.0;
				}
				
				totalExpensesLabel.setText(String.format("Total Expenses: $%.2f", totalExpenses));
				allowableExpensesLabel.setText(String.format("Allowable Expenses: $%.2f", totalAllowable));
				excessExpensesLabel.setText(String.format("Excess Expenses: $%.2f", excessAmount));
				savedExpensesLabel.setText(String.format("Saved Expenses: $%.2f", savedAmount));
			});
			
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
