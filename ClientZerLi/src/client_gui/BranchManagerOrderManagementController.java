package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import entities_catalog.Cart;
import entities_catalog.Product;
import entities_general.Order;
import enums.AccountStatus;
import enums.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BranchManagerOrderManagementController implements Initializable {

	@FXML
	private Button Back;

	@FXML
	private TableView<Order> Orders;

	@FXML
	private TableColumn<Order, String> branchIDCol;

	@FXML
	private TableColumn<Order, String> customerIDCol;

	@FXML
	private TableColumn<Order, String> expectedDeliveryCol;

	@FXML
	private TableColumn<Order, String> orderDateCol;

	@FXML
	private TableColumn<Order, String> orderIDCol;

	@FXML
	private TableColumn<Order, String> priceCol;
	
    @FXML
    private TableColumn<Order,Button> showCol;

	@FXML
	private TableColumn<Order, ComboBox<OrderStatus>> statusCol;

	private ObservableList<Order> listView = FXCollections.observableArrayList(); 
	
	

	@FXML
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/RequestManagementPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add New Customer");
		primaryStage.setScene(scene);
		primaryStage.show();
//		primaryStage.setOnCloseRequest(event ->{
//		ClientHandleTransmission.DISCONNECT_FROM_SERVER();
//		});	
	}

	 @FXML
	    void Back(ActionEvent event) throws Exception {
	    	((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
			Stage primaryStage = new Stage();
			BranchManagerPageController branchManagerPage = new BranchManagerPageController();
			branchManagerPage.start(primaryStage);
	    }


	 @Override
		public void initialize(URL location, ResourceBundle resources) {
		 
		 //show button function
		 showCol.setCellFactory(ShowButtonTableCell.<Order>forTableColumn("Details", (Order o) -> {
			
			 
			// need to send list to screen  
			//ObservableList<Product> listToNextScreen=FXCollections.observableArrayList(o.getItems()); 
			
			//open screen of details -- > need to init before starting
			Stage primaryStage = new Stage();
			BranchManagerOrderDetailsController ordersDetails = new BranchManagerOrderDetailsController();
			try {
				ordersDetails.start(primaryStage);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			 return o; 
		    })); 
		 
		 statusCol.setCellValueFactory(new PropertyValueFactory<Order,ComboBox<OrderStatus>>("status"));
		 orderIDCol.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
		 customerIDCol.setCellValueFactory(new PropertyValueFactory<Order,String>("customerID"));
		 branchIDCol.setCellValueFactory(new PropertyValueFactory<Order,String>("branchID"));
		 priceCol.setCellValueFactory(new PropertyValueFactory<Order,String>("price"));
		 orderDateCol.setCellValueFactory(new PropertyValueFactory<Order,String>("orderDate"));
		 expectedDeliveryCol.setCellValueFactory(new PropertyValueFactory<Order,String>("expectedDelivery"));
		 
		 List<Order> orders = new ArrayList<>();
		 orders.add(new Order("1", "315838540", "3", "99.5", null , "9.5.22-10:00", "10.5.22-10:00", null));
		 listView.addAll(orders);
		 Orders.setItems(listView);
		 
		}
	 
	 
	 
}
