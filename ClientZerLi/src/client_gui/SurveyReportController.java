package client_gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SurveyReportController {

    @FXML
    private Button BackBtn;

    @FXML
    private StackedBarChart<?, ?> barChart;

    @FXML
    private TextField conclusionsText;

    @FXML
    private TextField recommendationText;

    @FXML
    private Label reportTitle;

    @FXML
    private Button submitBtn;

    public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/SurveyReport.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Surver Report View Reports");
		stage.setScene(scene);
		stage.show();
	}
    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {

    }

}
