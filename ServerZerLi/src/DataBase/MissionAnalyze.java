package DataBase;

import java.sql.Connection;
import java.util.ArrayList;

import communication.TransmissionPack;

/**
 * In this class we analyze the mission that we got from the client , and then
 * we go into the right queries(ServerQuries) by switch case. according to the
 * specific mission each case will handle specific mission
 */
public class MissionAnalyze {
	public static ArrayList<String> list = new ArrayList<String>();

	@SuppressWarnings("incomplete-switch")
	public static void MissionsAnalyze(TransmissionPack obj, Connection con) {

		switch (obj.getMission()) {
		case ADD_ORDER: {
		//	ServerQuaries.AddOrderToDB(obj, con);
			break;
		}
		case EDIT_ORDER: {
	//		ServerQuaries.EditOrderOnDB(obj, con);
			break;
		}
		case GET_ORDERS: {
	//		ServerQuaries.GetOrderFromDB(obj, con);
			break;
		}

		case SEND_CONNECTION_DETAILS: {

			Utils.updateConnectionWindow(obj);
			break;
		}
		case SEND_DISCONNECT_DETAILS: {

			Utils.updateDisConnectionWindow(obj);
			break;
		}

		case USER_LOGIN: {

			//ServerQuaries.getUser(obj, con);
			ServerQuaries.Login(obj, con);
			break;
			}
		case USER_LOGOUT:{
			ServerQuaries.logout(obj,con);
			break;
		}
		case DATA_PRODUCTS :{
			ServerQuaries.GetProducts(obj,con);
			break;
		}
		case DATA_PRODUCTS_BY_FILTER :{
			ServerQuaries.GetProductsByFilter(obj,con);
			break;
		}
		
		
		}

	}
}