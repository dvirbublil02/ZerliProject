package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import client.ClientUI;
import client.OrderHandleController;
import communication.Mission;
import communication.Response;
import communication.TransmissionPack;
import entities_general.Order;
import entities_general.OrderPreview;
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
import javafx.stage.Stage;

public class BranchManagerOrderManagementController implements Initializable {

	@FXML
	private Button Back;

	@FXML
	private TableView<OrderPreview> Orders;

	@FXML
	private TableColumn<OrderPreview, String> branchIDCol;

	@FXML
	private TableColumn<OrderPreview, String> customerIDCol;

	@FXML
	private TableColumn<OrderPreview, String> expectedDeliveryCol;

	@FXML
	private TableColumn<OrderPreview, String> orderDateCol;

	@FXML
	private TableColumn<OrderPreview, String> orderIDCol;

	@FXML
	private TableColumn<OrderPreview, String> priceCol;

	@FXML
	private TableColumn<OrderPreview, Button> showCol;

	@FXML
	private TableColumn<OrderPreview, ComboBox<OrderStatus>> statusCol;

	private ObservableList<OrderPreview> listView = FXCollections.observableArrayList();

	@FXML
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/RequestManagementPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add New Customer");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
		});
	}

	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		BranchManagerPageController branchManagerPage = new BranchManagerPageController();
		branchManagerPage.start(primaryStage);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// show button function
		showCol.setCellFactory(ShowButtonTableCell.<OrderPreview>forTableColumn("Details", (OrderPreview o) -> {

			// need to send list to screen
			// ObservableList<Product>
			// listToNextScreen=FXCollections.observableArrayList(o.getItems());
			List<OrderPreview>details=OrderHandleController.getOrdersForBranchManager();
			for(OrderPreview or:details) {
				if(or.equals(o)) {
					OrderHandleController.setOrder(or);
					System.out.println(or);
					break;
				}
			}

			// open screen of details -- > need to init before starting
			Stage primaryStage = new Stage();
			BranchManagerOrderDetailsController ordersDetails = new BranchManagerOrderDetailsController();

			try {
//				ordersDetails.list.addAll(orderPrivie.getItems());
				ordersDetails.start(primaryStage);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return o;
		}));

		statusCol.setCellValueFactory(new PropertyValueFactory<OrderPreview, ComboBox<OrderStatus>>("comboStatus"));
		orderIDCol.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("orderID"));
		customerIDCol.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("customerID"));
		branchIDCol.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("branchID"));
		priceCol.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("price"));
		orderDateCol.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("orderDate"));
		expectedDeliveryCol.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("expectedDelivery"));

//		
		OrderHandleController.setOrdersForBranchManager(ClientHandleTransmission.getListOrderPreview());
		listView.addAll(OrderHandleController.getOrdersForBranchManager());
		Orders.setItems(listView);

	}


}
