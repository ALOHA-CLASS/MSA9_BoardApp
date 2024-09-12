package com.aloha.Controller;
import com.aloha.App;
import com.aloha.DTO.Board;
import com.aloha.Service.BoardService;
import com.aloha.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class CreateController {

    @FXML
    private TextArea content;

    @FXML
    private TextArea title;

    @FXML
    private TextArea writer;

    @FXML
    void create(ActionEvent event) throws Exception {
        Board board = new Board();
        board.setTitle(title.getText());
        board.setWriter(title.getText());
        board.setContent(title.getText());
        BoardService service = new BoardServiceImpl();
        service.insert(board);
        App.setRoot("UI/List");
    }

}