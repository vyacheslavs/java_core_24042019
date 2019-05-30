package Lesson_7.Client;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    @FXML
    TextField textField;

    @FXML
    VBox msg_container;

    @FXML
    ScrollPane spane;

    @FXML
    VBox body;

    @FXML
    Button btn1;

    @FXML
    TextField usernameField;

    @FXML
    TextField passwordField;

    @FXML
    Text errmsg;

    @FXML
    VBox vbpane;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADRESS = "localhost";
    final int    PORT = 10000;

    public void sendMsg(String msg) {
        if (msg.isEmpty())
            return;

        Label chatMessage = new Label(msg);
        chatMessage.getStyleClass().add("chat-bubble");
        chatMessage.setWrapText(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                msg_container.getChildren().add(chatMessage);
                msg_container.autosize();
                msg_container.layout();
                spane.setVvalue(Double.MAX_VALUE);
            }
        });
    }

    public void tryAuth() {
        try {
            out.writeUTF(String.format("/auth %s %s", usernameField.getText(), passwordField.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(textField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

        textField.clear();
        textField.requestFocus();
    }

    public void chatMainCycle() {
        
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String msg = in.readUTF();

                            if (msg.startsWith("/authfail")) {
                                errmsg.setVisible(true);
                                continue;
                            }

                            if (msg.startsWith("/authok")) {

                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        body.getChildren().remove(vbpane);
                                    }
                                });

                                textField.visibleProperty().setValue(true);
                                btn1.visibleProperty().setValue(true);
                                continue;
                            }

                            sendMsg(msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        msg_container.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                spane.setVvalue((Double)newValue);
            }
        });

        textField.visibleProperty().setValue(false);
        btn1.visibleProperty().setValue(false);

        chatMainCycle();
    }
}
