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
	PENDING_DELIVERY("PENDING_DELIVERY",4),
	APPROVE_DELIVERY("APPROVE_DELIVERY",5),
	CANCEL_DELIVERY("CANCEL_DELIVERY",6);

	private OrderStatus(String string, int i) {
	}
}
