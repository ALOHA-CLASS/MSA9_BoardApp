package com.aloha.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.aloha.App;
import com.aloha.DTO.Board;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ReadController {

    @FXML
    private TextArea content;

    @FXML
    private Label reg_date;

    @FXML
    private Label title;

    @FXML
    private Button toBoard;

    @FXML
    private Button toUpdate;

    @FXML
    private Label upd_date;

    @FXML
    private Label writer;

    int boardNo;

    @FXML
    void back(ActionEvent event) throws IOException {
        App.setRoot("UI/List");
    }

    @FXML
    void update(ActionEvent event) {
        String fxml = "UI/Update";
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		Parent root = fxmlLoader.load();
		UpdateController changeController = (UpdateController)fxmlLoader.getController();
		UpdateController.passData(boardNo);
		
		App.setRoot(root);
    }

    public void passData(int boardNo) throws IOException {
		this.boardNo = boardNo;
		Board board = boardService.select(boardNo);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
		title.setText(board.getTitle());
		writer.setText(board.getWriter());
		content.setText(board.getContent());
        reg_date.setText(sdf.format(board.getRegDate()));
        upd_date.setText(sdf.format(board.getUpdDate()));
	}

}
