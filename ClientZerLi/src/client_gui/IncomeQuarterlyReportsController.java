package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import client.ReportHandleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IncomeQuarterlyReportsController implements Initializable {

	@FXML
	private Button BackBtn;

	@FXML
	private LineChart<String, Double> IncomeLineChart;
	@FXML
	private Label bestMonth;

	@FXML
	private Label incomeQuarterTitle;

	@FXML
	private Label worstMonth;

	List<List<String>> reportOnList = new ArrayList<>();
	List<String> reportInfo = new ArrayList();

	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/IncomeQuarterlyReports.fxml"));

		Scene scene = new Scene(root);

		stage.setTitle("Income Quarterly Report Page");

		stage.setScene(scene);
		stage.show();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		reportOnList = ReportHandleController.getOrdersReportOnListQuarter();
		// LineChart
		XYChart.Series series = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		XYChart.Series series3 = new XYChart.Series();
		insertTheDeatilsForTheCart(series, series2, series3);
		IncomeLineChart.getData().addAll(series, series2, series3);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void insertTheDeatilsForTheCart(Series series, Series series2, Series series3) {
		reportInfo = reportOnList.get(0);
		incomeQuarterTitle.setText("Zerli " + reportInfo.get(1) + "(" + reportInfo.get(0) + ") -"
				+ reportInfo.get(2) + "st Quarter Income report "+reportInfo.get(3));
		series.setName("First month");
		series2.setName("Second month");
		series3.setName("Third month");
		reportOnList.remove(0);
		Collections.sort(reportOnList,new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				
				 if(Integer.valueOf(o1.get(2)).compareTo(Integer.valueOf(o2.get(2))) >0) {
					 return 1;
				 }
				 if(Integer.valueOf(o1.get(2)).compareTo(Integer.valueOf(o2.get(2))) <0) {
					 return -1;
				 }
				 return 0;
				
			}
		});
		
		for (int i = 0; i < reportOnList.size(); i++) {
			List<String> productInfo = new ArrayList();
			productInfo = reportOnList.get(i);
			if (productInfo.get(0).equals("month1")) {
				StringBuilder day=new StringBuilder();
				day.append("Day" +" ");
				day.append(productInfo.get(2));
				series.getData().add(new XYChart.Data(day.toString(),
						(Integer.parseInt(productInfo.get(3)) * Double.parseDouble(productInfo.get(4)))));

			} else if (productInfo.get(0).equals("month2")) {
				StringBuilder day=new StringBuilder();
				day.append("Day" +" ");
				day.append(productInfo.get(2));
				series2.getData().add(new XYChart.Data(day.toString(),
						(Integer.parseInt(productInfo.get(3)) * Double.parseDouble(productInfo.get(4)))));

			} else if (productInfo.get(0).equals("month3")) {
				StringBuilder day=new StringBuilder();
				day.append("Day" +" ");
				day.append(productInfo.get(2));
				series3.getData().add(new XYChart.Data(day.toString(),
						(Integer.parseInt(productInfo.get(3)) * Double.parseDouble(productInfo.get(4)))));

			}
		}

	}

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
