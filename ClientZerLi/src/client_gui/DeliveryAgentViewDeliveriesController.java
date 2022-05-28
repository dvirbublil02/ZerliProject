package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import entities_catalog.ProductInOrder;
import entities_general.Deliveries;
import entities_general.DeliveryPreview;
import entities_general.Order;
import enums.DeliveryStatus;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DeliveryAgentViewDeliveriesController implements Initializable {

	@FXML
	private TableView<DeliveryPreview> deliveriesTable;

	@FXML
	private TableView<DeliveryPreview> datesTable;

	@FXML
	private TableColumn<DeliveryPreview, Integer> deliveryIDCol;

	@FXML
	private TableColumn<DeliveryPreview, String> orderIDCol;

	@FXML
	private TableColumn<DeliveryPreview, String> customerIDCol;

	@FXML
	private TableColumn<DeliveryPreview, String> branchIDCol;

	@FXML
	private TableColumn<DeliveryPreview, Double> priceCol;

	@FXML
	private TableColumn<DeliveryPreview, String> orderDateCol;

	@FXML
	private TableColumn<DeliveryPreview, String> expectedDeliveryCol;

	@FXML
	private TableColumn<DeliveryPreview, String> arrivedDateCol;

	@FXML
	private TableColumn<DeliveryPreview, String> receiverNameCol;

	@FXML
	private TableColumn<DeliveryPreview, String> phoneNumberCol;

	@FXML
	private TableColumn<DeliveryPreview, ComboBox<DeliveryStatus>> statusCol;

	@FXML
	private TableColumn<DeliveryPreview, String> deliveryIDdatesTable;

	@FXML
	private Button BackBtn;

	@FXML
	private Button showOrderBtn;

	@FXML
	private Button updateBtn;

	@FXML
	private Label networkManagerName;

	@FXML
	private Label branchNameLbl;

	@FXML
	private Label phoneNumber;

	@FXML
	private Label userRole;

	@FXML
	private Label userStatus;

	@FXML
	private Label welcomeBackUserName;

	ObservableList<DeliveryPreview> deliveriesView = FXCollections.observableArrayList();
	ObservableList<DeliveryPreview> dates = FXCollections.observableArrayList();

	List<Deliveries> deliveriesList;
	List<ProductInOrder> orderProducts;
	DeliveryPreview currDelivery = null;

	/**
	 * @param stage
	 * @throws IOException
	 */
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/DeliveryAgentViewDeliveries.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Delivery Agent View Delivieries");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showOrderBtn.setDisable(true);
		deliveryIDCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, Integer>("deliveryID"));
		orderIDCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, String>("orderID"));
		customerIDCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, String>("customerID"));
		priceCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, Double>("price"));
		receiverNameCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, String>("receiverName"));
		phoneNumberCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, String>("phoneNumber"));
		statusCol.setCellValueFactory(
				new PropertyValueFactory<DeliveryPreview, ComboBox<DeliveryStatus>>("deliveryStatusComboBox"));
		/*
		 * get the deliveries from the DB and add them to list that we will present in
		 * the table view
		 */
		deliveriesList = ClientHandleTransmission.getDeliveries();
		for (Deliveries delivery : deliveriesList) {
			deliveriesView.add(new DeliveryPreview(delivery.getDeliveryID(), delivery.getOrderID(),
					delivery.getBranchID(), delivery.getCustomerID(), delivery.getPrice(), delivery.getOrderDate(),
					delivery.getExpectedDelivery(), delivery.getArrivedDate(), delivery.getReceiverName(),
					delivery.getPhoneNumber(), delivery.getDeliveryStatus(), delivery.getOrderProducts()));
			System.out.println(delivery); // check
		}
		deliveriesTable.setItems(deliveriesView);
		
		deliveryIDdatesTable.setCellValueFactory(new PropertyValueFactory<>("deliveryID"));
		orderDateCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, String>("orderDate"));
		expectedDeliveryCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, String>("expectedDelivery"));
		arrivedDateCol.setCellValueFactory(new PropertyValueFactory<DeliveryPreview, String>("arrivedDate"));
		
	}

	@FXML
	void ShowOrder(ActionEvent event) throws IOException {
		
		Stage primaryStage = new Stage();
		DeliveryAgentViewOrderController deliveryAgentViewOrderController = new DeliveryAgentViewOrderController();
		deliveryAgentViewOrderController.start(primaryStage);
		
	}

	@FXML
	void Update(ActionEvent event) {

	}

	/**
	 * while pointing on specific delivery we hold its details and can open a window
	 * with the order items
	 * 
	 * @param event
	 */
	@FXML
	void ChooseDelivery(MouseEvent event) {
		try {
			if (dates.size() > 0)
				dates.clear();
			currDelivery = deliveriesTable.getSelectionModel().getSelectedItem();
			if (currDelivery != null)
				showOrderBtn.setDisable(false);
			dates.add(currDelivery);
			System.out.println(dates);
			datesTable.setItems(dates);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		DeliveryAgentPageController deliveryAgentPageController = new DeliveryAgentPageController();
		deliveryAgentPageController.start(primaryStage);
	}

}
