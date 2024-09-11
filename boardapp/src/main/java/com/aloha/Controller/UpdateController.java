package com.aloha.Controller;

import com.aloha.App;
import com.aloha.DTO.Board;
import com.aloha.Service.BoardService;
import com.aloha.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class UpdateController {
    public class ChangeController2 {

        @FXML
        private TextField updContent;

        @FXML
        private TextField updTitle;

        @FXML
        private TextField updWriter;

        int boardNo;

        private BoardService boardService = new BoardServiceImpl();

        @FXML
        void toBack(ActionEvent event) throws Exception {
            String fxml = "UI/Read";
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
            Parent root = fxmlLoader.load();
            ReadController changeController = (ReadController) fxmlLoader.getController();
            changeController.passData(boardNo);

            App.setRoot(root);
        }

        @FXML
        void toSave(ActionEvent event) throws Exception {
            Board board = new Board(updTitle.getText(), updWriter.getText(), updContent.getText());
            board.setNo(boardNo);
            int result = boardService.update(board);
            if (result > 0) {
                System.out.println("수정 완료!");
            }
            App.setRoot("UI/List");
        }

        public void passData(int boardNo) {
            this.boardNo = boardNo;
            Board board = boardService.select(boardNo);
            updTitle.setText(board.getTitle());
            updWriter.setText(board.getWriter());
            updContent.setText(board.getContent());
        }
    }
}
