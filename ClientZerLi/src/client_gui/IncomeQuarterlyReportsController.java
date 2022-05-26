package client_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IncomeQuarterlyReportsController {

    @FXML
    private Button BackBtn;

    @FXML
    private LineChart<?, ?> IncomeLineChart;
    @FXML
    private Label bestMonth;

    @FXML
    private Label incomeQuarterTitle;

    @FXML
    private Label worstMonth;


    @FXML
    void back(ActionEvent event) {
    	((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		NetworkManagerPageController branchPagerViewReport = new NetworkManagerPageController();
		try {
			branchPagerViewReport.start(primaryStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
