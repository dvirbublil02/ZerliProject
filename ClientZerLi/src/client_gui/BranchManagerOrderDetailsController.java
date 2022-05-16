package client_gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities_catalog.ProductInOrder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class BranchManagerOrderDetailsController{

    @FXML
    private TableView<?> Orders;

    @FXML
    private TableColumn<?, ?> branchIDCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private TableColumn<?, ?> productIDCol;

    @FXML
    private TableColumn<?, ?> quantityInCartCol;

    @FXML
    private TableColumn<?, ?> totalquantityCol;
    public static List<ProductInOrder>list=new ArrayList<>();;



	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/BranchManagerOrderDetails.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Order Details");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

}
