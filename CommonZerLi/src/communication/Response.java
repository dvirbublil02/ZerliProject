package communication;
/**This is Response enum class , that will contains all the server Response that will return to the client
 * 
 *
 */
public enum Response {
	FOUND_ORDER("FIND_ORDER_ORDER",0),
	DIDNT_FOUND_ORDER("NOT_ORDER_FIND_ORDERS",1),
	INSERT_ORDER_SUCCESS("INSERT_ORDER_SUCCESS",2),
	INSERT_ORDER_FAILD("INSERT_ORDER_FAILD",3),
	REMOVE_ORDER_SUCCESS("REMOVE_ORDER_SUCCESS",4),
	REMOVE_ORDER_FAILD("REMOVE_ORDER_FAILD",5),
	EDIT_ORDER_SUCCESS("EDIT_ORDER_SUCCESS",6),
	EDIT_ORDER_FAILD("EDIT_ORDER_FAILD",7),
	USER_EXIST("USER_EXSIT",8),
	USER_NOT_EXIST("USER_NOT_EXSIT",9),
	USER_NAME_OR_PASSWORD_INCORRECT("USER_NAME_OR_PASSWORD_INCORRECT",10),
	GET_USER_ORDERS_SUCCESS("GET_USER_ORDERS_SUCCESS",11),
	GET_USER_ORDERS_FAILED("GET_USER_ORDERS_FAILED",12),
	CANCEL_USER_ORDER_SUCCES("CANCEL_USER_ORDER_SUCCES",13),
	CANCEL_USER_ORDER_FAILED("CANCEL_USER_ORDER_FAILED",14),
	UPDATE_CONNECTION_SUCCESS("UPDATE_CONNECTION_SUCCESS",15),
	UPDATE_CONNECTION_FAILD("UPDATE_CONNECTION_FAILD",16),
	UPDATE_DISCONNECTION_SUCCESS("UPDATE_DISCONNECTION_SUCCESS",17),
	UPDATE_DISCONNECTION_FAILD("UPDATE_DISCONNECTION_FAILD",18),
	USER_ALREADY_LOGGEDIN("USER_ALREADY_LOGGEDIN",19),
	GET_DATA_PRODUCTS("GET_DATA_PRODUCTS",20),
	FAILD_DATA_PRODUCTS("GET_DATA_PRODUCTS",21), 
	GET_DATA_PRODUCTS_BY_FILTER("GET_DATA_PRODUCTS_BY_FILTER",22),
	FAILD_DATA_PRODUCTS_BY_FILTER("FAILD_DATA_PRODUCTS_BY_FILTER",23),
	FOUND_COLORS("FOUNT_COLORS",24),
	DID_NOT_FIND_COLORS("DID_NOT_FIND_COLORS",25),
	SHOP_WORKER_ARRIVED("SHOP_WORKER_ARRIVED",26),
	SHOP_WORKER_NOT_ARRIVED("SHOP_WORKER_NOT_ARRIVED",27),
	CUSTOMER_ARRIVED("CUSTOMER_ARRIVED",28),
	GET_PENDING_CUSTOMERS_SUCCESS("GET_PENDING_CUSTOMERS_SUCCESS",28),
	GET_PENDING_CUSTOMERS_FAILED("GET_PENDING_CUSTOMERS_FAILED",29),
	APPROVE_NEW_CUSTOMER_SUCCESS("APPROVE_NEW_CUSTOMER_SUCCESS",30),
	APPROVE_NEW_CUSTOMER_FAILED("APPROVE_NEW_CUSTOMER_FAILED",31),
	GET_CREDIT_CARDS_SUCCESS("GET_CREDIT_CARDS_SUCCESS",32),
	GET_CREDIT_CARDS_FAILED("GET_CREDIT_CARDS_FAILED",33),
	CUSTOMER_EDITS_UPDATED("CUSTOMER_EDITS_UPDATED",34),
	WORKER_EDITS_UPDATED("WORKER_EDITS_UPDATED",35),
	WORKER_EDITS_FAILED("WORKER_EDITS_FAILED",36),
	CUSTOMER_EDITS_FAILED("CUSTOMER_EDITS_FAILED",37),
	CUSTOMER_NOT_ARRIVED("CUSTOMER_NOT_ARRIVED",38),
	FOUND_COMPLAINTS("FOUND_COMPLAINTS",39),
	DID_NOT_FOUND_COMPLAINTS("DID_NOT_FOUND_COMPLAINTS",40),
	COMPLAINTS_UPDATE_FAILED("COMPLAINTS_UPDATE_FAILED",41),
	COMPLAINTS_UPDATE_SUCCEED("COMPLAINTS_UPDATE_SUCCEED",42), 
	OPEN_COMPLAINT_SUCCEED("OPEN_COMPLAINT_SUCCEED",43), 
	OPEN_COMPLAINT_FAILED("OPEN_COMPLAINT_FAILED",44),
	FOUND_MONTHLY_REPORT("FOUND_MONTHLY_REPORT",45),
	NOT_FOUND_MONTHLY_REPORT("NOT_FOUND_MONTHLY_REPORT",46),



	FOUND_BRANCHES("FOUND_BRANCHES",47),
	NOT_FOUND_BRANCHES("NOT_FOUND_BRANCHES",48),
	FOUND_PRODUCT_IN_BRANCH("FOUND_PRODUCT_IN_BRANCH",49),
	NOT_FOUND_PRODUCT_IN_BRANCH("FOUND_PRODUCT_IN_BRANCH",50), 
	FAILD_ADD_DELIVERY("FAILD_ADD_DELIVERY",51), 
	ADD_DELIVERY_SUCCEED("ADD_DELIVERY_SUCCEED",52), 
	GET_CUSTOMER_ORDERS_SUCCESS("GET_CUSTOMER_ORDERS_SUCCESS",53), 
	GET_CUSTOMER_ORDERS_FAILD("GET_CUSTOMER_ORDERS_FAILD",54),

	NOTIFY_CUSTOMER_SERVICE("NOTIFY_CUSTOMER_SERVICE",55), 
	UPDATE_ORDER_FAILED("UPDATE_ORDER_FAILED",56), 
	UPDATE_ORDER_SUCCEED("UPDATE_ORDER_SUCCEED",57), 
	GET_SURVY_QUESTION_FAILED("GET_SURVY_QUESTION_FAILED",58),
	GET_SURVY_QUESTION_SUCCEED("GET_SURVY_QUESTION_SUCCEED",59), 
	ISERT_SURVEY_SUCCEED("ISERT_SURVEY_SUCCEED",60),
	ISERT_SURVEY_FAILED("ISERT_SURVEY_FAILED",61),


	FOUND_DELIVERIES("FOUND_DELIVERIES",62),
	NOT_FOUND_DELIVERIES("NOT_FOUND_DELIVERIES",63),
	UPDATE_DELIVERIES_STATUS_SUCCESS("UPDATE_DELIVERIES_STATUS_SUCCESS",64),
	UPDATE_DELIVERIES_STATUS_FAILED("UPDATE_DELIVERIES_STATUS_FAILED",65),


	QUARTER_REPORT_NOT_FOUND("QUARTER_REPORT_NOT_FOUND",66),
	FOUND_QUARENTY_INCOME_REPORT("FOUND_QUARENTY_INCOME_REPORT",67),
	COMPLAINTS("NOT_FOUND_QUARENTY_INCOME_REPORT",68),
	REPORT_YEARS_NOT_FOUND("REPORT_YEARS_NOT_FOUND",69),
	REPORT_YEARS_FOUND("REPORT_YEARS_FOUND",70),
	SURVEY_REPORT_NOT_FOUND("SURVEY_REPORT_NOT_FOUND",71),
	SURVEY_REPORT_FOUND("SURVEY_REPORT_FOUND",72),
	INSERT_SURVEY_REPORT_FAILD("INSERT_SURVEY_REPORT_FAILD",73),
	INSERT_SURVEY_REPORT_SUCCESS("INSERT_SURVEY_REPORT_SUCCESS",74),
	NOT_FOUND_QUARENTY_COMPLAINTS_REPORT("NOT_FOUND_QUARENTY_COMPLAINTS_REPORT",75),
	FOUND_QUARENTY_COMPLAINTS_REPORT("NOT_FOUND_QUARENTY_COMPLAINTS_REPORT",76),
	NOT_FOUND_QUARENTY_INCOME_REPORT("NOT_FOUND_QUARENTY_INCOME_REPORT",77);


	
	
	private Response(final String response,final int serialNumber) {
		
	}
	
}
