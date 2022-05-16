package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import client.ClientUI;
import communication.Mission;
import communication.Response;
import communication.TransmissionPack;
import entities_general.Order;
import entities_general.OrderPrivew;
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
	private TableView<OrderPrivew> Orders;

	@FXML
	private TableColumn<OrderPrivew, String> branchIDCol;

	@FXML
	private TableColumn<OrderPrivew, String> customerIDCol;

	@FXML
	private TableColumn<OrderPrivew, String> expectedDeliveryCol;

	@FXML
	private TableColumn<OrderPrivew, String> orderDateCol;

	@FXML
	private TableColumn<OrderPrivew, String> orderIDCol;

	@FXML
	private TableColumn<OrderPrivew, String> priceCol;

	@FXML
	private TableColumn<OrderPrivew, Button> showCol;

	@FXML
	private TableColumn<OrderPrivew, ComboBox<OrderStatus>> statusCol;

	private ObservableList<OrderPrivew> listView = FXCollections.observableArrayList();

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
		showCol.setCellFactory(ShowButtonTableCell.<OrderPrivew>forTableColumn("Details", (OrderPrivew o) -> {

			// need to send list to screen
			// ObservableList<Product>
			// listToNextScreen=FXCollections.observableArrayList(o.getItems());

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

		statusCol.setCellValueFactory(new PropertyValueFactory<OrderPrivew, ComboBox<OrderStatus>>("comboStatus"));
		orderIDCol.setCellValueFactory(new PropertyValueFactory<OrderPrivew, String>("orderID"));
		customerIDCol.setCellValueFactory(new PropertyValueFactory<OrderPrivew, String>("customerID"));
		branchIDCol.setCellValueFactory(new PropertyValueFactory<OrderPrivew, String>("branchID"));
		priceCol.setCellValueFactory(new PropertyValueFactory<OrderPrivew, String>("price"));
		orderDateCol.setCellValueFactory(new PropertyValueFactory<OrderPrivew, String>("orderDate"));
		expectedDeliveryCol.setCellValueFactory(new PropertyValueFactory<OrderPrivew, String>("expectedDelivery"));

//		

		listView.addAll(ClientHandleTransmission.getListOrderPrivew());
		Orders.setItems(listView);

	}


}
