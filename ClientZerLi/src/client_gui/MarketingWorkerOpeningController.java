package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientController;
import client.ClientUI;
import communication.Mission;
import communication.TransmissionPack;
import entities_users.CustomerService;
import entities_users.MarketingWorker;
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

public class MarketingWorkerOpeningController implements Initializable{

	@FXML
	private Label accountStatus;

	@FXML
	private Label employeeName;

	@FXML
	private Label employeeType;

	@FXML
	private Label entryGreeting;

	@FXML
	private Button logOutBtn;

	@FXML
	private Button manageCatalogBTN;

	@FXML
	private Label phoneNumber;

	@FXML
	void logOut(ActionEvent event) throws Exception {
		
		TransmissionPack tp = new TransmissionPack(Mission.USER_LOGOUT, null, ClientController.user);
		ClientUI.chat.accept(tp);
		tp = ClientUI.chat.getObj();
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		LoginController login = new LoginController();
		login.start(primaryStage);

	}

	public void start(Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/MarketingWorkerOpeningPage.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("marketing worker menue");
		primaryStage.setScene(scene);

		primaryStage.show();

	}

	@FXML
	void manageCatalogPressed(ActionEvent event) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		MarketingWorkerManageCatalogController manageCatalog = new MarketingWorkerManageCatalogController();
		manageCatalog.start(primaryStage);
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	ClientController.initalizeUserDetails(employeeName, phoneNumber, accountStatus, entryGreeting, employeeType,
		((MarketingWorker) ClientController.user).toString());
	}
}










