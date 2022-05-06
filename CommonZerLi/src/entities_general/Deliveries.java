package entities_general;

public class Deliveries {
	String deliveryID, oredrID, recieverName, price, arrivedDate, deliveryStatus;

	public Deliveries(String deliveryID, String oredrID, String recieverName, String price, String arrivedDate,
			String deliveryStatus) {
		super();
		this.deliveryID = deliveryID;
		this.oredrID = oredrID;
		this.recieverName = recieverName;
		this.price = price;
		this.arrivedDate = arrivedDate;
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}

	public String getOredrID() {
		return oredrID;
	}

	public void setOredrID(String oredrID) {
		this.oredrID = oredrID;
	}

	public String getRecieverName() {
		return recieverName;
	}

	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getArrivedDate() {
		return arrivedDate;
	}

	public void setArrivedDate(String arrivedDate) {
		this.arrivedDate = arrivedDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oredrID == null) ? 0 : oredrID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deliveries other = (Deliveries) obj;
		if (oredrID == null) {
			if (other.oredrID != null)
				return false;
		} else if (!oredrID.equals(other.oredrID))
			return false;
		return true;
	}
	
}
