package entities_general;

public class Deliveries {
	String deliveryID, orderID, recieverName, price, arrivedDate, deliveryStatus;

	public Deliveries(String deliveryID, String oredrID, String recieverName, String price, String arrivedDate,
			String deliveryStatus) {
		super();
		this.deliveryID = deliveryID;
		this.orderID = oredrID;
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
		return orderID;
	}

	public void setOredrID(String oredrID) {
		this.orderID = oredrID;
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
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
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
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return true;
	}
	
}
