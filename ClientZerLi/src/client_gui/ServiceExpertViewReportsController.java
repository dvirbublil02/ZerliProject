package client_gui;

import java.io.IOException;

import client.ClientHandleTransmission;
import client.ClientUI;
import communication.TransmissionPack;
import entities_reports.Report;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ServiceExpertViewReportsController {

    @FXML
    private Button BackBtn;

    @FXML
    private ComboBox<String> PickBranch;

    @FXML
    private Label accountStatusLbl;

    @FXML
    private Label networkManagerNameLbl;

    @FXML
    private Label phoneNumberLbl;

    @FXML
    private ComboBox<String> pickMonthCB;

    @FXML
    private ComboBox<String> pickYearCB;

    @FXML
    private Button submitBtn;

    @FXML
    private Label userRoleLbl;

    @FXML
    private Label welcomeBackUserNameLbl;

    public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/ServiceExpertViewReports.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Service Expert View Reports");
		stage.setScene(scene);
		stage.show();
	}
    @FXML
    void Back(ActionEvent event) {
    	((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		ServiceExpertPageController serviceExpertPage = new ServiceExpertPageController();
		try {
			serviceExpertPage.start(primaryStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void Submit(ActionEvent event) {
    	if (ClientHandleTransmission.getServiceReport(PickBranch.getValue(), pickYearCB.getValue(),pickMonthCB.getValue()))
    	{
    		TransmissionPack tp = ClientUI.chat.getObj();
			Report returned = ((Report) tp.getInformation());
			((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
			Stage primaryStage = new Stage();
				SurveyReportController surveyReport = new SurveyReportController();
				try {
					surveyReport.start(primaryStage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    	}
    	else {
    		ClientHandleTransmission.popUp("There is no avaliable report yet!\nPlease choose different one!","No Report Avaliable");
    	}
    }

}
