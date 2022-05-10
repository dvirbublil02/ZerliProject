package client_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BranchManagerAddNewCustomerController {

    @FXML
    private Button ApproveBtn;

    @FXML
    private Button BackBtn;

    @FXML
    private TextField CvvTxt;

    @FXML
    private TextField IDTxt;

    @FXML
    private ComboBox<?> MonthComboBox;

    @FXML
    private TextField PhoneNumberTxt;

    @FXML
    private ComboBox<?> YearComboBox;

    @FXML
    private TextField creditCardNumTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField firstNameTxt;

    @FXML
    private TextField lastNameTxt;
    
    public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/AddNewCustomerPage.fxml"));
				
		Scene scene = new Scene(root);
	
		primaryStage.setTitle("Add New Customer");
		primaryStage.setScene(scene);
		primaryStage.show();
//		primaryStage.setOnCloseRequest(event ->{
//		ClientHandleTransmission.DISCONNECT_FROM_SERVER();
//		});	
    }
    
    @FXML
    void ApproveCustomer(ActionEvent event) {

    }

    @FXML
    void Back(ActionEvent event) throws Exception {
    	((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		BranchManagerPageController branchManagerPage = new BranchManagerPageController();
		branchManagerPage.start(primaryStage);
    }

}
