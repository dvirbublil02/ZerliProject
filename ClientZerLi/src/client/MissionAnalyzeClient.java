package client;

import communication.TransmissionPack;

public class MissionAnalyzeClient {

	public static boolean MissionsAnalyzeClient(TransmissionPack obj) {
		ClientController.setObj(obj);
		switch (obj.getResponse()) {
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
		case USER_EXIST:
			break;
		case USER_NAME_OR_PASSWORD_INCORRECT:
			break;
		case USER_NOT_EXIST:
			break;
		default:
			break;
		}
		return false;
	}
}
