package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientController;
import client.ClientHandleTransmission;
import client.ClientUI;
import communication.Mission;
import communication.TransmissionPack;
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

public class CustomerServicePageController implements Initializable {
	@FXML
	private Button logOutBtn;
	@FXML
	private Label employeeName;
	@FXML
	private Label entryGreeting;

	@FXML
	private Label accountStatus;
	@FXML
	private Label phoneNumber;

	@FXML
	private Button requestSpecialReportBtn;

	@FXML
	private Button viewcomplaintsBtn;

	@FXML
	private Button viewQuarterlyReportBtn;

	@FXML
	private Button viewSpecialReportBtn;

	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CustomerServiceScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Customer Service Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
		});
	}

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

	@FXML
	void requestSpecialReport(ActionEvent event) {

	}

	@FXML
	void viewQuarterlyReport(ActionEvent event) {

	}

	@FXML
	void viewSpecialReport(ActionEvent event) {

	}

	@FXML
	void viewcomplaintsBtn(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ClientController.initalizeUserDetails(employeeName, phoneNumber, accountStatus,entryGreeting);
	}

}
