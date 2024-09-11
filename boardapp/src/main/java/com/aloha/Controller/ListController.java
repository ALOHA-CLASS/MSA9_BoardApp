package com.aloha.Controller;

import java.io.IOException;
import java.util.List;

import com.aloha.App;
import com.aloha.DTO.Board;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListController {

    @FXML
    private TableView<Board> boardTableView;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnMain;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colNo;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableColumn<?, ?> colView;

    @FXML
    private TableColumn<?, ?> colWriter;



    static List<Board> boardList = null;
	
	Board currentBoard = new Board();
	
	public BoardService boardService = new BoardServiceimpl();


    @FXML
    public void initialize() {
		boardList = boardService.list();
		
		colNo.setCellValueFactory(new PropertyValueFactory<>("No"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colDate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
		
		
		ObservableList<Board> list = FXCollections.observableArrayList(boardList);
		
		boardTableView.setItems(list);
		
			boardTableView.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<Board>() {

			@Override
			public void changed(ObservableValue<? extends Board> arg0, Board arg1, Board arg2) {
				
				currentBoard = boardTableView.getSelectionModel().getSelectedItem();	// 선택된 항목
			}
    		
		});
		
	}

      

    @FXML
    void toInsert(ActionEvent event) {
        App.setRoot("com.aloha.UI.Update");

    }



    @FXML
    void toMain(ActionEvent event) {
        App.setRoot("com.aloha.UI.Main");
    }


 boardTableView.setOnMouseClicked(new EventHandler <MouseEvent>(){
	
	public void handle(MouseEvent event) {
		if(event.getClickCount() == 2) {
			currentBoard = boardTableView.getSelectionModel().getSelectedItem();
			try {
				FXMLLoader fxmlLoader = App.loadFXML("com.aloha.UI.List");
				Parent root = App.loadFXML("com.aloha.UI.List");
				//Parent root = fxmlLoader.load();
				ViewController viewController = fxmlLoader.getController();
				viewController.passDate(currentBoard);

				App.setRoot(root);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
}
	}
});



}