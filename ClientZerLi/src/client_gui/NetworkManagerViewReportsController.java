package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
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
	private ComboBox<String> pickMonthMonthlyCB;

	@FXML
	private ComboBox<String> PickBranch;

	@FXML
	private ComboBox<String> pickMonthSpecial;

	@FXML
	private ComboBox<String> pickQuarterQuarterlyCB;

	@FXML
	private ComboBox<String> pickTypeMonthlyCB;

	@FXML
	private ComboBox<String> pickTypeQuarterlyCB;

	@FXML
	private ComboBox<String> pickYearForMonthlyCB;

	@FXML
	private ComboBox<String> pickYearQuarterlyCB;

	@FXML
	private ComboBox<String> pickYearSpecialCB;

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
	 * 
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

	private ObservableList<String> reportTypeList;
	private ObservableList<String> monthlyMonthList;
	private ObservableList<String> monthlyYearList;

	private ObservableList<String> quarterlyQuarterList;
	private ObservableList<String> quarterlyYearList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		pickMonthMonthlyCB.setDisable(true);
		pickMonthSpecial.setDisable(true);
		pickQuarterQuarterlyCB.setDisable(true);
		pickTypeMonthlyCB.setDisable(true);
		pickTypeQuarterlyCB.setDisable(true);
		pickYearForMonthlyCB.setDisable(true);
		pickYearQuarterlyCB.setDisable(true);
		pickYearSpecialCB.setDisable(true);
		quarterlyReportsRadioBtn.setDisable(false);
		specialReportsRadioBtn.setDisable(false);
		monthlyReportsRadioBtn.setDisable(false);
		
		reportTypeList = FXCollections.observableArrayList("Income", "Orders", "Satisfaction");
		pickTypeMonthlyCB.setItems(reportTypeList);
		monthlyMonthList = FXCollections.observableArrayList();
		for (int i = 1; i <= 12; i++) {
			if (i < 10)
				monthlyMonthList.add("0" + i);
			else
				monthlyMonthList.add("" + i);
		}
		pickMonthMonthlyCB.setItems(monthlyMonthList);
		monthlyYearList = FXCollections.observableArrayList("2020", "2021", "2022");// needs a quairy to find
		pickYearForMonthlyCB.setItems(monthlyYearList);// only the years that has reports

		quarterlyQuarterList = FXCollections.observableArrayList("01", "02", "03", "04");
		pickQuarterQuarterlyCB.setItems(quarterlyQuarterList);
		quarterlyYearList = FXCollections.observableArrayList("2020", "2021", "2022");
		pickYearQuarterlyCB.setItems(quarterlyYearList);

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
		if (monthlyReportsRadioBtn.isSelected() && !quarterlyReportsRadioBtn.isSelected()
				&& !specialReportsRadioBtn.isSelected()) {
			pickMonthMonthlyCB.setDisable(false);
			pickTypeMonthlyCB.setDisable(false);
			pickYearForMonthlyCB.setDisable(false);
			quarterlyReportsRadioBtn.setDisable(true);
			specialReportsRadioBtn.setDisable(true);
		} else {
			pickMonthMonthlyCB.setDisable(true);
			pickTypeMonthlyCB.setDisable(true);
			pickYearForMonthlyCB.setDisable(true);
			quarterlyReportsRadioBtn.setDisable(false);
			specialReportsRadioBtn.setDisable(false);
		}
	}

	@FXML
	void ShowQuarterlyReports(ActionEvent event) {
		if (!monthlyReportsRadioBtn.isSelected() && quarterlyReportsRadioBtn.isSelected()
				&& !specialReportsRadioBtn.isSelected()) {
			pickTypeQuarterlyCB.setDisable(false);
			pickYearQuarterlyCB.setDisable(false);
			pickQuarterQuarterlyCB.setDisable(false);
			specialReportsRadioBtn.setDisable(true);
			monthlyReportsRadioBtn.setDisable(true);
		}
		else {
			pickTypeQuarterlyCB.setDisable(true);
			pickYearQuarterlyCB.setDisable(true);
			pickQuarterQuarterlyCB.setDisable(true);
			monthlyReportsRadioBtn.setDisable(false);
			specialReportsRadioBtn.setDisable(false);
		}
	}

	@FXML
	void ShowSpecialReports(ActionEvent event) {
		if(!monthlyReportsRadioBtn.isSelected() && !quarterlyReportsRadioBtn.isSelected() && specialReportsRadioBtn.isSelected()){
			monthlyReportsRadioBtn.setDisable(true);
			quarterlyReportsRadioBtn.setDisable(true);
			pickYearSpecialCB.setDisable(false);
			pickMonthSpecial.setDisable(false);
		}
		else {
			monthlyReportsRadioBtn.setDisable(false);
			quarterlyReportsRadioBtn.setDisable(false);
			pickYearSpecialCB.setDisable(true);
			pickMonthSpecial.setDisable(true);
		}
	}

	@FXML
	void Submit(ActionEvent event) throws IOException {
//		ClientHandleTransmission.getQuarterIncomeReport("2525","2022","2");
//		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
//		Stage primaryStage = new Stage();
//		IncomeQuarterlyReportsController orderReport = new IncomeQuarterlyReportsController();
//		orderReport.start(primaryStage);

	}

}