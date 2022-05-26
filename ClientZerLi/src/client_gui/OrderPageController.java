package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;

import enums.Branches;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * @author Mor Ben Haim
 * */
public class OrderPageController implements Initializable{

	@FXML
	private Button backBtn;

	@FXML
	private Button confirmBtn;
	
	 @FXML
	 private TextField greetingCard;
	
	@FXML
    private ComboBox<Branches> getBranchName=new ComboBox<>();

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
	void back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CartPageController cartPageController = new CartPageController();
		cartPageController.start(primaryStage);
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
		
		getBranchName.getValue();
		ClientHandleTransmission.addOrder(getBranchName.getValue(),greetingCard.getText());
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Branches> branchOptions=FXCollections.observableArrayList(Branches.KARMIEL);
		this.getBranchName.setItems(branchOptions);
		
	}

	

}