package com.wellread4man.instantmessagingclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.ChatListCell;
import service.TransmitImpl;

import java.io.File;
import java.io.IOException;



public class Main {
    @FXML
    public TextField username;
    public ListView chatListView;
    @FXML
    public ListView<String> contactListView;
    public Button file;
    @FXML
    private TextField message;
    TransmitImpl transmit=null;
    @FXML
    void onSendClick(MouseEvent event) {
        String selectedContact = contactListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedContact);
        transmit.sendMessage(selectedContact,message.getText());
    }

    public void handleContactDoubleClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            String selectedContact = contactListView.getSelectionModel().getSelectedItem();
            System.out.println("双击联系人：" + selectedContact);
            // 在这里进行后续操作
//            getChatHistory(selectedContact);
        }
    }
    public void setUserInfo(String name1){
        username.setText(name1);
    }
    private void getChatHistory(String contact) {
        // 根据联系人获取消息记录的逻辑
        // 在这里根据contact执行相关操作，例如从数据库或其他数据源获取与所选联系人相关的消息记录
        // 然后可以将消息记录显示在另一个控件中，如TextArea或ListView
        // 你可以根据具体需求自行实现获取消息记录的逻辑
    }
    public void initialize() {
        // 设置单元格工厂来自定义列表项的外观和布局
        chatListView.setCellFactory(listView -> new ChatListCell());

        // 添加聊天记录数据
        chatListView.getItems().addAll(
//                new ChatMessage("Alice", "Hello!", LocalDateTime.of(2023, 1, 1, 10, 0)),
//                new ChatMessage("Bob", "Hi Alice!", LocalDateTime.of(2023, 1, 1, 10, 5)),
//                new ChatMessage("Alice", "How are you?", LocalDateTime.of(2023, 1, 1, 10, 10)),
//                new ChatMessage("Bob", "I'm good, thanks!", LocalDateTime.of(2023, 1, 1, 10, 15))
        );
    }
    // 点击文件图标的事件处理函数
    @FXML
    private void handleFileIconClick(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择文件");

        // 设置文件选择的起始目录（可选）
        fileChooser.setInitialDirectory(new File("."));

        // 添加文件类型过滤器（可选）
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("所有文件", "*.*"),
                new FileChooser.ExtensionFilter("文本文件", "*.txt"),
                new FileChooser.ExtensionFilter("图像文件", "*.png", "*.jpg", "*.gif")
                // 添加更多的文件类型过滤器...
        );

        // 显示文件选择对话框
        Stage stage = (Stage) file.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        // 处理选择的文件
        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            String selectedContact = contactListView.getSelectionModel().getSelectedItem();
            // 执行文件发送操作，将 filePath 作为文件路径传递给发送函数
            message.setText(filePath);
            transmit.sendFile(selectedContact,filePath);
        }
    }

}
