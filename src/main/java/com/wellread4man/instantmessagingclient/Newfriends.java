package com.wellread4man.instantmessagingclient;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.TransmitImpl;
import util.Utils;

public class Newfriends {
    @FXML
    public Button newgroup;

    public void newgroup(MouseEvent event) {
        try {
            // 加载主页面的FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("newgroup.fxml"));
            Parent root = loader.load();

            // 获取创建群组页面的控制器
            Newgroup newgroupController = loader.getController();

            Platform.runLater(() -> {
                // 创建新的场景和舞台
                Scene newgroupScene = new Scene(root);
                Stage newgroupStage = new Stage();
                newgroupStage.setScene(newgroupScene);
                newgroupStage.setTitle("创建群组页面");

                newgroupStage.show();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
