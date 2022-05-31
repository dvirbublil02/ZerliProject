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
	UPDATE_EDITED_WORKERS("UPDATE_EDITED_WORKERS",18),
	GET_COMPLAINTS("GET_COMPLAINTS",19), 
	UPDATE_COMPLAINTS("	UPDATE_COMPLAINTS",20), 
	OPEN_COMPLAINT("OPEN_COMPLAINT",21),
	GET_MONTHLY_REPORT("GET_MONTHLY_REPORT",22),

	GET_QUARTER_INCOME_REPORT("GET_QUARTER_INCOME_REPORT",23), 

	GET_BRANCHES("GET_QUARTER_INCOME_REPORT",24), 
	GET_PRODUCT_IN_BRANCH("GET_PRODUCT_IN_BRANCH",25), 
	ADD_DELIVERY("ADD_DELIVERY",26), 
	GET_CUSTOMER_ORDERS_CANCELATION("GET_CUSTOMER_ORDERS_CANCELATION",27), 
	GET_CUSTOMER_ORDERS_HISTORY("GET_CUSTOMER_ORDERS_HISTORY",28),
<<<<<<< HEAD
	GET_BRANCHID_BY_USER("GET_BRANCHID_BY_USER",29),
	GET_YEARS_FOR_COMOBOX("GET_YEARS_FOR_COMOBOX",30),
	GET_SURVEY_REPORT("GET_SURVEY_REPORT",31),
	INSERT_SURVEY_BY_EXPERT("INSERT_SURVEY_BY_EXPERT",32),
	GET_QUARTER_COMPLAINTS_REPORT("GET_QUARTER_COMPLAINTS_REPORT",33);
=======

	UPADTE_ORDER("UPADTE_ORDER",29), 
	NOTIFY("NOTIFY",30), 
	GET_SURVEY_QUESTIONS("GET_SURVEY_QUESTIONS",31), 
	INSERT_SURVY("INSERT_SURVY",32),
	GET_DELIVERIES("GET_DELIVERIES",33), 
	UPDATE_DELIVERIES_STATUSES("UPDATE_DELIVERIES_STATUSES",34),
	
	GET_BRANCHID_BY_USER("GET_BRANCHID_BY_USER",35),
	GET_YEARS_FOR_COMOBOX("GET_YEARS_FOR_COMOBOX",36),
	GET_SURVEY_REPORT("GET_SURVEY_REPORT",37),
	INSERT_SURVEY_BY_EXPERT("INSERT_SURVEY_BY_EXPERT",38),
	GET_QUARTER_COMPLAINTS_REPORT("GET_QUARTER_COMPLAINTS_REPORT",39);
	

>>>>>>> origin/Merge

	private Mission (final String mission,final int serialNumber ) {
	}
}
