package DataBase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import communication.Mission;
import communication.TransmissionPack;
import entities_reports.Report;
import enums.ReportType;
/**
 * this class handling with createing the reports 
 * @author Dvir Bublil
 *
 */
public class createReports {
	/*
	 * in this method creating order monthly report by spesifc branch and month (getting the month on number 2 digit )
	 */
	public static void monthlyOrders(String branchID,String month) {
		List<List<String>> orders=new ArrayList<>();
		List<Object> orderFilter=new ArrayList<>();
		orderFilter.add(branchID);
		orderFilter.add(month);
		TransmissionPack tp=new TransmissionPack(Mission.GET_MONTHLY_REPORT,null,orderFilter);
		orders=ReportsQuaries.gettingOrderMonthlyData(tp);
		
		if(orders != null) {
			List<Object> orderInfoToParse=new ArrayList<>();
			orderInfoToParse.add(branchID);
			orderInfoToParse.add(orders);
			orderInfoToParse.add(month);
			String type=ReportType.ORDERS.name();
			orderInfoToParse.add(type);
			ReportsQuaries.createMonthlyReport(orderInfoToParse);
		}
		
	}
/*
 * in this method we creating income monthly report by spesifc branch and spesifc month.
 */
	public static void monthlyIncome(String branchID, String Date) {
		List<List<String>> incomeInfo=new ArrayList<>();
		List<Object> incomeFilter=new ArrayList<>();
		incomeFilter.add(branchID);
		incomeFilter.add(Date);
		TransmissionPack tp=new TransmissionPack(Mission.GET_MONTHLY_REPORT,null,incomeFilter);
		incomeInfo=ReportsQuaries.gettingIncomeMonthlyData(tp);
		if(incomeInfo != null) {
			List<Object> incomeInfoToParse=new ArrayList<>();
			incomeInfoToParse.add(branchID);
			incomeInfoToParse.add(incomeInfo);
			incomeInfoToParse.add(Date);
			String type=ReportType.INCOME.name();
			incomeInfoToParse.add(type);
			ReportsQuaries.createMonthlyReport(incomeInfoToParse);
		}
		
	}
}
