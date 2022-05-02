package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import communication.TransmissionPack;
import server_gui.ServerScreenController;

/**
 * This class will be responsible for the connection between the data base and
 * the server. also Analyze and execute the quarries
 * 
 *
 */
public class DBController {
	private static Connection con;

	/**
	 * In this method we parsing the TransmissionPack that we got from the client by
	 * the server. (by calling the MissionAnalyze)
	 * 
	 * @param obj
	 */
	public static void parsingToData(TransmissionPack obj) {
		MissionAnalyze.MissionsAnalyze(obj, con);
	}

	/**
	 * In this method we connecting the host to the DB .
	 *  the method returning if the connection success or not (true/false)
	 * @param data
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static boolean connectToDB(List<String> data) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//	        System.out.println("Driver definition succeed");
			ServerScreenController.SetMsg("Driver definition succeed");

		} catch (Exception ex) {
			/* handle the error */
//	    	 System.out.println("Driver definition failed");
			ServerScreenController.SetMsg("Driver definition failed");
		}
		try {
			con = DriverManager.getConnection(data.get(0), data.get(1), data.get(2));
			data.clear();
//	        System.out.println("SQL connection succeed");
			ServerScreenController.SetMsg("SQL connection succeed");
		} catch (SQLException ex) {/* handle any errors */
			data.clear();
//	        System.out.println("SQLException: " + ex.getMessage());
//	        System.out.println("SQLState: " + ex.getSQLState());
//	        System.out.println("VendorError: " + ex.getErrorCode());
			ServerScreenController.SetMsg("SQLException: " + ex.getMessage());
			ServerScreenController.SetMsg("SQLState: " + ex.getSQLState());
			ServerScreenController.SetMsg("VendorError: " + ex.getErrorCode());
			return false;
		}
		return true;
	}

}
