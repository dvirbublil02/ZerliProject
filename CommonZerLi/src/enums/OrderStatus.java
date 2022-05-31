package enums;
/**
 * This Enum is used to describe status of an order in the system.
 * @author Omri Shalev
 */
public enum OrderStatus {
	PENDING("PENDING",0),
	APPROVE("APPROVE",1),
	CANCEL("CANCEL",2),
	ARRIVED("ARRIVED",3), 
	APPROVE_WITH_DELIVERY("APPROVE_WITH_DELIVERY",4),
	CANCEL_WITH_DELIVERY("CANCEL_WITH_DELIVERY",5),
	PENDING_WITH_DELIVERY("PENDING_WITH_DELIVERY",6);
	

	private OrderStatus(String string, int i) {
	}
}
