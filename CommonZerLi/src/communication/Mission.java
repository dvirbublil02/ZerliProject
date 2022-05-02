package communication;

/**This is Mission enum class , that will contains all the client missions that he ask from the server
 * 
 *
 */
public enum Mission {
	GET_ORDERS("GET_ORDERS",0),
	ADD_ORDER("ADD_ORDER",1),
	EDIT_ORDER("EDIT_ORDER",2),
	USER_LOGIN("USER_LOGIN",3),
	GET_USER_ORDERS("GET_USER_ORDERS",4),
	CANCEL_OREDERS("CANCEL_OREDRS",5),
	SEND_CONNECTION_DETAILS("SEND_CONNECTION_DETAILS",6), 
	SEND_DISCONNECT_DETAILS("SEND_DISCONNECT_DETAILS",7);
	
	private Mission (final String mission,final int serialNumber ) {
	}
}
