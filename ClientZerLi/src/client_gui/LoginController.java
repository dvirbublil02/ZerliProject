package client_gui;

import client.ClientHandleTransmission;
import client.MissionAnalyzeClient;
import client.zerliClientListeners;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField passwordTxt;

	@FXML
	private TextField userTxt;

	@FXML
	private Label errorLabel;

	@FXML
	private Button loginBtn;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/LoginScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("ZerLi Login");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		MissionAnalyzeClient.addClientListener(new zerliClientListeners() {
			@Override
			public void userIsCustomer() {
				MissionAnalyzeClient.removeClientListener(this);
				System.out.println("here");
			}
			@Override
			public void userIsBranchManager() {
				MissionAnalyzeClient.removeClientListener(this);
			}
			

		});
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		primaryStage.setOnCloseRequest(event -> {ClientHandleTransmission.DISCONNECT_FROM_SERVER();});
	}

	@FXML
	void LoginClick(MouseEvent event) {
		ClientHandleTransmission.USER_LOGIN(userTxt, passwordTxt, errorLabel, event);

	}
}
