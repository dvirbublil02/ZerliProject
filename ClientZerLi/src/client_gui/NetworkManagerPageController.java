package client_gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NetworkManagerPageController {

	@FXML
	private Button logOutBtn;

	@FXML
	private Button requestSpecialReportBtn;

	@FXML
	private Button viewMonthlyReportBtn;

	@FXML
	private Button viewQuarterlyReportBtn;

	@FXML
	private Button viewSpecialReportBtn;

	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/NetworkManagerPage.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Network Manager Menu");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void logOut(ActionEvent event) {

	}

	@FXML
	void requestSpecialReport(ActionEvent event) {

	}

	@FXML
	void viewMonthlyReport(ActionEvent event) {

	}

	@FXML
	void viewQuarterlyReport(ActionEvent event) {

	}

	@FXML
	void viewSpecialReport(ActionEvent event) {

	}

}