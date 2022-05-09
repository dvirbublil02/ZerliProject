package client_gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import entities_catalog.Cart;
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
	private TableColumn<Order, String> statusCol;

//	ComboBox<String> statusCheck;
//	
	ObservableList<String> listView; 
	
	

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
		 
//		 List<OrderStatus> accountStatus = new ArrayList<>();
//		 accountStatus.add(OrderStatus.ARRIVED);
//		 accountStatus.add(OrderStatus.ON_THE_WAY);
//		 accountStatus.add(OrderStatus.NOT_READY);
//		 accountStatus.add(OrderStatus.READY);
//		 List<String> list = new ArrayList<>();
//		 for(OrderStatus orderStatus : accountStatus) {
//			 int i = orderStatus.ordinal();
//			 list.add(accountStatus.get(i));
//		 }
		// statusList = FXCollections.observableArrayList(accountStatus);
		// statusCheck.setItems(statusList);
		 
		// statusCol = accountStatus.get(0);
		// statusCol.setCellValueFactory(new PropertyValueFactory<OrderStatus,List<OrderStatus>>("status"));
//		 
//		 listView = FXCollections.observableArrayList("NOT_READY","READY", "ARRIVED", "ON_THE_WAY");
//		 statusCheck.setItems(listView);
//		 
		 statusCol.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
		 orderIDCol.setCellValueFactory(new PropertyValueFactory<Order,String>("orderID"));
		 customerIDCol.setCellValueFactory(new PropertyValueFactory<Order,String>("customerID"));
		 branchIDCol.setCellValueFactory(new PropertyValueFactory<Order,String>("branchID"));
		 priceCol.setCellValueFactory(new PropertyValueFactory<Order,String>("price"));
		 orderDateCol.setCellValueFactory(new PropertyValueFactory<Order,String>("orderDate"));
		 expectedDeliveryCol.setCellValueFactory(new PropertyValueFactory<Order,String>("expectedDelivery"));
		 
		 listView.add(new Order("1", "315838540", "3", "99.5", null, OrderStatus.ARRIVED, "9.5.22-10:00", "10.5.22-10:00", null));

		 Orders.setItems(listView);
		 
		 //	ItemNameColTbl.setCellValueFactory(new PropertyValueFactory<Cart, String>("Name"));
//			PriceColTbl.setCellValueFactory(new PropertyValueFactory<Cart, Double>("Price"));
//			ImgColTbl.setCellValueFactory(new PropertyValueFactory<Cart, ImageView>("ImgSrc"));
//			QuantityColTbl.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("Quantity"));
//
//			
//		//	listView.add(new Cart("Rose Bouquet", imageView1, 22.55, 1));
//			table.setItems(listView);

		}
	 
	 
	 
}
