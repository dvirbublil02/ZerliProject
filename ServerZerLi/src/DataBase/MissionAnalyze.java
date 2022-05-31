package DataBase;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;

import communication.TransmissionPack;
import ocsf.server.ConnectionToClient;

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

			// ServerQuaries.AddOrderToDB(obj, con);
			break;
		}
		case EDIT_ORDER: {
			// ServerQuaries.EditOrderOnDB(obj, con);
			break;
		}
		case GET_ORDER: {
			System.out.println(5);
			ServerQuaries.getOrders(obj, con);

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

			// ServerQuaries.getUser(obj, con);
			ServerQuaries.Login(obj, con);
			break;
		}
		case USER_LOGOUT: {
			ServerQuaries.logout(obj, con);
			break;

		}
		case GET_SHOP_WORKERS: {
			ServerQuaries.GetShopWorkersFromDB(obj, con);
			break;

		}
		case DATA_PRODUCTS: {
			ServerQuaries.GetProducts(obj, con);
			break;
		}
		case DATA_PRODUCTS_BY_FILTER: {
			ServerQuaries.GetProductsByFilter(obj, con);
			break;
		}
		case GET_COLORS: {
			ServerQuaries.getColors(obj, con);
			break;
		}
		case GET_PENDING_CUSTOMERS: {
			ServerQuaries.getPendingCustomersFromDB(obj, con);
			break;
		}
		case APPROVE_NEW_CUSTOMER: {
			ServerQuaries.approveNewCustomerToDB(obj, con);
			break;
		}
		case GET_CREDIT_CARDS: {
			ServerQuaries.getCreditCardsFromDB(obj, con);
			break;
		}
		case GET_APPROVED_CUSTOMERS: {
			ServerQuaries.GetCustomersFromDB(obj, con);
			break;
		}
		case UPDATE_EDITED_CUSTOMERS: {
			ServerQuaries.updateCustomersAfterEdit(obj, con);
			break;
		}

		case UPDATE_EDITED_WORKERS: {
			ServerQuaries.updateWorkersAfterEdit(obj, con);
			break;
		}
		case GET_COMPLAINTS: {
			ServerQuaries.getComlaints(obj, con);
			break;
		}
		case UPDATE_COMPLAINTS: {
			System.out.println("here2->");
			ServerQuaries.updateComplaints(obj, con);
			break;
		}
		case OPEN_COMPLAINT: {

			try {
				ServerQuaries.openComplaint(obj, con);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
		case GET_MONTHLY_REPORT: {
			ReportsQuaries.getMonthlyReport(obj, con);
			// createReports.monthlyOrders("2525", "05");
			// createReports.monthlyIncome("2525","05");
			break;
		}
		case GET_QUARTER_INCOME_REPORT: {
			ReportsQuaries.getQuarterIncomeReport(obj, con);
			break;
		}

		case GET_BRANCHES: {
			ServerQuaries.getBranches(obj, con);
			break;
		}

		case GET_DELIVERIES: {
			ServerQuaries.GetDeliveriesFromDB(obj, con);
			break;
		}
		case UPDATE_DELIVERIES_STATUSES: {
			ServerQuaries.UpdateDeliveriesStatusesInDB(obj, con);
			break;
		}

		case UPADTE_ORDER: {
			ServerQuaries.updateOrder(obj, con);
			break;
		}
		case NOTIFY: {
			ServerQuaries.notifyCustomerService(obj, con);
			break;
		}
		case GET_SURVEY_QUESTIONS: {
			System.out.println("mission analyze step");
			ServerQuaries.getSurvyQuestions(obj, con);
			break;
		}
		case INSERT_SURVY: {
			ServerQuaries.insertSurvy(obj, con);
			break;
		}

		case GET_PRODUCT_IN_BRANCH: {
			ServerQuaries.getProductInBranch(obj, con);
			break;
		}
		case ADD_DELIVERY: {
			ServerQuaries.addDelivery(obj, con);
			break;
		}
		case GET_CUSTOMER_ORDERS_CANCELATION: {
			ServerQuaries.getCustomerOrdersCancelation(obj, con);
			break;
		}
		case GET_CUSTOMER_ORDERS_HISTORY: {
			ServerQuaries.getCustomerOrdersHistory(obj, con);
			break;
		}

		}

	}
}