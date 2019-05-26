package Lesson_6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    int chatWidth = 400;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.setId("pane");
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, chatWidth, 275));

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setY(bounds.getMinY());
        primaryStage.setX(bounds.getMaxX()-chatWidth);
        primaryStage.setHeight(bounds.getHeight());

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
