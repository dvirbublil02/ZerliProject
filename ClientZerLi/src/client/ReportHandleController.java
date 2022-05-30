package client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities_users.User;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;

public class ReportHandleController {
	private static List<List<String>> OrdersReportOnListMonth= new ArrayList<>();
	private static List<List<String>> OrdersReportOnListQuarter=new ArrayList<>();
	private static List<List<String>> SurveyReportResult=new ArrayList<>();
	private static User userReport;
	public static List<List<String>> getOrdersReportOnListMonth() {
		return OrdersReportOnListMonth;
	}

	public static void setOrdersReportOnListMonth(List<List<String>> ordersReportOnListMonth) {
		OrdersReportOnListMonth = ordersReportOnListMonth;
	}

	public static List<List<String>> getOrdersReportOnListQuarter() {
		return OrdersReportOnListQuarter;
	}

	public static void setOrdersReportOnListQuarter(List<List<String>> ordersReportOnListQuarter) {
		OrdersReportOnListQuarter = ordersReportOnListQuarter;
	}

	public static List<List<String>> getSurveyReportResult() {
		return SurveyReportResult;
	}
	
	public static void setSurveyReportResult(List<List<String>> surveyReportResult) {
		SurveyReportResult = surveyReportResult;
	}
	public static User getUserReport() {
		return userReport;
	}

	public static void setUserReport(User user) {
		ReportHandleController.userReport = user;
	}
	
	@SuppressWarnings("unchecked")
	public static void insertTheDeatilsForTheCartQurateryReport(Label worstMonth, Label bestMonth, Label incomeQuarterTitle, List<List<String>> reportOnList, Series series, Series series2, Series series3) {
		List<String> reportInfo = new ArrayList();
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
		double [] MaxMin=new double[4];
		for (int i = 0; i < reportOnList.size(); i++) {
			List<String> productInfo = new ArrayList<>();
			productInfo = reportOnList.get(i);
			if (productInfo.get(0).equals("month1")) {
				MaxMin[1]+=Integer.parseInt(productInfo.get(3)) * Double.parseDouble(productInfo.get(4));
			} else if (productInfo.get(0).equals("month2")) {
				MaxMin[2]+=Integer.parseInt(productInfo.get(3)) * Double.parseDouble(productInfo.get(4));

			} else if (productInfo.get(0).equals("month3")) {
				MaxMin[3]+=Integer.parseInt(productInfo.get(3)) * Double.parseDouble(productInfo.get(4));

			}
		}
		StringBuilder day=new StringBuilder();
		day.append("0 - 1(Month)");
		series.getData().add(new XYChart.Data(day.toString(),
				(MaxMin[1])));
		 day=new StringBuilder();
		day.append("1 - 2(Month)");
		series2.getData().add(new XYChart.Data(day.toString(),
				(MaxMin[2])));
		 day=new StringBuilder();
		day.append("2 - 3(Month)");
		series3.getData().add(new XYChart.Data(day.toString(),
				(MaxMin[3])));
		if(MaxMin[1]>MaxMin[2] && MaxMin[2]<=MaxMin[3]) {
			bestMonth.setText("First month of this querter");
			worstMonth.setText("Second month of this querter");
		}
		else if(MaxMin[1]>MaxMin[2]) {
			bestMonth.setText("First month of this querter");
			worstMonth.setText("Third month of this querter");
		}
		else if(MaxMin[2]>MaxMin[1] && MaxMin[1]<=MaxMin[3]) {
			bestMonth.setText("Second month of this querter");
			worstMonth.setText("First month of this querter");
		}
		else if(MaxMin[2]>MaxMin[1] ) {
			bestMonth.setText("Second month of this querter");
			worstMonth.setText("Third month of this querter");
		}
		else if(MaxMin[3]>MaxMin[1] && MaxMin[1]<=MaxMin[2]) {
			bestMonth.setText("Third month of this querter");
			worstMonth.setText("First month of this querter");
		}
		else if(MaxMin[3]>MaxMin[1] ) {
			bestMonth.setText("Third month of this querter");
			worstMonth.setText("Second month of this querter");
		}
		
	

	}

	
}
