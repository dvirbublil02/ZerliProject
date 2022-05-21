package client_gui;

import client.ClientHandleTransmission;
import enums.ComplaintsStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ComplaintsDescriptionPageController {
	

	 @FXML
	    private Label details;

	    @FXML
	    private Button finishBtn;

	    @FXML
	    private TextField refound;

	    @FXML
	    private ComboBox<ComplaintsStatus> status;
	    @FXML
	    private RadioButton refoundCheck;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/ComplaintsDescriptionPage.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("Complaints Description Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});	
	}


	/**
	 * event when customer press confirm this event 
	 * adding the order to the DB after the customer 
	 * finish his order
	 * 
	 * @param event
	 */
    @FXML
    void finish(ActionEvent event) {

    }

}
