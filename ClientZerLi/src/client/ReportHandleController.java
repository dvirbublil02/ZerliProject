package client;

import java.util.ArrayList;
import java.util.List;

import entities_users.User;

public class ReportHandleController {
	private static List<List<String>> OrdersReportOnListMonth= new ArrayList<>();
	private static List<List<String>> OrdersReportOnListQuarter=new ArrayList<>();
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

	public static User getUserReport() {
		return userReport;
	}

	public static void setUserReport(User user) {
		ReportHandleController.userReport = user;
	}
	
}
