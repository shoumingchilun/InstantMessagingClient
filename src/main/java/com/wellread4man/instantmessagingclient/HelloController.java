package com.wellread4man.instantmessagingclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.TransmitImpl;
import service.transmit;
import util.*;

public class HelloController {

    @FXML
    private TextField FilePath;

    @FXML
    private TextField goalname;

    @FXML
    private Text logins;

    @FXML
    private TextField message;

    @FXML
    private TextField name;

    @FXML
    private Text others;

    @FXML
    private TextField password;

    @FXML
    private Label welcomeText;

    TransmitImpl transmit=null;

    @FXML
    void onLoginClick(ActionEvent event) {
        transmit= new TransmitImpl(new RollBack() {
            @Override
            public void LoginSuccess() {
                logins.setText("LoginSuccess");
            }

            @Override
            public void LoginFailure() {
                logins.setText("LoginFailure");
            }

            @Override
            public void getFriendsSuccess() {
                logins.setText(logins.getText()+"getFriendsSuccess");
            }

            @Override
            public void Receive(String name, String message) {
                others.setText(name+":"+message);
            }

            @Override
            public void ReceiveFile(String name, String filePath) {
                others.setText(name+":"+filePath);
            }
        });
        transmit.init();
        String name1 = name.getText();
        String password1 = password.getText();
        transmit.login(name1,password1);
    }

    @FXML
    void onSendClick(ActionEvent event) {
        transmit.sendMessage(goalname.getText(),message.getText());
    }

    @FXML
    void sendFile(ActionEvent event) {
        transmit.sendFile(goalname.getText(),FilePath.getText());
    }
}