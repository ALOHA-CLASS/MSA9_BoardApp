package com.aloha.Controller;

import java.io.IOException;

import com.aloha.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController { 

    @FXML
    private Button btnExit;
    // 나가기 버튼

    @FXML
    private Button btnList;
    // 리스트 버튼

    @FXML
    private AnchorPane anchorPane;
    // AnchorPane 요소

    Stage stage;

    @FXML   // 나가기 버튼 동작
    void exit(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("프로그램 종료");
        alert.setHeaderText("프로그램 끝");
        alert.setContentText("진짜로?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            // Stage 객체를 로컬 변수로 선언
            stage = (Stage) anchorPane.getScene().getWindow();
            System.out.println("프로그램 종료.");
            stage.close();
        }
    }

@FXML
void toList(ActionEvent event) throws IOException {
    //App.setRoot("UI/List"); 이거 오류나서 변경
    try {
        App.setRoot("UI/List");
    } catch (Exception e) {
        System.err.println("오류납니다.");
        e.printStackTrace();
    }
}
}

