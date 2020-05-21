package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Text text1 = new Text("Email");
		Text text2 = new Text("Password");

		TextField textField1 = new TextField();
		PasswordField textField2 = new PasswordField();

		Button button1 = new Button("Submit");
		Button button2 = new Button("Clear");

		GridPane gridPane = new GridPane();
		gridPane.setMinSize(400, 200);

		gridPane.setPadding(new Insets(10, 10, 10, 10));

		gridPane.setVgap(5);
		gridPane.setHgap(1);

		gridPane.setAlignment(Pos.CENTER);

		gridPane.add(text1, 0, 0);
		gridPane.add(textField1, 1, 0);
		gridPane.add(text2, 0, 1);
		gridPane.add(textField2, 1, 1);

		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(button2, button1);
		gridPane.add(hBox, 1, 2);

		button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

		text1.setStyle("-fx-font: normal bold 20px 'serif' ");
		text2.setStyle("-fx-font: normal bold 20px 'serif' ");
		gridPane.setStyle("-fx-background-color: BEIGE;");

		Scene scene = new Scene(gridPane);

		primaryStage.setTitle("CSS Example");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
