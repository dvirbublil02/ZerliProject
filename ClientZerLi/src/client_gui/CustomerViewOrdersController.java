package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import client.ClientController;
import client.ClientHandleTransmission;
import client.OrderHandleController;
import entities_general.Order;
import entities_general.OrderCustomCartPreview;
import entities_general.OrderPreview;
import entities_users.Customer;
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
import javafx.stage.Stage;

public class CustomerViewOrdersController implements Initializable{

    @FXML
    private TableColumn<OrderPreview, String> ViewBranchID;

    @FXML
    private TableColumn<OrderPreview, String> ViewExpectDel;

    @FXML
    private TableColumn<OrderPreview, Number> ViewPrice;

    @FXML
    private TableColumn<OrderPreview, String> VieworderDate;

    @FXML
    private TableColumn<OrderPreview, String> VieworderID;

    @FXML
    private TableColumn<OrderPreview, Button> Viewshow;

    @FXML
    private Label accountStatus;

    @FXML
    private Button backBtn;

    @FXML
    private TableColumn<OrderPreview, String> cancelBranchID;

    @FXML
    private TableColumn<OrderPreview, String> cancelExpectedDate;

    @FXML
    private TableColumn<OrderPreview, String> cancelOrderDate;

    @FXML
    private TableColumn<OrderPreview, String> cancelOrderID;

    @FXML
    private TableColumn<OrderPreview, Number> cancelPrice;

    @FXML
    private TableColumn<OrderPreview, Button> cancelShow;

    @FXML
    private Label employeeName;

    @FXML
    private Label employeeType;

    @FXML
    private Label massageLabelRemove;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label priceLabel;

    @FXML
    private Button removeCancelOrderBTN;

    @FXML
    private TableView<OrderPreview> tableCancelOrder;

    @FXML
    private TableView<OrderPreview> tableViewOrder;
    
    ObservableList<OrderPreview> cancelationOrdersPreview = FXCollections.observableArrayList();
    ObservableList<OrderPreview> historyOrdersPreview = FXCollections.observableArrayList();
    
    
	/**
	 * 
	 * @param primaryStage main of catalog screen
	 * @throws Exception if there is problem with start of this stage
	 */
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CustomerViewOrders.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("View Orders");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
		});
	}
    
    

    @FXML
    void back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CustomerPageController customerPage = new CustomerPageController();
		customerPage.start(primaryStage);
    }

    @FXML
    void cancelOrder(ActionEvent event) {

    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		/**
		 * bring side bar information to labels  
		 */
		ClientController.initalizeUserDetails(employeeName, phoneNumber, accountStatus, null, employeeType,
				((Customer) ClientController.user).toString());
					
		cancelOrderID.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("orderID"));
		cancelBranchID.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("branchID"));
		cancelPrice.setCellValueFactory(new PropertyValueFactory<OrderPreview, Number>("price"));
		cancelOrderDate.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("orderDate"));
		cancelExpectedDate.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("expectedDelivery"));
		cancelShow.setCellFactory(ShowButtonTableCell.<OrderPreview>forTableColumn("Details", (OrderPreview o) -> {

			if(!OrderHandleController.isDetailsAllreadyOpen2())
			{
				if(o != null && o.getItems() != null) {
					OrderHandleController.setCustomerOrderView(o);
					OrderHandleController.setCustomerOrderDetails(o.getItems());
				}
				else 
					throw new NullPointerException();
			
				// new windows add send him the productInOrder list with the info
				Stage primaryStage = new Stage();
				CustomerViewOrderDetailsController customViewOrderDetails = new CustomerViewOrderDetailsController();
				try {
					customViewOrderDetails.start(primaryStage);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("No items");
				}
			}
			else
			{
				System.out.println("details allreaday open popup");
			}
			
			return o;
		}));
		
		
		VieworderID.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("orderID"));
		ViewBranchID.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("branchID"));
		ViewPrice.setCellValueFactory(new PropertyValueFactory<OrderPreview, Number>("price"));
		VieworderDate.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("orderDate"));
		ViewExpectDel.setCellValueFactory(new PropertyValueFactory<OrderPreview, String>("expectedDelivery"));
		Viewshow.setCellFactory(ShowButtonTableCell.<OrderPreview>forTableColumn("Details", (OrderPreview o) -> {

			if(!OrderHandleController.isDetailsAllreadyOpen2())
			{
				if(o != null && o.getItems() != null) {
					OrderHandleController.setCustomerOrderView(o);
					OrderHandleController.setCustomerOrderDetails(o.getItems());
				}
				else 
					throw new NullPointerException();
				
				// new windows add send him the productInOrder list with the info
				Stage primaryStage = new Stage();
				CustomerViewOrderDetailsController customViewOrderDetails = new CustomerViewOrderDetailsController();
				try {
					customViewOrderDetails.start(primaryStage);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("No items");
				}
			}
			else
			{
				System.out.println("details allreaday open popup");
			}
			
			return o;
		}));
		
		
		
		/**
		 * set history orders on screen 
		 */
		List<Order> cancelationOrders = ClientHandleTransmission.getCustomerOrdersForCancaltion();
		if(cancelationOrders.size()>0)
		{
			System.out.println(cancelationOrders);
			for(Order o : cancelationOrders) {
				/**
				 * create order preview 
				 */
				OrderPreview op = new OrderPreview(o.getOrderID(), o.getCustomerID(),o.getBranchID(), o.getPrice(),
						o.getGreetingCard(), o.getOrderDate(), o.getExpectedDelivery(), o.getItems());
				/**
				 * set status by database
				 */
				op.getComboStatus().setValue(op.getStatus());
				cancelationOrdersPreview.add(op);
			}
			
			System.out.println(cancelationOrdersPreview);
			tableCancelOrder.setItems(cancelationOrdersPreview);
			OrderHandleController.setCancelationOrdersPreview(cancelationOrdersPreview);
		}
		
			
		/**
		 * set history orders on screen 
		 */
		List<Order> historyOrders = ClientHandleTransmission.getCustomerOrdersHistory();
		if(historyOrders.size()>0)
		{
			System.out.println(historyOrders);
			for(Order o : historyOrders) {
				/**
				 * create order preview 
				 */
				OrderPreview op = new OrderPreview(o.getOrderID(), o.getCustomerID(),o.getBranchID(), o.getPrice(),
						o.getGreetingCard(), o.getOrderDate(), o.getExpectedDelivery(), o.getItems());
				/**
				 * set status by database
				 */
				op.getComboStatus().setValue(op.getStatus());
				historyOrdersPreview.add(op);
			}
			
			System.out.println(historyOrdersPreview);
			tableViewOrder.setItems(historyOrdersPreview);
			OrderHandleController.setHistoryOrdersPreview(historyOrdersPreview);
		}
		
		
	}

}

