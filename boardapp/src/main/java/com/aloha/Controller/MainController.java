package com.aloha.Controller;

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
	private AnchorPane anchorpane;
    // AnchorPane 요소

    @FXML   // 나가기 버튼 동작
    void exit(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("프로그램 종료");
		alert.setHeaderText("프로그램 끝");
		alert.setContentText("진짜로?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            // Stage 객체를 로컬 변수로 선언
			Stage stage = (Stage) anchorpane.getScene().getWindow();
			System.out.println("프로그램 종료.");
			stage.close();
		}
    }

    @FXML   // 리스트 버튼 동작
    void toList(ActionEvent event) throws Exception {
        // 화면을 'UI/List'로 전환
        App.setRoot("UI/List");
    }
}   

    

