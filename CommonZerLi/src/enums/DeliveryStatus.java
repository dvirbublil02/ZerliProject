package enums;

public enum DeliveryStatus {
	READY_TO_GO("READY_TO_GO",0),
	ON_THE_WAY("ON_THE_WAY",1),
	ARRIVED("ARRIVED",2), 
	CANCELED("CANCELED",3),
	WAIT_FOR_MANAGER_APPROVED("WAIT_FOR_MANAGER_APPROVED",4);

	private String name;
	
	DeliveryStatus(String name, int i) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
