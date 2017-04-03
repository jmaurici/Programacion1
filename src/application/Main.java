package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage escenario) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

			Scene scene = new Scene(root, 640, 580);
			escenario.setScene(scene);
			escenario.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
