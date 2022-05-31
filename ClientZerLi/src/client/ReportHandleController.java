package client;

import java.util.ArrayList;
import java.util.List;

public class ReportHandleController {
	private static List<List<String>> OrdersReportOnListMonth= new ArrayList<>();

	public static List<List<String>> getOrdersReportOnListMonth() {
		return OrdersReportOnListMonth;
	}

	public static void setOrdersReportOnListMonth(List<List<String>> ordersReportOnListMonth) {
		OrdersReportOnListMonth = ordersReportOnListMonth;
	}
}
