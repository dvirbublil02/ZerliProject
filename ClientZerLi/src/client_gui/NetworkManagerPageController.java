package client_gui;

import java.io.IOException;

import client.ClientController;
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

public class NetworkManagerPageController {

	@FXML
	private Button logOutBtn;

	@FXML
	private Button viewReportsBtn;

	@FXML
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/NetworkManagerPage.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Network Manager Menu");
		stage.setScene(scene);
		stage.show();
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
	void viewReports(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		NetworkManagerViewReportsController networkManagerViewReportsController = new NetworkManagerViewReportsController();
		networkManagerViewReportsController.start(primaryStage);
	}

}