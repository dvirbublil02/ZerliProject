package DataBase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import communication.Mission;
import communication.TransmissionPack;

/**
 * class that run thread that check if there is new month it create new report
 * for each branch and after 24 hours it notify to all customer service that
 * stll don't close there complaint that are still open
 * 
 * @author Mor Ben Haim
 */
public class TimerRunner extends TimerTask {

	Date current = new Date();

	@Override
	public void run() {
		Date newDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(newDate);
		System.out.println(sdf.format(newDate));
		c.add(Calendar.MONTH, -1);
		System.out.println(sdf.format(newDate));

		Date prevMonth = c.getTime();
		c.add(Calendar.MONTH, -2);
		Date prevQuarter = c.getTime();
	//	if(current.getDay()!= newDate.getDay()) {
			System.out.println("New Day");
			//TBD : Add actions after one day.
			//String budgetType = BudgetType.DAILY.toString();
			TransmissionPack obj=new TransmissionPack(Mission.NOTIFY,null,null);
			MissionAnalyze.MissionsAnalyze(obj, DBController.getCon());
//			ServerQuaries.notifyCustomerService(obj,DBController.getCon());
	//	}
		
		if (current.getMonth() != newDate.getMonth()) {
			System.out.println("New Month");
			// TBD : Add actions after one month.
			
			List<String> reportCreate = ServerQuaries.getAllBranchId(DBController.getCon());
			for (String b : reportCreate) {
				String month=ReportsQuaries.getMonthFormat(newDate.getMonth() + 1);
				createReports.monthlyIncome(b, month,String.valueOf(current.getYear()));
				createReports.monthlyOrders(b, month,String.valueOf(current.getYear()));
			}

		}
		
//		if(current.getDay() > newDate.getDay()) {
//			System.out.println("New Week");
//			//TBD : Add actions after one week.
//			String budgetType = BudgetType.WEEKLY.toString();
//			Query.updateBusinessCustomersBudgetUsed("budgetType='"+budgetType+"'"); //update budgetUsed to 0 every week for weekly budget type
//			
//		}
//		
//		if((current.getMonth() /3 ) + 1 !=  (newDate.getMonth()/3) + 1) {
//			System.out.println("New Quarater");
//			//TBD : Add actions after one quarter.
//			ReportsController.pullData(sdf.format(prevQuarter), sdf.format(newDate), "quarterly");
//			ReportsController.uploadReports();
//		}

		current = newDate;

	}
}
