package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

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

public class BranchManagerViewReportPageController implements Initializable {
//shir changed
	@FXML
	private Label MonthlyMonthLabel;

	@FXML
	private CheckBox MonthlyReportButton;

	@FXML
	private Label MonthlyYearLabel;

	@FXML
	private Label PickReportLabel;

	@FXML
	private CheckBox QuartelyReportButton;

	@FXML
	private Label QuaterlyLabel;

	@FXML
	private Label QuaterlyYearLabel;

	@FXML
	private Button VackButon;

	@FXML
	private Button ViewButton;

	@FXML
	private ComboBox<String> pickMonthForMonthlyCB;

	@FXML
	private ComboBox<String> pickQuarterCB;

	@FXML
	private ComboBox<String> pickReportTypeForMonthlyCB;

	@FXML
	private ComboBox<String> pickYearForMonthlyCB;

	@FXML
	private ComboBox<String> pickYearForQuarterCB;

	private ObservableList<String> reportTypeList;
	private ObservableList<String> monthlyMonthList;
	private ObservableList<String> monthlyYearList;

	private ObservableList<String> quarterlyQuarterList;
	private ObservableList<String> quarterlyYearList;

	@FXML
	void Back(ActionEvent event) throws Exception {

		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		BranchManagerPageController branchPage = new BranchManagerPageController();
		branchPage.start(primaryStage);

	}
	// private static ObservableList<String[]> months = {"Month", "January",
	// "February", "March", "April", "May", "June", "July", "August", "September",
	// "October", "November", "December"};

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/BranchManagerviewReportPage.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("View Report Page");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		pickMonthForMonthlyCB.setDisable(true);
		pickReportTypeForMonthlyCB.setDisable(true);
		pickYearForMonthlyCB.setDisable(true);
		pickQuarterCB.setDisable(true);
		pickYearForQuarterCB.setDisable(true);
		MonthlyMonthLabel.setDisable(true);
		MonthlyYearLabel.setDisable(true);
		PickReportLabel.setDisable(true);
		QuaterlyLabel.setDisable(true);
		QuaterlyYearLabel.setDisable(true);

		reportTypeList = FXCollections.observableArrayList("Income", "Orders", "Satisfaction");
		pickReportTypeForMonthlyCB.setItems(reportTypeList);

		monthlyMonthList = FXCollections.observableArrayList();
		for (int i = 1; i <= 12; i++) {
			if (i < 10)
				monthlyMonthList.add("0" + i);
			else
				monthlyMonthList.add("" + i);
		}
		pickMonthForMonthlyCB.setItems(monthlyMonthList);

		monthlyYearList = FXCollections.observableArrayList("2020", "2021", "2022");// needs a quairy to find
		pickYearForMonthlyCB.setItems(monthlyYearList);// only the years that has reports

		quarterlyQuarterList = FXCollections.observableArrayList("01", "02", "03", "04");
		pickQuarterCB.setItems(quarterlyQuarterList);
		quarterlyYearList = FXCollections.observableArrayList("2020", "2021", "2022");
		pickYearForQuarterCB.setItems(quarterlyYearList);

	}

	public void showAction1(ActionEvent event) {
		if (MonthlyReportButton.isSelected() && !QuartelyReportButton.isSelected()) {
			pickMonthForMonthlyCB.setDisable(false);
			pickReportTypeForMonthlyCB.setDisable(false);
			pickYearForMonthlyCB.setDisable(false);
			MonthlyMonthLabel.setDisable(false);
			MonthlyYearLabel.setDisable(false);
			PickReportLabel.setDisable(false);
			QuartelyReportButton.setDisable(true);

		} else {
			QuartelyReportButton.setDisable(false);
			pickMonthForMonthlyCB.setDisable(true);
			pickReportTypeForMonthlyCB.setDisable(true);
			pickYearForMonthlyCB.setDisable(true);
			MonthlyMonthLabel.setDisable(true);
			MonthlyYearLabel.setDisable(true);
			PickReportLabel.setDisable(true);

		}

	}

	public void showAction2(ActionEvent event) {
		if (QuartelyReportButton.isSelected() && !MonthlyReportButton.isSelected()) {
			pickQuarterCB.setDisable(false);
			pickYearForQuarterCB.setDisable(false);
			QuaterlyLabel.setDisable(false);
			QuaterlyYearLabel.setDisable(false);
			MonthlyReportButton.setDisable(true);

		} else {
			MonthlyReportButton.setDisable(false);
			pickQuarterCB.setDisable(true);
			pickYearForQuarterCB.setDisable(true);
			QuaterlyLabel.setDisable(true);
			QuaterlyYearLabel.setDisable(true);

		}
	}
}
