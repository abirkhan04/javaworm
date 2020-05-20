package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			Line line = new Line();
			line.setStartX(20.0);
			line.setStartY(220.0);
			line.setEndX(380.0);
			line.setEndY(220.0);

			Text text = new Text();
			text.setFont(Font.font("verdana", FontWeight.BOLD, 20));
			text.setFill(Color.CYAN);
			text.setX(60);
			text.setY(200);
			text.setText("Welcome to Javaworm");

			BorderPane root = new BorderPane();
			ObservableList<Node> list = root.getChildren();
			list.add(line);
			list.add(text);
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Demo Application");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
