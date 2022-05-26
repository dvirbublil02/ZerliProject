package DataBase;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import communication.Response;
import communication.TransmissionPack;
import entities_reports.Report;
import enums.ReportDuration;
import enums.ReportType;

/**
 * In this class we handling with the reportsQuaries that requaird approach to
 * the DB .
 * 
 * @author Dvir Bublil
 *
 */
public class ReportsQuaries {

	/**
	 * in this method we getting the monthlyReport and insert it into report
	 * instance we convert the blob into byte array then we send it back to the
	 * client .
	 * 
	 * @param obj
	 * @param con
	 */
	public static void getMonthlyReport(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<String> reportDetails = new ArrayList<>();
			reportDetails = (List<String>) obj.getInformation();

			String branchID = getBranchIdbyUserID(reportDetails.get(0), con);
			String year = reportDetails.get(1);
			String month = reportDetails.get(2);
			String reportType = reportDetails.get(3).toUpperCase();
			String duration = "MONTHLY";
			try {
				insertTheSpecificReportIntoTheObj(obj, con, branchID, year, month, reportType, duration);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			obj.setResponse(Response.NOT_FOUND_MONTHLY_REPORT);
			obj.setInformation(null);
		}
	}

	private static void insertTheSpecificReportIntoTheObj(TransmissionPack obj, Connection con, String branchID,
			String year, String month, String reportType, String duration) throws SQLException {
		Report returnReport = null;
		ResultSet rs;
		Statement stmt;
		String query = "SELECT * FROM zerli.reports WHERE reportDuration='" + duration + "' AND branchID='" + branchID
				+ "' AND reportType='" + reportType + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			Blob b = rs.getBlob(6);
			InputStream in = b.getBinaryStream();
			byte[] buff = b.getBytes(1, (int) b.length());
			try {
				OutputStream out = new FileOutputStream("Monthly_Report" + branchID);
				out.write(buff);
				out.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (getMonthFormat(rs.getDate(7).toLocalDate().getMonth().getValue()).equals(month)
					&& rs.getDate(7).toLocalDate().getYear() == Integer.parseInt(year)) {
				returnReport = new Report(rs.getString(1), ReportType.valueOf(rs.getString(2)), rs.getString(3),
						rs.getString(4), ReportDuration.valueOf(rs.getString(5)), buff, rs.getDate(7).toLocalDate());

			}

		}

		if (returnReport != null) {
			obj.setResponse(Response.FOUND_MONTHLY_REPORT);
			obj.setInformation(returnReport);
			return;
		} else {
			obj.setResponse(Response.NOT_FOUND_MONTHLY_REPORT);
			obj.setInformation(null);
		}
	}

	/**
	 * in this method we getting branch id by user id
	 * 
	 * @param ID
	 * @param con
	 * @return
	 */
	private static String getBranchIdbyUserID(String ID, Connection con) {
		ResultSet rs;
		Statement stmt;
		String branchId = null;
		String getBranchID = "SELECT branchID FROM zerli.branchmanager WHERE branchmanagerID='" + ID + "';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBranchID);
			rs.next();
			branchId = rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchId;
	}

	private static String getMonthFormat(int month) {
		String fixMonth;
		return fixMonth = month < 9 ? fixMonth = ("0" + (month)) : (fixMonth = String.valueOf(month));
	}

	/**
	 * in this method we getting the list of lists that contains all the products
	 * that been orders on spesifc branch
	 * 
	 * @param tp
	 * @return
	 */
	public static List<List<String>> gettingOrderMonthlyData(TransmissionPack tp) {
		List<List<String>> productsFromAllTheOrders = new ArrayList<>();
		ResultSet rs;
		Statement stmt;
		List<Object> information = new ArrayList<>();
		information = (List<Object>) tp.getInformation();
		String branchID = (String) information.get(0);
		String month = (String) information.get(1);
		String year = (String) information.get(2);
		List<String> ordersID = new ArrayList<>();
		Connection con = DBController.getCon();
		gettingTheRelavantOrdersID(branchID, month, year, ordersID, con);

		if (ordersID.size() > 0) {
			for (int i = 0; i < ordersID.size(); i++) {
				String getBranchOrderProucts = "SELECT itemType,nameOfItem,productQuantityInOrder from zerli.productinorder WHERE orderID='"
						+ ordersID.get(i) + "';";

				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(getBranchOrderProucts);
					while (rs.next()) {
						List<String> productsFromOrder = new ArrayList<>();
						productsFromOrder.add(rs.getString(1));
						productsFromOrder.add(rs.getString(2));
						productsFromOrder.add(rs.getString(3));
						productsFromAllTheOrders.add(productsFromOrder);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return productsFromAllTheOrders;

		}
		return productsFromAllTheOrders;
	}

	/**
	 * in this method we inserting monthly report for specific branch and specific
	 * month.
	 * 
	 * @param object
	 */
	public static void createMonthlyReport(List<Object> object) {
		String branchID = (String) object.get(0);
		String Date = (String) object.get(2);
		String type = (String) object.get(3);
		Connection con = DBController.getCon();
		PreparedStatement stmt;
		List<List<String>> orders = (List<List<String>>) object.get(1);
		String branchName = getBranchNamebyBranchID(branchID, con);
		StringBuilder stringBuilder = new StringBuilder();
		if (branchName != null) {
			stringBuilder.append(branchID + " " + branchName + " " + Date);
			if (type.equals(ReportType.ORDERS.name())) {
				for (List<String> row : orders) {
					stringBuilder.append("\n" + row.get(0) + " " + row.get(1) + " " + row.get(2));
				}
			} else {
				for (List<String> row : orders)
					stringBuilder.append("\n" + row.get(0) + " " + row.get(1) + " " + row.get(2) + " " + row.get(3));
			}

			byte[] byteConent = stringBuilder.toString().getBytes();
			Blob blob = null;
			String query = "INSERT INTO zerli.reports(reportID, reportType, branchID, reportCreator, reportDuration, reportFile, reportDate) VALUES (?,?,?,?,?,?,?)";
			try {
				blob = new SerialBlob(byteConent);
				stmt = con.prepareStatement(query);
				stmt.setString(1, null);
				stmt.setString(2, type);
				stmt.setString(3, branchID);
				stmt.setString(4, "System");
				stmt.setString(5, ReportDuration.MONTHLY.name());
				stmt.setBlob(6, blob);
				stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * this method return the branch name by using the branchID
	 * 
	 * @param ID
	 * @param con
	 * @return
	 */
	private static String getBranchNamebyBranchID(String ID, Connection con) {
		ResultSet rs;
		Statement stmt;
		String branchName = null;
		String getBranchName = "SELECT branchName FROM zerli.branchs WHERE branchID='" + ID + "';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBranchName);
			if (rs.next() == true)
				branchName = rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchName;
	}

	public static List<List<String>> gettingIncomeMonthlyData(TransmissionPack tp) {
		List<List<String>> incomeFromAllOrders = new ArrayList<>();
		ResultSet rs;
		Statement stmt;
		List<Object> information = new ArrayList<>();
		information = (List<Object>) tp.getInformation();
		String branchID = (String) information.get(0);
		String date = (String) information.get(1);
		String year = (String) information.get(2);
		List<String> ordersID = new ArrayList<>();
		Connection con = DBController.getCon();
		List<LocalDate> ordersDate = gettingTheRelavantOrdersID(branchID, date, year, ordersID, con);

		if (ordersID.size() > 0) {
			for (int i = 0; i < ordersID.size(); i++) {
				String getBranchIncomeProucts = "SELECT itemType,productQuantityInOrder,price from zerli.productinorder WHERE orderID='"
						+ ordersID.get(i) + "';";
				LocalDate LocalDate = ordersDate.get(i);

				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(getBranchIncomeProucts);
					while (rs.next()) {
						List<String> productsFromOrder = new ArrayList<>();
						productsFromOrder.add(rs.getString(1));
						productsFromOrder.add(Integer.toString(LocalDate.getDayOfMonth()));
						productsFromOrder.add(rs.getString(2));
						productsFromOrder.add(rs.getString(3));
						incomeFromAllOrders.add(productsFromOrder);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return incomeFromAllOrders;

		}
		return incomeFromAllOrders;
	}

	/*
	 * this method getting the orders id's by branchID and the relevant date (for
	 * example all the orders in 05 month)
	 */
	private static List<LocalDate> gettingTheRelavantOrdersID(String branchID, String month, String year,
			List<String> ordersID, Connection con) {
		ResultSet rs;
		Statement stmt;
		List<LocalDate> ordersDate = new ArrayList<>();
		String getBrnachOrders = "SELECT orderID,orderDate from zerli.order WHERE branchID='" + branchID + "';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBrnachOrders);
			while (rs.next()) {
				if (getMonthFormat(rs.getDate(2).toLocalDate().getMonth().getValue()).equals(month)
						&& rs.getDate(2).toLocalDate().getYear() == Integer.parseInt(year)) {
					ordersID.add(rs.getString(1));
					ordersDate.add(rs.getDate(2).toLocalDate());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersDate;

	}

	/**
	 * in this method we createing the QuarterReport. here there is implemnetion of
	 * income and order report .
	 * 
	 * @param obj
	 * @param con
	 * @return
	 */
	@SuppressWarnings("unused")
	public static boolean createQuarterReportInformation(TransmissionPack obj) {
		if (obj instanceof TransmissionPack) {
			Connection con = DBController.getCon();
			List<String> reportDetails = new ArrayList<>();
			reportDetails = (List<String>) obj.getInformation();
			String branch = reportDetails.get(0);
			String year = reportDetails.get(1);
			String quarter = reportDetails.get(2);
			String reportType = reportDetails.get(3);

			List<List<String>> InfoFirstMonth = new ArrayList<>();
			List<List<String>> InfoSecondMonth = new ArrayList<>();
			List<List<String>> InfoThirdMonth = new ArrayList<>();
			TransmissionPack Month = new TransmissionPack(null, null, null);
			int countMonths = 3;
			switch (Integer.parseInt(quarter)) {
			case 1: {
				InfoFirstMonth = returnMonthInfoForReport(branch, "01", year);
				if (InfoFirstMonth.size() == 0) {
					countMonths--;
				}
				InfoSecondMonth = returnMonthInfoForReport(branch, "02", year);
				if (InfoSecondMonth.size() == 0) {
					countMonths--;
				}
				InfoThirdMonth = returnMonthInfoForReport(branch, "03", year);
				if (InfoThirdMonth.size() == 0) {
					countMonths--;
				}
				break;
			}
			case 2: {
				InfoFirstMonth = returnMonthInfoForReport(branch, "04", year);
				if (InfoFirstMonth.size() == 0) {
					countMonths--;
				}
				InfoSecondMonth = returnMonthInfoForReport(branch, "05", year);
				if (InfoSecondMonth.size() == 0) {
					countMonths--;
				}
				InfoThirdMonth = returnMonthInfoForReport(branch, "06", year);
				if (InfoThirdMonth.size() == 0) {
					countMonths--;
				}
				break;
			}
			case 3: {
				InfoFirstMonth = returnMonthInfoForReport(branch, "07", year);
				if (InfoFirstMonth.size() == 0) {
					countMonths--;
				}
				InfoSecondMonth = returnMonthInfoForReport(branch, "08", year);
				if (InfoSecondMonth.size() == 0) {
					countMonths--;
				}
				InfoThirdMonth = returnMonthInfoForReport(branch, "09", year);
				if (InfoThirdMonth.size() == 0) {
					countMonths--;
				}
				break;
			}
			case 4: {
				InfoFirstMonth = returnMonthInfoForReport(branch, "10", year);
				if (InfoFirstMonth.size() == 0) {
					countMonths--;
				}
				InfoSecondMonth = returnMonthInfoForReport(branch, "11", year);
				if (InfoSecondMonth.size() == 0) {
					countMonths--;
				}
				InfoThirdMonth = returnMonthInfoForReport(branch, "12", year);
				if (InfoThirdMonth.size() == 0) {
					countMonths--;
				}
				break;
			}
			}
			StringBuilder stringBuilder = new StringBuilder();
			String branchName = getBranchNamebyBranchID(branch, con);
			stringBuilder.append(branch + " " + branchName + " " + quarter);
			if (reportType.equals(ReportType.ORDERS.name()) && countMonths > 0) {
				if (InfoFirstMonth != null) {
					for (List<String> row : InfoFirstMonth)
						stringBuilder.append("\n quarter1 " + row.get(0) + " " + row.get(1) + " " + row.get(2));
				}
				if (InfoSecondMonth != null) {
					for (List<String> row : InfoSecondMonth)
						stringBuilder.append("\n quarter2 " + row.get(0) + " " + row.get(1) + " " + row.get(2));
				}
				if (InfoThirdMonth != null) {
					for (List<String> row : InfoThirdMonth)
						stringBuilder.append("\n quarter3 " + row.get(0) + " " + row.get(1) + " " + row.get(2));
				}
			} else { // income report
				if (InfoFirstMonth != null) {
					for (List<String> row : InfoFirstMonth)
						stringBuilder.append(
								"\nquarter1 " + row.get(0) + " " + row.get(1) + " " + row.get(2) + " " + row.get(3));
				}
				if (InfoSecondMonth != null) {
					for (List<String> row : InfoSecondMonth)
						stringBuilder.append(
								"\nquarter2 " + row.get(0) + " " + row.get(1) + " " + row.get(2) + " " + row.get(3));
				}
				if (InfoThirdMonth != null) {
					for (List<String> row : InfoThirdMonth)
						stringBuilder.append(
								"\nquarter3 " + row.get(0) + " " + row.get(1) + " " + row.get(2) + " " + row.get(3));
				}
			}
			System.out.println(countMonths);
			if (countMonths > 0) {
				PreparedStatement stmt;
				byte[] byteConent = stringBuilder.toString().getBytes();
				Blob blob = null;
				String query = "INSERT INTO zerli.reports(reportID, reportType, branchID, reportCreator, reportDuration, reportFile, reportDate) VALUES (?,?,?,?,?,?,?)";
				try {
					blob = new SerialBlob(byteConent);
					stmt = con.prepareStatement(query);
					stmt.setString(1, null);
					stmt.setString(2, reportType);
					stmt.setString(3, branch);
					stmt.setString(4, "System");
					stmt.setString(5, ReportDuration.QUARTERLY.name());
					stmt.setBlob(6, blob);
					stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
					stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * this method returning the monthly report information to be use on the
	 * function above
	 * 
	 * @param branchID
	 * @param month
	 * @param year
	 * @return
	 */
	public static List<List<String>> returnMonthInfoForReport(String branchID, String month, String year) {
		TransmissionPack Month = new TransmissionPack(null, null, null);
		List<List<String>> incomeInfo = new ArrayList<>();
		List<Object> information = new ArrayList<>();
		information.add(branchID);
		information.add(month);
		information.add(year);
		Month.setInformation(information);
		incomeInfo = gettingIncomeMonthlyData(Month);
		return incomeInfo;
	}

	

	public static void getQuarterIncomeReport(TransmissionPack obj, Connection con) {
	
		if(obj instanceof TransmissionPack) {
			List<String> reportRequest=new ArrayList<>();
			reportRequest=(List<String>) obj.getInformation();
			String branchID=reportRequest.get(0);
			String year=reportRequest.get(1);
			String quater=reportRequest.get(2);
			String month=getMonthForQuater(quater);
			Report returnReport = null;
			ResultSet rs;
			Statement stmt;
			String query = "SELECT * FROM zerli.reports WHERE branchID='" + branchID + "' AND reportDuration='QUARTERLY'";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				 if(rs.next() == true) {
					if (getMonthFormat(rs.getDate(7).toLocalDate().getMonth().getValue()).equals(month)
							&& rs.getDate(7).toLocalDate().getYear() == Integer.parseInt(year)) {
						Blob b=rs.getBlob(6);
						InputStream in=b.getBinaryStream();
						byte[] buff=b.getBytes(1, (int) b.length());
						returnReport = new Report(rs.getString(1), ReportType.valueOf(rs.getString(2)), rs.getString(3),
								rs.getString(4), ReportDuration.valueOf(rs.getString(5)), buff, rs.getDate(7).toLocalDate());
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (returnReport != null) {
				obj.setResponse(Response.FOUND_QUARENTY_INCOME_REPORT);
				obj.setInformation(returnReport);
				return;
			} else {
				obj.setResponse(Response.NOT_FOUND_MONTHLY_REPORT);
				obj.setInformation(null);
			}
		}
				obj.setResponse(Response.NOT_FOUND_MONTHLY_REPORT);
				obj.setInformation(null);
	}


	private static String getMonthForQuater(String quater) {
		String returnMonth = null;
		switch(Integer.parseInt(quater)) {
		case 1:{ return returnMonth="03";
		}
		case 2:{ return returnMonth="06";
		}
		case 3:{ return returnMonth="09";
		}
		case 4:{ return returnMonth="12";
		}
	}
		return returnMonth;

	}
}
