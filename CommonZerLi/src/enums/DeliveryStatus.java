package enums;

public enum DeliveryStatus {
	READY_TO_GO("READY_TO_GO",0),
	ON_THE_WAY("ON_THE_WAY",1),
	ARRIVED("ARRIVED",2), 
	CANCELED("CANCELED",3);

	DeliveryStatus(String string, int i) {
	}
}
