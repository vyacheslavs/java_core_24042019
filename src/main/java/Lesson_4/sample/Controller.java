package Lesson_4.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    TextField textField;

    @FXML
    VBox msg_container;

    public void sendMsg() {


        Label chatMessage = new Label(textField.getText());
        chatMessage.getStyleClass().add("chat-bubble");
        chatMessage.setWrapText(true);
        msg_container.getChildren().add(chatMessage);
        textField.clear();
        textField.requestFocus();

    }


}
