package communication;

/**This is Mission enum class , that will contains all the client missions that he ask from the server
 * 
 *
 */
public enum Mission {
	GET_ORDER("GET_ORDER",0),
	ADD_ORDER("ADD_ORDER",1),
	EDIT_ORDER("EDIT_ORDER",2),
	USER_LOGIN("USER_LOGIN",3),
	GET_USER_ORDERS("GET_USER_ORDERS",4),
	CANCEL_OREDERS("CANCEL_OREDRS",5),
	SEND_CONNECTION_DETAILS("SEND_CONNECTION_DETAILS",6), 
	SEND_DISCONNECT_DETAILS("SEND_DISCONNECT_DETAILS",7),
	USER_LOGOUT("USER_LOGOUT",8), 
	DATA_PRODUCTS("DATA_PRODUCTS",9), 
	DATA_PRODUCTS_BY_FILTER("DATA_PRODUCTS_BY_FILTER",10),
	GET_COLORS("GET_COLORS",11),
	GET_SHOP_WORKERS("GET_SHOP_WORKERS",12),
	GET_PENDING_CUSTOMERS("GET_PENDING_CUSTOMERS",13),
	APPROVE_NEW_CUSTOMER("APPROVE_NEW_CUSTOMER",14),
	GET_CREDIT_CARDS("GET_CREDIT_CARDS",15),
	GET_APPROVED_CUSTOMERS("GET_APPROVED_CUSTOMERS",16),
	UPDATE_EDITED_CUSTOMERS("UPDATE_EDITED_CUSTOMERS",17),
	UPDATE_EDITED_WORKERS("UPDATE_EDITED_WORKERS",18);

	
	private Mission (final String mission,final int serialNumber ) {
	}
}
