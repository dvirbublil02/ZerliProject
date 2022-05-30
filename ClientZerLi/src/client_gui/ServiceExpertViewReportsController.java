package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import client.ClientUI;
import communication.TransmissionPack;
import entities_reports.Report;
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
import javafx.stage.Stage;

public class ServiceExpertViewReportsController implements Initializable {

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
	    private ComboBox<String> pickSurveyCB;

	    @FXML
	    private ComboBox<String> pickYearCB;

	    @FXML
	    private Button submitBtn;

	    @FXML
	    private Label userRoleLbl;

	    @FXML
	    private Label welcomeBackUserNameLbl;

    private ObservableList<String> monthList;
	private ObservableList<String> yearList;
	private ObservableList<String> branchList;
	private ObservableList<String> surveyList;

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
    	
    	if (ClientHandleTransmission.getServiceReport(PickBranch.getValue(), pickYearCB.getValue(),pickMonthCB.getValue(),pickSurveyCB.getValue()))
    	{
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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		monthList = FXCollections.observableArrayList();
		for (int i = 1; i <= 12; i++) {
			if (i < 10)
				monthList.add("0" + i);
			else
				monthList.add("" + i);
		}
		pickMonthCB.setItems(monthList);
		yearList = FXCollections.observableArrayList("2019", "2020", "2021", "2022");
		pickYearCB.setItems(yearList);
		branchList = FXCollections.observableArrayList("2525", "1005", "4554");
		PickBranch.setItems(branchList);
		surveyList = FXCollections.observableArrayList("Customer Service","TBD");
		pickSurveyCB.setItems(surveyList);
		
	}

}
