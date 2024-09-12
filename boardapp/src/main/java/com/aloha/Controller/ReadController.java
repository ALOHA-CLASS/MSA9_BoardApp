package com.aloha.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.aloha.App;
import com.aloha.DTO.Board;
import com.aloha.Service.BoardService;
import com.aloha.Service.BoardServiceImpl;

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
    private Button btnDel;

    @FXML
    private Label upd_date;


    @FXML
    private Label writer;

    BoardService boardService = new BoardServiceImpl(); 
    Board board;
    int boardNo;

    @FXML
    public void initialize() {
        System.out.println("조회 : boardNo : " + this.boardNo);
        Board board = boardService.select(this.boardNo);

		title.setText(board.getTitle());
		writer.setText(board.getWriter());
		content.setText(board.getContent());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(board.getUpdDate()==null) {
            upd_date.setText("수정일 없음");
        }
        else {
            upd_date.setText(dateFormat.format(board.getUpdDate()));
        }
        // reg_date.setText(dateFormat.format(board.getRegDate()));

    }

    @FXML
    void back(ActionEvent event) throws Exception {
        App.setRoot("UI/List");
    }

    @FXML
    void update(ActionEvent event) throws Exception {
        String fxml = "UI/Update";
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		Parent root = fxmlLoader.load();
		UpdateController updateController = (UpdateController) fxmlLoader.getController();
		updateController.passData(boardNo);
		
		App.setRoot(root);
    }

    public void passData(int boardNo) throws IOException {
		this.boardNo = boardNo;

        System.out.println("조회 : boardNo : " + this.boardNo);
        Board board = boardService.select(this.boardNo);

		title.setText(board.getTitle());
		writer.setText(board.getWriter());
		content.setText(board.getContent());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(board.getUpdDate()==null) {
            upd_date.setText("수정일 없음");
        }
        else {
            upd_date.setText(dateFormat.format(board.getUpdDate()));
        }
		
	}

    public void passData1(Board currentboard) {
		this.board = currentboard;
		title.setText(currentboard.getTitle());
    	content.setText(currentboard.getContent());
    	writer.setText(currentboard.getWriter());

    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	reg_date.setText(dateFormat.format(currentboard.getRegDate()));
        upd_date.setText(dateFormat.format(currentboard.getUpdDate()));
        if(currentboard.getUpdDate()==null) {
        	upd_date.setText("수정일 없음");
        }
        else {
        	upd_date.setText(dateFormat.format(currentboard.getUpdDate()));
        }
    	
	}

    @FXML
    void toDel(ActionEvent event) throws Exception {
        boardService.delete(boardNo);
        App.setRoot("UI/List");
    }
}
