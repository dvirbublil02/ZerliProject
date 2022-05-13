package communication;
/**This is Response enum class , that will contains all the server Response that will return to the client
 * 
 *
 */
public enum Response {
	FOUND_ORDERS("FIND_ORDER_ORDERS",0),
	DIDNT_FOUND_ORDERS("NOT_ORDER_FIND_ORDERS",1),
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
	FAILD_DATA_PRODUCTS_BY_FILTER("FAILD_DATA_PRODUCTS_BY_FILTER",23);
	
	
	private Response(final String response,final int serialNumber) {
		
	}
	
}
