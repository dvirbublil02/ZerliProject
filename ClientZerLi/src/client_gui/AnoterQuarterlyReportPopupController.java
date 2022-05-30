package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import client.popMessageHandler;
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

public class AnoterQuarterlyReportPopupController implements Initializable {

    @FXML
    private Label alertLabel;
	@FXML
	private ComboBox<String> PickBranch;

	@FXML
	private ComboBox<String> pickQuarterQuarterlyCB;

	@FXML
	private ComboBox<String> pickTypeQuarterlyCB;

	@FXML
	private ComboBox<String> pickYearQuarterlyCB;

	@FXML
	private Button submitBtn;

	private ObservableList<String> quarterlyQuarterList;
	private ObservableList<String> quarterlyYearList;
	private ObservableList<String> branchesObser;
	private ObservableList<String> reportTypeList;
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/AnoterQuarterlyReportPopupPage.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Network Manager View Reports");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void Submit(ActionEvent event) throws IOException {
		if(PickBranch.getValue() != null && pickYearQuarterlyCB.getValue() != null &&pickQuarterQuarterlyCB.getValue() != null)
		if (ClientHandleTransmission.getQuarterIncomeReport(PickBranch.getValue(), pickYearQuarterlyCB.getValue(),pickQuarterQuarterlyCB.getValue())) {
			((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
			Stage primaryStage = new Stage();
			PopupSecondIncomeQuarterlyReportsController secondIncomeQuarterly = new PopupSecondIncomeQuarterlyReportsController();
			secondIncomeQuarterly.start(primaryStage);
		}
			alertLabel.setText("Requested report didnt exist!");
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		quarterlyQuarterList = FXCollections.observableArrayList("1", "2", "3", "4");
		pickQuarterQuarterlyCB.setItems(quarterlyQuarterList);
		List<String> querterYear = ClientHandleTransmission.getYearsForComboBox("QUARTERLY", "reports");
		if(querterYear.size()>0) {
			quarterlyYearList = FXCollections.observableArrayList(querterYear);
		}
		else {
			quarterlyYearList = FXCollections.observableArrayList();
		}
		pickYearQuarterlyCB.setItems(quarterlyYearList);
		branchesObser = FXCollections.observableArrayList("2525", "1005", "4554");
		PickBranch.setItems(branchesObser);
		reportTypeList=FXCollections.observableArrayList("Income");
		pickTypeQuarterlyCB.setItems(reportTypeList);
		// need to add the branches after merge geting almog method.
//		List<Branches> brances=ClientHandleTransmission.getBranches();
//		if(brances.size() != 0) {
//			branchesObser.addAll(brances);
//		}
//		PickBranch.setItems(branchesObser);

	}

}
