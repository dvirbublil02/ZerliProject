package client_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    }
}
