package client_gui_prototype;

import java.io.IOException;

import client.ClientHandleTransmission;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This controller will be to our addOrder Screen , will handle with all the
 * operations
 *
 */
public class AddOrderControllerPrototype {

	@FXML
	private Button BackBtn;

	@FXML
	private Button addBtn;

	@FXML
	private TextField colorTxt;

	@FXML
	private TextField dOrderTxt;

	@FXML
	private TextField dateTxt;

	@FXML
	private TextField greetingCardTxt;

	@FXML
	private TextField orderIdTxt;

	@FXML
	private TextField orderDate;

	@FXML
	private TextField priceTxt;

	@FXML
	private TextField shopTxt;

	@FXML
	private Label statusTxt;

	/**
	 * This method will handle with Click on button event. After Back button pressed
	 * on the Gui we returning for the previous screen
	 * 
	 * @param event - back button clicked
	 * @throws Exception
	 */
	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		MenuPageControllerPrototype menuPage = new MenuPageControllerPrototype();
		menuPage.start(primaryStage);
		
	}

	/**
	 * In this method loading the add-order screen(fxml)
	 * 
	 * @param primaryStage
	 * @throws IOException
	 */
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/AddOrder.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Order");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});
	}

	/**
	 * In this method we handling with the operation of add order , after the button
	 * add clicked we sending the mission with the information(we will get from the
	 * Gui)that we want to add to the server by using the
	 * ClientHandleTrasmission.INSERT_ORDER
	 * 
	 * @param event
	 */
	@FXML
	void addOrder(ActionEvent event) {

		ClientHandleTransmission.ADD_ORDER(orderIdTxt, priceTxt, greetingCardTxt, colorTxt, dOrderTxt, shopTxt,
				dateTxt, orderDate, statusTxt);
	}
}
