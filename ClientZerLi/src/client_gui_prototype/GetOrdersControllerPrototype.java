package client_gui_prototype;

import java.net.URL;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import entities_general.Order;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/** In this class we handling with the get order and the edit screen ( all their operations) 
 *
 *
 */
public class GetOrdersControllerPrototype implements Initializable {
	@FXML
	private TableColumn<Order, String> ColorColTbl;

	@FXML
	private TableColumn<Order, String> OrderNameColTbl;

	@FXML
	private TableColumn<Order, String> PriceColTbl;

	@FXML
	private Button backBtn;

	@FXML
	private TableColumn<Order, String> dOrderColTbl;

	@FXML
	private TableColumn<Order, String> dateColTbl;

	@FXML
	private Button editOrderBtn;

	@FXML
	private Button getOrdersBtn;

	@FXML
	private TableColumn<Order, String> greetingCardColTbl;

	@FXML
	private TableColumn<Order, String> orderDateColTbl;

	@FXML
	private TableColumn<Order, String> shopColTbl;

	@FXML
	private TableView<Order> table;

	@FXML
	private TextField lblEditColor;

	@FXML
	private TextField lblEditDate;
	@FXML
	private Label statusLabel;
	@FXML
	private TextField lblEditOrderNumber;

	ObservableList<Order> listView = FXCollections.observableArrayList();

	/** in this method we loading the Get orders, edit screen
	 * @param primaryStage
	 * @throws Exception
	 */
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/GetOrders.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("ZerLi GetOrders");
		primaryStage.setScene(scene);

		primaryStage.show();
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});
	}

	/**in this method we initialize the TableView by using observable listView and , PrototypeCLass
	 * that contains the SQL item schema (format)
	 *
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		OrderNameColTbl.setCellValueFactory(new PropertyValueFactory<Order, String>("orderNumber"));
		PriceColTbl.setCellValueFactory(new PropertyValueFactory<Order, String>("price"));
		greetingCardColTbl.setCellValueFactory(new PropertyValueFactory<Order, String>("greetingCard"));
		ColorColTbl.setCellValueFactory(new PropertyValueFactory<Order, String>("color"));
		dOrderColTbl.setCellValueFactory(new PropertyValueFactory<Order, String>("dorder"));
		shopColTbl.setCellValueFactory(new PropertyValueFactory<Order, String>("shop"));
		dateColTbl.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
		orderDateColTbl.setCellValueFactory(new PropertyValueFactory<Order, String>("orderDate"));
	}

	/** In this method we handling with the back button click , we loading the previous screen
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		MenuPageControllerPrototype menuPage = new MenuPageControllerPrototype();
		menuPage.start(primaryStage);
	}

	/**In this method we handling with the getOrder click , we using the class(ClientHandleTransmission) that handling with the 
	 * operation
	 * @param event
	 */
	@FXML
	void GetOrders(ActionEvent event) {
		ClientHandleTransmission.GET_ORDERS(listView, table, statusLabel);
	}

	/**In this method we handling with the EditOrder click , we using the class(ClientHandleTransmission) that handling with the 
	 * operation
	 * @param event
	 */
	@FXML
	void EditOrder(ActionEvent event) {

		//ClientHandleTransmission.EDIT_ORDER(statusLabel, lblEditColor, lblEditDate, lblEditOrderNumber);
	}

}