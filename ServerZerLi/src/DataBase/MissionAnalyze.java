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
			ServerQuaries.addOrderInDB(obj, con);
			
		//	ServerQuaries.AddOrderToDB(obj, con);
			break;
		}
		case EDIT_ORDER: {
	//		ServerQuaries.EditOrderOnDB(obj, con);
			break;
		}
		case GET_ORDER: {
			System.out.println(5);
			ServerQuaries.getOrders(obj,con);
			
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
		case GET_SHOP_WORKERS:{
			ServerQuaries.GetShopWorkersFromDB(obj, con);
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
		case GET_COLORS:{
			ServerQuaries.getColors(obj,con);
			break;
		}
		case GET_PENDING_CUSTOMERS:{
			ServerQuaries.getPendingCustomersFromDB(obj, con);
			break;
		}
		case APPROVE_NEW_CUSTOMER:{
			ServerQuaries.approveNewCustomerToDB(obj,con);
			break;
		}
		case GET_CREDIT_CARDS:{
			ServerQuaries.getCreditCardsFromDB(obj, con);
			break;
		}
		case GET_APPROVED_CUSTOMERS:{
			ServerQuaries.GetCustomersFromDB(obj, con);
			break;
		}
		case UPDATE_EDITED_CUSTOMERS:{
			ServerQuaries.updateCustomersAfterEdit(obj,con);
			break;
		}
		
		case UPDATE_EDITED_WORKERS:{
			ServerQuaries.updateWorkersAfterEdit(obj,con);
			break;
		}
		}

	}
}