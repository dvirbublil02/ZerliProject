package client_gui;

import java.io.IOException;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import client.ClientUI;
import client.ReportHandleController;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * this class is handling with the monthly Order report .
 * 
 * @author Dvir Bublil
 *
 */
public class OrderReportsController implements Initializable {

	@FXML
	private Button BackBtn;

	@FXML
	private BarChart<String, Number> barChart;

	@FXML
	private PieChart pieChartCustom;
	@FXML
	private Label worstSeller;
	@FXML
	private Label bestSeller;
	@FXML
	private PieChart pieChartRegular;
	@FXML
	private Label reportTitle;

	private static final DecimalFormat df = new DecimalFormat("0.000");
	List<List<String>> reportOnList = new ArrayList<>();
	List<String> branchInfo = new ArrayList();

	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/OrderReportsPage.fxml"));

		Scene scene = new Scene(root);

		stage.setTitle("Order Report Page");

		stage.setScene(scene);
		stage.show();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<PieChart.Data> pieChartData = null;
		ObservableList<PieChart.Data> pieChartData2 = null;
		reportOnList = ReportHandleController.getOrdersReportOnListMonth();
		insertTheOrdersReportDetails(pieChartData, pieChartData2);

	}

	private void insertTheOrdersReportDetails(ObservableList<PieChart.Data> pieChartData,
			ObservableList<PieChart.Data> pieChartData2) {
		List<Double> amount = new ArrayList<>();
		double bouquet = 0, single = 0;
		branchInfo = reportOnList.get(0); // here we getting the branch information
		reportTitle.setText("Zerli " + branchInfo.get(1) + "(ID-" + branchInfo.get(0) + ")" + " - " + branchInfo.get(2)
				+ "-th orders based on products");
		// LineChart
		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
		XYChart.Series<String, Number> series2 = new XYChart.Series<>();
		series1.setName("single products");
		series2.setName("Boquet products");
		boolean flag = false, flag2 = false;
		amount = insertIntoChart(bouquet, single, series1, series2); // insert the products their information into the
																		// chart
		// in this loop we insert the data of the products , into the pie chart diagram.
		for (int i = 1; i < reportOnList.size(); i++) {
			List<String> productInfo = new ArrayList();
			productInfo = reportOnList.get(i);
			if (productInfo.get(0).equals("product")) {
				StringBuilder name = new StringBuilder();
				name.append(productInfo.get(1) + " ");
				name.append(productInfo.get(2));
				if (flag == false) {
					pieChartData = FXCollections.observableArrayList(new PieChart.Data(name.toString(),
							((Integer.parseInt(productInfo.get(3)) / amount.get(0)))));

				} else {
					pieChartData.add(new PieChart.Data(name.toString(),
							((Integer.parseInt(productInfo.get(3)) / amount.get(0)))));
				}
				flag = true;
			}
			if (productInfo.get(0).equals("item")) {
				StringBuilder name = new StringBuilder();
				name.append(productInfo.get(1) + " ");
				name.append(productInfo.get(2));
				if (flag2 == false) {
					pieChartData2 = FXCollections.observableArrayList(new PieChart.Data(name.toString(),
							((Integer.parseInt(productInfo.get(3)) / amount.get(0)))));

				} else {
					pieChartData2.add(new PieChart.Data(name.toString(),
							((Integer.parseInt(productInfo.get(3)) / amount.get(0)))));
				}
				flag2 = true;
			}
		}
		barChart.getData().addAll(series1, series2);
		pieChartCustom.setData(pieChartData);
		pieChartCustom.setStartAngle(90);
		pieChartRegular.setData(pieChartData2);
		pieChartRegular.setStartAngle(90);
		insertTheWorstAndBestSell();
//////////////////////---PieChart MouseEvent(regular + Custom)--//////////////////////////////////////////
		// display the values of slice inside custom PieChart.
		pieChartCustom.getData().forEach(data -> {
			data.getNode().addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Tooltip tooltipCustom = new Tooltip(data.getName() + " " + df.format(data.getPieValue()) + "%");
					Tooltip.install(data.getNode(), tooltipCustom);
				}
			});
		});

		// display the values of slice inside regular PieChart.
		pieChartRegular.getData().forEach(data -> {
			data.getNode().addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

					Tooltip tooltipCustom = new Tooltip(data.getName() + " " + df.format(data.getPieValue()) + "%");
					Tooltip.install(data.getNode(), tooltipCustom);
				}
			});
		});
	}

	/**
	 * in this method we insert the worst and best sell of the month.
	 */
	private void insertTheWorstAndBestSell() {
		int bestSellerAmount = 0, worstSellerAmount = 99999;
		StringBuilder bestSellerName = new StringBuilder();
		StringBuilder worstSellerName = new StringBuilder();
		for (int i = 1; i < reportOnList.size(); i++) {
			List<String> productInfo = new ArrayList();
			productInfo = reportOnList.get(i);
			if (Integer.parseInt(productInfo.get(3)) > bestSellerAmount) {
				bestSellerAmount = Integer.parseInt(productInfo.get(3));
				bestSellerName = new StringBuilder();
				bestSellerName.append(productInfo.get(1) + " ");
				bestSellerName.append(productInfo.get(2));
			} else if (Integer.parseInt(productInfo.get(3)) < worstSellerAmount) {
				worstSellerAmount = Integer.parseInt(productInfo.get(3));
				worstSellerName = new StringBuilder();
				worstSellerName.append(productInfo.get(1) + " ");
				worstSellerName.append(productInfo.get(2));
			}
		}
		worstSeller.setText(worstSellerName.toString());
		bestSeller.setText(bestSellerName.toString());
	}

	/**
	 * this method insert into the diagram the products and their value according to
	 * the report , that we got from the DB
	 * 
	 * @param bouquet
	 * @param single
	 * @param series1
	 * @param series2
	 * @return
	 */
	private List<Double> insertIntoChart(Double bouquet, Double single, XYChart.Series<String, Number> series1,
			XYChart.Series<String, Number> series2) {
		int j;

		List<Double> amount = new ArrayList<>();
		for (int i = 1; i < reportOnList.size(); i++) {

			List<String> productInfo = new ArrayList();
			productInfo = reportOnList.get(i);
			if (productInfo.get(0).equals("product")) {
				StringBuilder name = new StringBuilder();
				name.append(productInfo.get(1) + " ");
				name.append(productInfo.get(2));
				series2.getData().add(new XYChart.Data<>(name.toString(), Integer.parseInt(productInfo.get(3))));
				bouquet += Integer.parseInt(productInfo.get(3));

			}
			if (productInfo.get(0).equals("item")) {
				StringBuilder name = new StringBuilder();
				name.append(productInfo.get(1) + " ");
				name.append(productInfo.get(2));
				series1.getData().add(new XYChart.Data<>(name.toString(), Integer.parseInt(productInfo.get(3))));
				single += Integer.parseInt(productInfo.get(3));

			}

		}
		amount.add(0, bouquet);
		amount.add(1, single);

		return amount;
	}

	@FXML
	void back(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		switch (ReportHandleController.getUserReport().toString()) {
		case "Branch Manager": {
			BranchManagerViewReportPageController branchPagerViewReport = new BranchManagerViewReportPageController();
			try {
				branchPagerViewReport.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "Network Manager": {
			NetworkManagerViewReportsController networkManagerViewReport = new NetworkManagerViewReportsController();
			try {
				networkManagerViewReport.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		}

	}

}
