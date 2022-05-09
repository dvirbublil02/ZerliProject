package client_gui;

import client.ClientHandleTransmission;
import client.ClientUI;
import communication.Mission;
import communication.TransmissionPack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomerPageController {

	@FXML
	private Button cancelOrdersBtn;

	@FXML
	private Button compliantBtn;

	@FXML
	private Button logOutBtn;

	@FXML
	private Button viewCatalogBtn;

    @FXML
    private Button viewCatalogBtn1;
    
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
	void cancelOrders(ActionEvent event) {

	}

	@FXML
	void compliant(ActionEvent event) {

	}

	@FXML
	void logOut(ActionEvent event) throws Exception {
		TransmissionPack tp = new TransmissionPack(Mission.USER_LOGOUT, null, this);
		ClientUI.chat.accept(tp);
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

}
