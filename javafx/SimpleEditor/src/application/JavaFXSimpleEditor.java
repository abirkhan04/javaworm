package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class JavaFXSimpleEditor extends Application {

	private Stage primaryStage;
	private TextArea text;
	private long textSize = 0;
	File mainFile;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		BorderPane root = new BorderPane();
		MenuBar topMenu = new MenuBar();
		topMenu.prefWidthProperty().bind(primaryStage.widthProperty());
		root.setTop(topMenu);

		Menu fileMenu = new Menu("File");
		MenuItem newMenu = new MenuItem("New");
		MenuItem openMenu = new MenuItem("Open");
		MenuItem saveMenu = new MenuItem("Save ");
		MenuItem saveAsMenu = new MenuItem("Save As..");
		MenuItem exitMenu = new MenuItem("Exit");
		fileMenu.getItems().addAll(newMenu, openMenu, saveMenu, saveAsMenu, new SeparatorMenuItem(), exitMenu);

		Menu editMenu = new Menu("Edit");
		MenuItem undoMenu = new MenuItem("Undo");
		MenuItem cutMenu = new MenuItem("Cut");
		MenuItem copyMenu = new MenuItem("Copy");
		MenuItem pasteMenu = new MenuItem("Paste");
		MenuItem deleteMenu = new MenuItem("Delete");
		MenuItem selectAllMenu = new MenuItem("Select All");
		editMenu.getItems().addAll(undoMenu, new SeparatorMenuItem(), cutMenu, copyMenu, pasteMenu, deleteMenu,
				new SeparatorMenuItem(), selectAllMenu);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutMenu = new MenuItem("About Textpad");
		helpMenu.getItems().addAll(aboutMenu);
		topMenu.getMenus().addAll(fileMenu, editMenu, helpMenu);

		text = new TextArea();
		text.setPrefRowCount(15);
		text.setPrefColumnCount(150);
		text.setPrefWidth(200);
		text.setWrapText(true);

		text.textProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("Textfield Changed from " + oldValue + " to " + newValue);
			newValue = "2";
			text.setText(newValue);
		});

		undoMenu.setOnAction(event -> {
			text.undo();
		});

		copyMenu.setOnAction(event -> {
			text.copy();
		});

		cutMenu.setOnAction(event -> {
			text.cut();
		});

		pasteMenu.setOnAction(event -> {
			text.paste();
		});

		selectAllMenu.setOnAction(event -> {
			text.selectAll();
		});

		deleteMenu.setOnAction(event -> {
			IndexRange selection = text.getSelection();
			text.deleteText(selection);
		});

		aboutMenu.setOnAction(event -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About Textpad");
			alert.setHeaderText("Textpad by Javaworm");
			alert.setContentText("Textpad \nBuild by JavaFX \nBy Abir");
			alert.showAndWait();
		});

		exitMenu.setOnAction(actionEvent -> Platform.exit());
		newMenu.setOnAction((event) -> {
			if (!checkTextStatus())
				return;
			text.setText("");
			primaryStage.setTitle("Textpad by Javaworm");
			textSize = 0L;
			mainFile = null;
		});

		saveMenu.setOnAction((event) -> {
			save();
		});

		saveAsMenu.setOnAction((event) -> {
			saveAs();
		});

		openMenu.setOnAction((event) -> {
			if (!checkTextStatus())
				return;

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open a File");
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*", "*.txt", "*.java"));
			File file = fileChooser.showOpenDialog(primaryStage);
			if (file == null)
				return;

			mainFile = file;
			primaryStage.setTitle("Textpad by Javaworm | " + file.getName());
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				String everything = sb.toString();
				text.setText(everything);
				textSize = (int) text.getText().length();
				text.positionCaret((int) textSize);
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});

		root.setCenter(text);
		newMenu.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		openMenu.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		saveMenu.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		exitMenu.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
		undoMenu.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
		cutMenu.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
		copyMenu.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
		pasteMenu.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
		selectAllMenu.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
		deleteMenu.setAccelerator(new KeyCodeCombination(KeyCode.DELETE));

		Scene scene = new Scene(root, 800, 550);

		primaryStage.setOnCloseRequest((WindowEvent we) -> {
			if (!checkTextStatus())
				we.consume();
		});
		primaryStage.setTitle("Textpad by Javaworm");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void save() {
		if (mainFile == null)
			saveAs();
		else {
			saveFile(mainFile);
		}
	}

	private void saveAs() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("*", "*.txt", "*.java");
		fileChooser.getExtensionFilters().add(extFilter);
		fileChooser.setTitle("Save File");
		File file = fileChooser.showSaveDialog(primaryStage);
		if (file == null)
			return;
		mainFile = file;
		saveFile(file);
	}

	private void saveFile(File file) {
		primaryStage.setTitle("TextPad " + file.getName());
		textSize = (long) text.getText().length();
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))) {
			String[] split = text.getText().split("\n");
			for (String string : split) {
				writer.append(string);
				writer.append(System.lineSeparator());
			}
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private boolean checkTextStatus() {
		if (textSize != text.getText().length()) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
			alert.setTitle("Textpad ... ");
			alert.setHeaderText("Do You want to save changes ?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.YES) {
				save();
			} else if (result.get() == ButtonType.CANCEL) {
				return false;
			}
		}
		return true;
	}

}
