package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NetworkManagerViewReportsController implements Initializable {

	@FXML
	private Button BackBtn;

	@FXML
	private Label accountStatusLbl;

	@FXML
	private CheckBox monthlyReportsRadioBtn;

	@FXML
	private Label networkManagerNameLbl;

	@FXML
	private Label phoneNumberLbl;

	@FXML
	private ComboBox<?> pickMonthMonthlyCB;

	@FXML
	private ComboBox<?> pickMonthSpecial;

	@FXML
	private ComboBox<?> pickQuarterQuarterlyCB;

	@FXML
	private ComboBox<?> pickTypeMonthlyCB;

	@FXML
	private ComboBox<?> pickTypeQuarterlyCB;

	@FXML
	private ComboBox<?> pickYearForMonthlyCB;

	@FXML
	private ComboBox<?> pickYearQuarterlyCB;

	@FXML
	private ComboBox<?> pickYearSpecialCB;

	@FXML
	private CheckBox quarterlyReportsRadioBtn;

	@FXML
	private CheckBox specialReportsRadioBtn;

	@FXML
	private Button submitBtn;

	@FXML
	private Label userRoleLbl;

	@FXML
	private Label welcomeBackUserNameLbl;

	/**
	 * load the page to the screen
	 * @param stage
	 * @throws IOException
	 */
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/NetworkManagerViewReports.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Network Manager View Reports");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

//		pickMonthForMonthlyCB.setDisable(true);
//		pickReportTypeForMonthlyCB.setDisable(true);
//		pickYearForMonthlyCB.setDisable(true);
//		pickQuarterCB.setDisable(true);
//		pickYearForQuarterCB.setDisable(true);
//		MonthlyMonthLabel.setDisable(true);
//		MonthlyYearLabel.setDisable(true);
//		PickReportLabel.setDisable(true);
//		QuaterlyLabel.setDisable(true);
//		QuaterlyYearLabel.setDisable(true);
//
//		reportTypeList = FXCollections.observableArrayList("Income", "Orders", "Satisfaction");
//		pickReportTypeForMonthlyCB.setItems(reportTypeList);
//
//		monthlyMonthList = FXCollections.observableArrayList();
//		for (int i = 1; i <= 12; i++) {
//			if (i < 10)
//				monthlyMonthList.add("0" + i);
//			else
//				monthlyMonthList.add("" + i);
//		}
//		pickMonthForMonthlyCB.setItems(monthlyMonthList);
//
//		monthlyYearList = FXCollections.observableArrayList("2020", "2021", "2022");// needs a quairy to find
//		pickYearForMonthlyCB.setItems(monthlyYearList);// only the years that has reports
//
//		quarterlyQuarterList = FXCollections.observableArrayList("01", "02", "03", "04");
//		pickQuarterCB.setItems(quarterlyQuarterList);
//		quarterlyYearList = FXCollections.observableArrayList("2020", "2021", "2022");
//		pickYearForQuarterCB.setItems(quarterlyYearList);

	}
	
	/**
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		NetworkManagerPageController networkManagerPageController = new NetworkManagerPageController();
		networkManagerPageController.start(primaryStage);
	}

	@FXML
	void ShowMonthlyReports(ActionEvent event) {

	}

	@FXML
	void ShowQuarterlyReports(ActionEvent event) {
		//ClientHandleTransmission.getQuarerlyIncomeReport();
	}

	@FXML
	void ShowSpecialReports(ActionEvent event) {

	}

	@FXML
	void Submit(ActionEvent event) {

	}

}
