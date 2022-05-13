package client_gui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import client.ClientHandleTransmission;
import client.ClientUI;
import communication.Mission;
import communication.TransmissionPack;
import entities_catalog.ProductInOrder;
import entities_general.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * @author Mor Ben Haim
 * */
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
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});	
	}

	@FXML
	void back(ActionEvent event) {

	}
	/**
	 * event when customer press confirm this event 
	 * adding the order to the DB after the customer 
	 * finish his order
	 * 
	 * @param event
	 */
	@FXML
	void confirm(ActionEvent event) {
		
		ClientHandleTransmission.addOrder();
		
	}

	

}