package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

import client.ClientController;
import client.ClientHandleTransmission;
import client.ClientUI;
import communication.Mission;
import communication.TransmissionPack;
import entities_users.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CustomerPageController implements Initializable {


	@FXML
	private Button logOutBtn;

	@FXML
	private Button viewCatalogBtn;
	
    @FXML
    private Button viewOrdersBtn;
	
    @FXML
    private Label accountStatus;
    
    @FXML
    private Label employeeName;
    
    @FXML
    private Label employeeType;
    
    @FXML
    private Label entryGreeting;

    @FXML
    private Label phoneNumber;
    

    
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CustomerPage.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("Customer Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});	
	}
	

    @FXML
    void orderView(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CustomerViewOrdersController customerViewOrders = new CustomerViewOrdersController();
		customerViewOrders.start(primaryStage);	
    }
	

	@FXML
	void logOut(ActionEvent event) throws Exception {
		TransmissionPack tp;
		ClientHandleTransmission.DISCONNECT_FROM_SERVER();
		tp = ClientUI.chat.getObj();
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		LoginController login = new LoginController();
		login.start(primaryStage);
	}

	

	@FXML
	void viewCatalog(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CatalogScreenController catalog = new CatalogScreenController();
		catalog.start(primaryStage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ClientController.initalizeUserDetails(employeeName, phoneNumber, accountStatus, entryGreeting, employeeType,
				((Customer) ClientController.user).toString());
	}

}
