package client_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OrderPageController {

	@FXML
	private Button backBtn;

	@FXML
	private Button confirmBtn;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/OrderPage.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("Order Page");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	@FXML
	void back(ActionEvent event) {

	}

	@FXML
	void confirm(ActionEvent event) {

	}

}