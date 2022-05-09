package enums;
/**
 * This Enum is used to describe status of an order in the system.
 * @author Omri Shalev
 */
public enum OrderStatus {
	NOT_READY("NOT_READY",0),
	READY("READY",1),
	ON_THE_WAY("ON_THE_WAY",2),
	ARRIVED("ARRIVED",3);

	OrderStatus(String string, int i) {
	}
}
