package enums;
/**
 * This Enum is used to describe status of an order in the system.
 * @author Omri Shalev
 */
public enum OrderStatus {
	PENDING("PENDING",0),
	APPROVE("APPROVE",1),
	CANCEL("CANCEL",2),
	ARRIVED("ARRIVED",3);

	private OrderStatus(String string, int i) {
	}
}
