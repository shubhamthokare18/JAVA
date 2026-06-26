package com.eidiko.snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Snake Game Application - Production-level main entry point
 */
public class SnakeApplication extends Application {
    private static final String APP_TITLE = "Snake Game";
    private static final int WINDOW_WIDTH = 440;
    private static final int WINDOW_HEIGHT = 460;
    private static final String FXML_RESOURCE = "hello-view.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SnakeApplication.class.getResource(FXML_RESOURCE));
            Scene scene = new Scene(fxmlLoader.load(), WINDOW_WIDTH, WINDOW_HEIGHT);
            
            // Configure window
            stage.setTitle(APP_TITLE);
            stage.setScene(scene);
            stage.setResizable(false); // Prevent resizing for stable gameplay
            
            // Get controller and set up event handlers
            SnakeController controller = fxmlLoader.getController();
            scene.setOnKeyPressed(controller::handleKeyPressed);
            
            // Clean up resources on close
            stage.setOnCloseRequest(event -> controller.shutdown());
            
            stage.show();
            stage.requestFocus(); // Ensure focus for keyboard input
        } catch (Exception e) {
            System.err.println("Failed to start application: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}