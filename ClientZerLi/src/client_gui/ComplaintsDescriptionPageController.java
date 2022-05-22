package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

import client.ClientController;
import client.ClientHandleTransmission;
import client.ComplaintsDataHandle;
import entities_users.CustomerService;
import enums.ComplaintsStatus;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ComplaintsDescriptionPageController implements Initializable{
	

	 @FXML
	    private Label details;

	    @FXML
	    private Button finishBtn;

	    @FXML
	    private TextField refound;
		@FXML
		private Label employeeName;
		@FXML
		private Label entryGreeting;

		@FXML
		private Label accountStatus;
		@FXML
		private Label phoneNumber;
	    @FXML
	    private Label employeeType;

	    @FXML
	    private ComboBox<ComplaintsStatus> status=new ComboBox<>();
	    ObservableList<ComplaintsStatus>box=FXCollections.observableArrayList(ComplaintsStatus.OPEN, ComplaintsStatus.CLOSE);
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
    	((Node) event.getSource()).getScene().getWindow().hide();
    	System.out.println(status.getValue());
    	ComplaintsDataHandle.getComplaint().setComplainState(status.getValue());
    	
    	
    }
  
    @FXML
    void refoundCheck(ActionEvent event) {
    	if(refoundCheck.isSelected()) {
    		refound.setDisable(false);
    	}else {
    	refound.setDisable(true);
    	}
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		details.setText(details.getText()+"\n"+ComplaintsDataHandle.getComplaint().getDescription());
		status.setItems(box);
		status.setValue(ComplaintsDataHandle.getComplaint().getComplainState());
		refound.setDisable(true);
		ClientController.initalizeUserDetails(employeeName, phoneNumber, accountStatus,entryGreeting,employeeType,((CustomerService)ClientController.user).toString());
		System.out.println((CustomerService)ClientController.user);
		
	}

}
