module com.eidiko.snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.eidiko.snake to javafx.fxml;
    exports com.eidiko.snake;
}