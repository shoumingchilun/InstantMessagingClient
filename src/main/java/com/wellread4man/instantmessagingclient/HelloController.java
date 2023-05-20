package com.wellread4man.instantmessagingclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import util.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Utils.init();
        ClientLoginImpl clientLogin = new ClientLoginImpl("chilun1", "123456", new RollBackImpl());
        Thread thread = new Thread(clientLogin);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TCPTransmitSend tcpTransmit = new TCPTransmitSend("你好", "chilun2");
        Thread thread2 = new Thread(tcpTransmit);
        thread2.start();
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onHelloButtonClick2(ActionEvent event) {
        Utils.init();
        ClientLoginImpl clientLogin = new ClientLoginImpl("chilun2", "123456", new RollBackImpl());
        Thread thread = new Thread(clientLogin);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}