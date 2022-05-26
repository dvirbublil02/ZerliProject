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
 * In this class we handling with the reportsQuaries that requaird approach to the DB .
 * @author Dvir Bublil
 *
 */
public class ReportsQuaries {

	/**
	 * in this method we getting the monthlyReport and insert it into report instance
	 * we convert the blob into byte array then we send it back to the client .
	 * @param obj
	 * @param con
	 */
	public static void getMonthlyReport(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<String> reportDetails = new ArrayList<>();
			reportDetails=(List<String>) obj.getInformation();
		
		String branchID=getBranchIdbyUserID(reportDetails.get(0),con);
		String year=reportDetails.get(1);
		String month=reportDetails.get(2);
		String reportType=reportDetails.get(3).toUpperCase();
		String duration="MONTHLY";
		try {
			insertTheSpecificReportIntoTheObj(obj, con, branchID, year, month, reportType, duration);

		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
		else {
			obj.setResponse(Response.NOT_FOUND_MONTHLY_REPORT);
			obj.setInformation(null);
		}
	}
	private static void insertTheSpecificReportIntoTheObj(TransmissionPack obj, Connection con, String branchID,
			String year, String month, String reportType, String duration) throws SQLException {
		Report returnReport = null;
		ResultSet rs;
		Statement stmt;
		String query="SELECT * FROM zerli.reports WHERE reportDuration='"+duration+"' AND branchID='"+branchID+"' AND reportType='"+reportType+"'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) {
			Blob b=rs.getBlob(6);
			InputStream in=b.getBinaryStream();
			byte [] buff=b.getBytes(1, (int)b.length());
			try {
				OutputStream out=new FileOutputStream("Monthly_Report"+branchID);
				out.write(buff);
				out.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(getMonthFormat(rs.getDate(7).toLocalDate().getMonth().getValue()).equals(month) && rs.getDate(7).toLocalDate().getYear() == Integer.parseInt(year)) {
				returnReport=new Report(rs.getString(1),ReportType.valueOf(rs.getString(2)),rs.getString(3),rs.getString(4),ReportDuration.valueOf(rs.getString(5)),buff,rs.getDate(7).toLocalDate());
				
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
 * @param ID
 * @param con
 * @return
 */
	private static String getBranchIdbyUserID(String ID, Connection con) {
		ResultSet rs;
		Statement stmt;
		String branchId=null;
		String getBranchID = "SELECT branchID FROM zerli.branchmanager WHERE branchmanagerID='"+ID+"';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBranchID);
			rs.next();
			branchId=rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchId;
	}
	
	private static String getMonthFormat(int month) {
		 String fixMonth;
		 return fixMonth= month < 9 ? fixMonth=("0" + (month)) : (fixMonth=String.valueOf(month));
	}
	/**
	 * in this method we getting the list of lists that contains all the products that been orders on  spesifc branch
	 * @param tp
	 * @return
	 */
	public static List<List<String>> gettingOrderMonthlyData(TransmissionPack tp) {
		List<List<String>> productsFromAllTheOrders=new ArrayList<>();
		ResultSet rs;
		Statement stmt;
		List<Object> information=new ArrayList<>();
		information=(List<Object>) tp.getInformation();
		String branchID=(String) information.get(0);
		String month=(String) information.get(1);
		String year=(String) information.get(2);
		List<String> ordersID = new ArrayList<>();
		Connection con=DBController.getCon();
		gettingTheRelavantOrdersID(branchID, month,year, ordersID, con);
		
			if(ordersID.size()>0) {
				for(int i = 0 ;i<ordersID.size();i++) {
				String getBranchOrderProucts="SELECT itemType,nameOfItem,productQuantityInOrder from zerli.productinorder WHERE orderID='"+ordersID.get(i)+"';";
			
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(getBranchOrderProucts);
					while(rs.next()) {
						List<String> productsFromOrder=new ArrayList<>();
						productsFromOrder.add(rs.getString(1));
						productsFromOrder.add(rs.getString(2));
						productsFromOrder.add(rs.getString(3));
						productsFromAllTheOrders.add(productsFromOrder);
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
				return productsFromAllTheOrders;

			}
			return productsFromAllTheOrders;
	}
	/**
	 * in this method we inserting monthly report for specific branch and specific month.
	 * @param object
	 */
	public static void createMonthlyReport(List<Object> object) {
		String branchID=(String) object.get(0);
		String Date=(String) object.get(2);
		String type=(String) object.get(3);
		Connection con=DBController.getCon();
		PreparedStatement stmt;
		List<List<String>> orders=(List<List<String>>) object.get(1);
		String branchName=getBranchNamebyBranchID(branchID,con);
		StringBuilder stringBuilder=new StringBuilder();
		if(branchName !=null ) {
			stringBuilder.append(branchID+" "+branchName+" "+Date);
			if(type.equals(ReportType.ORDERS.name())){
			for(List<String> row: orders) {
				stringBuilder.append("\n"+ row.get(0)+" " + row.get(1)+" " + row.get(2));
			}
			}else {
				for(List<String> row: orders)
				stringBuilder.append("\n"+ row.get(0)+" " + row.get(1)+" " + row.get(2)+" " + row.get(3));
			}
			
			byte[] byteConent = stringBuilder.toString().getBytes();
			Blob blob=null;
			String query="INSERT INTO zerli.reports(reportID, reportType, branchID, reportCreator, reportDuration, reportFile, reportDate) VALUES (?,?,?,?,?,?,?)";
			try {
				blob = new SerialBlob(byteConent);
				stmt = con.prepareStatement(query);
				stmt.setString(1,null);
				stmt.setString(2,type);
				stmt.setString(3, branchID);
				stmt.setString(4, "System");
				stmt.setString(5, ReportDuration.MONTHLY.name());
				stmt.setBlob(6, blob);
				stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
				stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();	
		} 
		}
		
	}
	/**
	 * this method return the branch name by using the branchID
	 * @param ID
	 * @param con
	 * @return
	 */
	private static String getBranchNamebyBranchID(String ID, Connection con) {
		ResultSet rs;
		Statement stmt;
		String branchName=null;
		String getBranchName = "SELECT branchName FROM zerli.branchs WHERE branchID='"+ID+"';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBranchName);
			rs.next();
			branchName=rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchName;
	}
	public static List<List<String>> gettingIncomeMonthlyData(TransmissionPack tp) {
		List<List<String>> incomeFromAllOrders=new ArrayList<>();
		ResultSet rs;
		Statement stmt;
		List<Object> information=new ArrayList<>();
		information=(List<Object>) tp.getInformation();
		String branchID=(String) information.get(0);
		String date=(String) information.get(1);
		String year=(String) information.get(2);
		List<String> ordersID = new ArrayList<>();
		Connection con=DBController.getCon();
		List<LocalDate> ordersDate=gettingTheRelavantOrdersID(branchID, date, year,ordersID, con);
		
			if(ordersID.size()>0) {
				for(int i = 0 ;i<ordersID.size();i++) {
				String getBranchIncomeProucts="SELECT itemType,productQuantityInOrder,price from zerli.productinorder WHERE orderID='"+ordersID.get(i)+"';";
				LocalDate LocalDate = ordersDate.get(i);
				
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(getBranchIncomeProucts);
					while(rs.next()) {
						List<String> productsFromOrder=new ArrayList<>();
						productsFromOrder.add(rs.getString(1));
						productsFromOrder.add(Integer.toString(LocalDate.getDayOfMonth()));
						productsFromOrder.add(rs.getString(2));
						productsFromOrder.add(rs.getString(3));
						incomeFromAllOrders.add(productsFromOrder);
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
				return incomeFromAllOrders;

			}
			return incomeFromAllOrders;
	}
	/*
	 * this method getting the orders id's by branchID and the relevant date (for example all the orders in 05 month)
	 */
	private static List<LocalDate> gettingTheRelavantOrdersID(String branchID, String month,String year, List<String> ordersID,
			Connection con) {
		ResultSet rs;
		Statement stmt;
		List<LocalDate> ordersDate = new ArrayList<>();
		String getBrnachOrders="SELECT orderID,orderDate from zerli.order WHERE branchID='"+branchID+"';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBrnachOrders);
			while(rs.next()) {
				if(getMonthFormat(rs.getDate(2).toLocalDate().getMonth().getValue()).equals(month) && rs.getDate(7).toLocalDate().getYear() == Integer.parseInt(year)) {
					ordersID.add(rs.getString(1));
					ordersDate.add(rs.getDate(2).toLocalDate());
				}
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return ordersDate;
		
	}
	public static void getQuarterIncomeReport(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<String> reportDetails = new ArrayList<>();
			reportDetails=(List<String>) obj.getInformation();
			
		}
		
		
	}

}

