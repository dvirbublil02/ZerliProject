package client_gui;

import client.ClientHandleTransmission;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BranchManagerPageController {

    @FXML
    private Button addNewCustomerBtn;

    @FXML
    private Button createReportBtn;

    @FXML
    private Button editCustomerInfoBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Button managmentBtn;

    @FXML
    private Button viewReportsBtn;
    
    
	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/BranchManagerPage.fxml"));
				
		Scene scene = new Scene(root);
	
		primaryStage.setTitle("Manager Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});	
	}
    
    @FXML
    void addNewCustomer(ActionEvent event) {

    }

    @FXML
    void createReport(ActionEvent event) {

    }

    @FXML
    void editCustomerInfo(ActionEvent event) {
    	
    }

    @FXML
    void logOut(ActionEvent event) {
    	
    }

    @FXML
    void managment(ActionEvent event) {

    }

    @FXML
    void viewReports(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		BranchManagerViewReportPageController viewReportPage = new BranchManagerViewReportPageController();
		viewReportPage.start(primaryStage);
    }

}


