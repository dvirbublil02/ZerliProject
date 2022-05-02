package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class OrderReportsController implements Initializable {

	@FXML
	private Button BackBtn;

	@FXML
	private BarChart<String, Number> barChart;

	@FXML
	private PieChart pieChartCustom;

	@FXML
	private PieChart pieChartRegular;

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

		// LineChart
		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
		XYChart.Series<String, Number> series2 = new XYChart.Series<>();
		series1.setName("regular products");
		series2.setName("custom products");

		// load data to LineChart
		series1.getData().add(new XYChart.Data<>("Birthday Boquet", 14));
		series1.getData().add(new XYChart.Data<>("Bride Boquet", 16));
		series1.getData().add(new XYChart.Data<>("Holiday Boquet", 11));
		series1.getData().add(new XYChart.Data<>("Casual Boquet", 16));
		series1.getData().add(new XYChart.Data<>("Colorful Boquet", 12));

		series2.getData().add(new XYChart.Data<>("Red Rose", 46));
		series2.getData().add(new XYChart.Data<>("Blue Rose", 33));
		series2.getData().add(new XYChart.Data<>("Yellow Tulip", 35));
		series2.getData().add(new XYChart.Data<>("White Tulip", 28));
		series2.getData().add(new XYChart.Data<>("Bazil Plant", 89));

		// add to regular(series) and Custom(series2)
		barChart.getData().addAll(series1, series2);
/////////////////////////////////////////////---PieChart--//////////////////////////////////////////
		// PieChart - custom
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				// potted ,flower, plant
				new PieChart.Data("Red Rose", 15.3), new PieChart.Data("Blue Rose", 11),
				new PieChart.Data("Yellow Tulip", 11.6), new PieChart.Data("White Tulip", 9.3),
				new PieChart.Data("Bazil Plant", 29.9));
		// custom setData + angle by 90 degree
		pieChartCustom.setData(pieChartData);
		pieChartCustom.setStartAngle(90);

		// PieChart - regular
		ObservableList<PieChart.Data> pieChartData2 = FXCollections.observableArrayList(
				// potted ,flower, plant
				new PieChart.Data("Birthday Boquet", 4.6), new PieChart.Data("Bride Boquet", 5.3),
				new PieChart.Data("Holiday Boquet", 3.6), new PieChart.Data("Casual Boquet", 5.3),
				new PieChart.Data("Colorful Boquet", 4));
		// regular setData + angle by 90 degree
		pieChartRegular.setData(pieChartData2);
		pieChartRegular.setStartAngle(90);

//////////////////////---PieChart MouseEvent(regular + Custom)--//////////////////////////////////////////
		// display the values of slice inside custom PieChart.
		pieChartCustom.getData().forEach(data -> {
			data.getNode().addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// System.out.println(data.getName()+ " " + data.getPieValue());
					Tooltip tooltipCustom = new Tooltip(data.getName() + " " + data.getPieValue() + "%");
					Tooltip.install(data.getNode(), tooltipCustom);
				}
			});
		});

		// display the values of slice inside regular PieChart.
		pieChartRegular.getData().forEach(data -> {
			data.getNode().addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// System.out.println(data.getName()+ " " + data.getPieValue());
					Tooltip tooltipCustom = new Tooltip(data.getName() + " " + data.getPieValue() + "%");
					Tooltip.install(data.getNode(), tooltipCustom);
				}
			});
		});

	}

	@FXML
	void logOut(ActionEvent event) {
	}

}
