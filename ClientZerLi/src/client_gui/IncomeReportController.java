package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IncomeReportController implements Initializable {

	@FXML
	private Button BackBtn;

	@FXML
	private LineChart<?, ?> IncomeLineChart;

	@FXML
	private PieChart pieChartCustom;

	@FXML
	private PieChart pieChartRegular;

	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/IncomeReport.fxml"));

		Scene scene = new Scene(root);

		stage.setTitle("Income Report Page");

		stage.setScene(scene);
		stage.show();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// LineChart
		XYChart.Series series = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		series.setName("regular products");
		series2.setName("custom products");
		// load data to LineChart
		series.getData().add(new XYChart.Data("Week 1", 23));
		series.getData().add(new XYChart.Data("Week 2", 14));
		series.getData().add(new XYChart.Data("Week 3", 15));
		series.getData().add(new XYChart.Data("Week 4", 24));
		series2.getData().add(new XYChart.Data("Week 1", 34));
		series2.getData().add(new XYChart.Data("Week 2", 36));
		series2.getData().add(new XYChart.Data("Week 3", 22));
		series2.getData().add(new XYChart.Data("Week 4", 45));
		// add to regular(series) and Custom(series2)
		IncomeLineChart.getData().addAll(series, series2);
	}

	@FXML
	void logOut(ActionEvent event) {
	}

}
