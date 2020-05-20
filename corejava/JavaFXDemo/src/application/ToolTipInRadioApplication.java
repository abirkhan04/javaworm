package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ToolTipInRadioApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Label label = new Label("Select Item ");
		label.setFont(new Font("Britanic Bold", 15));
		RadioButton rb1 = new RadioButton("Item1");
		rb1.setUserData("Item 1");
		RadioButton rb2 = new RadioButton("Item2");
		rb2.setUserData("Item 2");
		ToggleGroup group = new ToggleGroup();
		group.getToggles().addAll(rb1, rb2);

		group.selectedToggleProperty().addListener((value, oldValue, newValue) -> {
			if (group.getSelectedToggle() != null) {
				System.out.println("The selected value " + newValue.getUserData());
			}
		});

		Tooltip tooltip1 = new Tooltip("10");
		Tooltip tooltip2 = new Tooltip("20");

		rb1.setTooltip(tooltip1);
		rb2.setTooltip(tooltip2);

		VBox vBox = new VBox(12);
		vBox.setPadding(new Insets(15, 5, 5, 200));
		vBox.getChildren().addAll(label, rb1, rb2);

		Scene scene = new Scene(new Group(vBox), 600, 200, Color.ALICEBLUE);
		primaryStage.setTitle("Tooltip in Radio Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
