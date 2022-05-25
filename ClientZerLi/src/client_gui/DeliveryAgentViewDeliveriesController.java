package client_gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DeliveryAgentViewDeliveriesController {

	@FXML
	private Button BackBtn;

	@FXML
	private Label branchNameLbl;

	@FXML
	private TableView<?> deliveriesTable;

	@FXML
	private Label networkManagerName;

	@FXML
	private Label phoneNumber;

	@FXML
	private Label userRole;

	@FXML
	private Label userStatus;

	@FXML
	private Label welcomeBackUserName;

	/**
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/DeliveryAgentViewDeliveries.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Delivery Agent View Delivieries");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void ChooseDelivery(MouseEvent event) {

	}

	/**
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		DeliveryAgentPageController deliveryAgentPageController = new DeliveryAgentPageController();
		deliveryAgentPageController.start(primaryStage);
	}
}
