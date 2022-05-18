package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import client.OrderHandleController;
import entities_catalog.ProductInOrder;
import entities_general.OrderPreview;
import enums.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BranchManagerOrderDetailsController implements Initializable{

    @FXML
    private TableView<ProductInOrder> Orders;

    @FXML
    private TableColumn<ProductInOrder, String> branchIDCol;

    @FXML
    private TableColumn<ProductInOrder, String> nameCol;

    @FXML
    private TableColumn<ProductInOrder, Double> priceCol;

    @FXML
    private TableColumn<ProductInOrder, String> productIDCol;

    @FXML
    private TableColumn<ProductInOrder, Double> quantityInCartCol;

    @FXML
    private TableColumn<ProductInOrder, Double> totalquantityCol;
    
    @SuppressWarnings("unused")
	private ObservableList<ProductInOrder> listView = FXCollections.observableArrayList();



	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/BranchManagerOrderDetails.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Order Details");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		productIDCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, String>("iD"));
		nameCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, String>("name"));
		branchIDCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, String>("cartID"));
		totalquantityCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Double>("quantity"));
		quantityInCartCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Double>("productQuantityInOrder"));
		priceCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Double>("price"));
		OrderPreview order=OrderHandleController.getOrder();
		System.out.println(order.getItems());
		List<ProductInOrder>l=new ArrayList<>();
		for(String key:order.getItems().keySet()) {
			l.addAll(order.getItems().get(key));
		}
		System.out.println(l);
		
		System.out.println(OrderHandleController.getOrdersForBranchManager());
			listView.addAll(l);
			Orders.setItems(listView);
		
	}

}
