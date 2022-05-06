package client;

import java.util.ArrayList;
import java.util.List;

import communication.TransmissionPack;

public class MissionAnalyzeClient {
	private static final List<zerliClientListeners> clientlisteners = new ArrayList<zerliClientListeners>();

	public static boolean MissionsAnalyzeClient(TransmissionPack obj) {
		ClientController.setObj(obj);
		switch (obj.getResponse()) {
		case UPDATE_CONNECTION_SUCCESS: {
			for (zerliClientListeners client : clientlisteners) {
				client.ipConfirmedForClient();
			}
			break;
		}
		case UPDATE_CONNECTION_FAILD:{
			for (zerliClientListeners client : clientlisteners) {
				client.ipNotConfirmedForClient();
			}
			break;
		}
		case UPDATE_DISCONNECTION_SUCCESS: {

		}
		case FOUND_ORDERS: {

		}
		case DIDNT_FOUND_ORDERS: {

		}
		case INSERT_ORDER_SUCCESS: {

		}
		case INSERT_ORDER_FAILD: {

		}
		case EDIT_ORDER_SUCCESS: {

			// insert relevant method from the clientQuaries on the future
		}
		case EDIT_ORDER_FAILD: {
			// insert relevant method from the clientQuaries on the future
		}

			return false;
		case REMOVE_ORDER_FAILD:
			break;
		case REMOVE_ORDER_SUCCESS:
			break;
		case USER_EXIST:{
			switch((String)obj.getInformation()) {
			case "customer": {
				System.out.println(obj.getInformation());
			for (zerliClientListeners client : clientlisteners) {
				client.userIsCustomer();
			}
			break;
			}
			case "branchmanager": {
				for (zerliClientListeners client : clientlisteners) {
					client.userIsBranchManager();
				}
				break;
				}
			}

		}
			
		case USER_NAME_OR_PASSWORD_INCORRECT:
			break;
		case USER_NOT_EXIST:
			break;
		default:
			break;
		}return false;

	}

	public static void addClientListener(zerliClientListeners listener) {
		clientlisteners.add(listener);
	}

	public static void removeClientListener(zerliClientListeners listener) {
		clientlisteners.remove(listener);
	}
}
