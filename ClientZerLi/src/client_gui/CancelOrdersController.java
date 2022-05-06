package client_gui;

import entities.ItemInCart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CancelOrdersController {

    @FXML
    private TableColumn<?, ?> OrderDateColTbl;

    @FXML
    private TableColumn<?, ?> OrderNumberColTbl;

    @FXML
    private TableColumn<?, ?> PriceColTbl;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button logOutBtn;

    @FXML
	private TableView<ItemInCart> table;

	ObservableList<ItemInCart> listView = FXCollections.observableArrayList();
	
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CancelOrders.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cancel Orders Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
    
    @FXML
    void CancelOrder(ActionEvent event) {

    }

    @FXML
    void logOut(ActionEvent event) {

    }

}
