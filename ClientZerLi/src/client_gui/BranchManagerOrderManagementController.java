package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import client.OrderHandleController;
import communication.Response;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * this class is handle the branch manager order screen controller the branch
 * manager can approve or cancel the request
 * 
 * @author Mor Ben Haim
 * @author Dvir Bublil
 *
 */
public class BranchManagerOrderManagementController implements Initializable {

	@FXML
	private Button Back;
	@FXML
    private Label upadteFeedBack;

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
		primaryStage.setTitle("Order Management");
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

	/**
	 * initialize the order page that is in pending status
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// show button function
		showCol.setCellFactory(ShowButtonTableCell.<OrderPreview>forTableColumn("+", (OrderPreview o) -> {

			// need to send list to screen
			// ObservableList<Product>
			// listToNextScreen=FXCollections.observableArrayList(o.getItems());

			List<OrderPreview> details = OrderHandleController.getOrdersForBranchManager();
			for (OrderPreview or : details) {
				if (or.equals(o)) {
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
	
	/**
	 * send mission to the server for updating the orders state
	 * @param event
	 */
	@FXML
	void updateBtn(ActionEvent event) {
		List<OrderPreview>orderPreview=OrderHandleController.getOrdersForBranchManager();
		List<Order>order=new ArrayList<>();
		for(OrderPreview or:orderPreview) {
			Order o=new Order(or.getOrderID(), or.getCustomerID(), or.getBranchID(), or.getPrice(), or.getGreetingCard(), or.getOrderDate(), or.getExpectedDelivery(), or.getItems());
			o.setStatus(or.getComboStatus().getValue());
			order.add(o);
		}
		if(ClientHandleTransmission.updateOrders(order)==Response.UPDATE_ORDER_SUCCEED) {
			upadteFeedBack.setText("Update Succeed");
			upadteFeedBack.setTextFill(Color.GREEN);
			
		}else {
			upadteFeedBack.setText("Update Failed");
			upadteFeedBack.setTextFill(Color.RED);
		}
	}

}
