package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {

	Button button;
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Title");
		this.button = new Button();
		this.button.setText("Click Me And Do Nothing");
		StackPane layout = new StackPane();
		layout.getChildren().add(this.button);
		Scene scene = new Scene(layout, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
