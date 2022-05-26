package client;

import java.util.ArrayList;
import java.util.List;

public class ReportHandleController {
	private static List<List<String>> OrdersReportOnListMonth= new ArrayList<>();
	private static List<List<String>> OrdersReportOnListQuarter=new ArrayList<>();
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
}
