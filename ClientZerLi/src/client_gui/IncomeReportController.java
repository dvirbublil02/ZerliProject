package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IncomeReportController implements Initializable {

	@FXML
	private Button BackBtn;

	@FXML
	private LineChart<String, Integer> IncomeLineChart;

	@FXML
	private PieChart pieChartCustom;
	@FXML
    private Label bestWeek;

    @FXML
    private Label bestDay;

    @FXML
    private Label worstDay;

    @FXML
    private Label worstWeek;
	@FXML
	private PieChart pieChartRegular;
	 @FXML
	    private Label incomeTitle;
	 List<List<String>> reportOnList = new ArrayList<>();
	    List<String> branchInfo=new ArrayList();
	    List<String> bestDayAndWorst=new ArrayList();
	    
	    
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
		reportOnList=ReportHandleController.getOrdersReportOnListMonth();
		// LineChart
		XYChart.Series series = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		insertTheDeatilsForTheCart(series, series2);
		IncomeLineChart.getData().addAll(series, series2);
	}

	private void insertTheDeatilsForTheCart(XYChart.Series series, XYChart.Series series2) {
		
		branchInfo=reportOnList.get(0);
		incomeTitle.setText("Zerli " +branchInfo.get(1)+ "(ID-"+branchInfo.get(0)+") "+branchInfo.get(2)+"-th Income based on weeks");
		series.setName("Single products");
		series2.setName("Bouqet products");
		double[] amountsPerDay=new double[32];
		Arrays.fill(amountsPerDay,0);
		int i;
		// load data to LineChart
		reportOnList.remove(0);
		Collections.sort(reportOnList,new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				
				 if(Integer.valueOf(o1.get(1)).compareTo(Integer.valueOf(o2.get(1))) >0) {
					 return 1;
				 }
				 if(Integer.valueOf(o1.get(1)).compareTo(Integer.valueOf(o2.get(1))) <0) {
					 return -1;
				 }
				 return 0;
				
			}
		});
		
		for( i=0;i<reportOnList.size();i++) {
			List<String> productInfo=new ArrayList();
			productInfo=reportOnList.get(i);
			if(productInfo.get(0).equals("product")) {
				StringBuilder week=new StringBuilder();
				week.append("Day" +" ");
				week.append(productInfo.get(1));
				series.getData().add(new XYChart.Data(week.toString(), (Integer.parseInt(productInfo.get(2))*Double.parseDouble(productInfo.get(3)))));
				amountsPerDay[Integer.parseInt(productInfo.get(1))]+=Integer.parseInt(productInfo.get(2))*Double.parseDouble(productInfo.get(3));
			}
			else if(productInfo.get(0).equals("item")) {
				StringBuilder week=new StringBuilder();
				week.append("Day" +" ");
				week.append(productInfo.get(1));
				series2.getData().add(new XYChart.Data(week.toString(), (Integer.parseInt(productInfo.get(2))*Double.parseDouble(productInfo.get(3)))));
				amountsPerDay[Integer.parseInt(productInfo.get(1))]+=Integer.parseInt(productInfo.get(2))*Double.parseDouble(productInfo.get(3));
			
			}
		}
		
		calcAndShowTheBestAndWorst(amountsPerDay);
		
	}

	private void calcAndShowTheBestAndWorst(double[] amountsPerDay) {
		double bestDay1=0,worstDay1=999999999;
		double [] amountPerWeek=new double[5];
		int bd = 0,wd = 0;
		for(int j=1;j<31;j++) {
			if(j>=1 && j<=7) amountPerWeek[1]+=amountsPerDay[j];
			if(j>=8 && j<=14) amountPerWeek[2]+=amountsPerDay[j];
			if(j>=15 && j<=22) amountPerWeek[3]+=amountsPerDay[j];
			if(j>=23 && j<=31) amountPerWeek[4]+=amountsPerDay[j];
			if(amountsPerDay[j] >bestDay1 ) {
				bestDay1=amountsPerDay[j];
				bd=j;
			}
			if(amountsPerDay[j]<worstDay1 && amountsPerDay[j]!=0) {
				
				worstDay1=amountsPerDay[j];
				wd=j;
			}
		}
		int max=0,min=999999999;
		for(int j=1; j<amountPerWeek.length;j++) {
			if(amountPerWeek[j] >max) {
				max=j;
			}
			if(amountPerWeek[j] <min &&amountPerWeek[j] !=0) {
				min=j;
			}
		}
		// add to Single(series) and Bouqet(series2)
		bestDay.setText("Day "+String.valueOf(bd));
		worstDay.setText("Day "+String.valueOf(wd)); 
		worstWeek.setText("Week "+max);
		bestWeek.setText("Week "+min);
	}

	@FXML
	void back(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		BranchManagerViewReportPageController branchPagerViewReport = new BranchManagerViewReportPageController();
		try {
			branchPagerViewReport.start(primaryStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
