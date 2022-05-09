package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BranchManagerViewReportPageController implements Initializable {

	@FXML
	private ComboBox<?> MonthlyMonth;

	@FXML
	private Label MonthlyMonthLabel;

	@FXML
	private ComboBox<?> MonthlyReport;

	@FXML
	private CheckBox MonthlyReportButton;

	@FXML
	private ComboBox<?> MonthlyYear;

	@FXML
	private Label MonthlyYearLabel;

	@FXML
	private Label PickReportLabel;

	@FXML
	private CheckBox QuartelyReportButton;

	@FXML
	private ComboBox<?> QuartrtlyReport;

	@FXML
	private ComboBox<?> QuartrtlyYear;

	@FXML
	private Label QuaterlyLabel;

	@FXML
	private Label QuaterlyYearLabel;

	@FXML
	private Button BackButon;

	@FXML
    private Button ViewButton;
	
	@FXML
	void Back(ActionEvent event) {

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

		MonthlyMonth.setDisable(true);
		MonthlyReport.setDisable(true);
		MonthlyYear.setDisable(true);
		QuartrtlyReport.setDisable(true);
		QuartrtlyYear.setDisable(true);
		MonthlyMonthLabel.setDisable(true);
		MonthlyYearLabel.setDisable(true);
		PickReportLabel.setDisable(true);
		QuaterlyLabel.setDisable(true);
		QuaterlyYearLabel.setDisable(true);

	}

	public void showAction1(ActionEvent event) {
		if (MonthlyReportButton.isSelected() && !QuartelyReportButton.isSelected()) {
			MonthlyMonth.setDisable(false);
			MonthlyReport.setDisable(false);
			MonthlyYear.setDisable(false);
			MonthlyMonthLabel.setDisable(false);
			MonthlyYearLabel.setDisable(false);
			PickReportLabel.setDisable(false);
			QuartelyReportButton.setDisable(true);

		} else {
			QuartelyReportButton.setDisable(false);
			MonthlyMonth.setDisable(true);
			MonthlyReport.setDisable(true);
			MonthlyYear.setDisable(true);
			MonthlyMonthLabel.setDisable(true);
			MonthlyYearLabel.setDisable(true);
			PickReportLabel.setDisable(true);

		}

	}

	public void showAction2(ActionEvent event) {
		if (QuartelyReportButton.isSelected() && !MonthlyReportButton.isSelected()) {
			QuartrtlyReport.setDisable(false);
			QuartrtlyYear.setDisable(false);
			QuaterlyLabel.setDisable(false);
			QuaterlyYearLabel.setDisable(false);
			MonthlyReportButton.setDisable(true);

		} else {
			MonthlyReportButton.setDisable(false);
			QuartrtlyReport.setDisable(true);
			QuartrtlyYear.setDisable(true);
			QuaterlyLabel.setDisable(true);
			QuaterlyYearLabel.setDisable(true);

		}
	}
	
	  @FXML
	    void View(ActionEvent event) {

	    }

}
