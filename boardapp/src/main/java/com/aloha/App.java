package com.aloha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("UI/Main"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws Exception {
		scene.setRoot(loadFXML(fxml));
	}
	
	public static void setRoot(Parent root) throws Exception {
		scene.setRoot(root);
	}
	
	public static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}
	
	public static void exit() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}


    public static void main(String[] args) {
        launch();
    }

}