package entities_general;

import java.util.List;

import entities_catalog.ProductInOrder;

public class Deliveries extends Order {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String deliveryID, orderID, recieverName, price, arrivedDate, deliveryStatus;

	

	public Deliveries(String orderID, String customerID, String branchID, String price, String greetingCard,
			String orderDate, String expectedDelivery, List<ProductInOrder> items, String deliveryID, String orderID2,
			String recieverName, String price2, String arrivedDate, String deliveryStatus) {
		super(orderID, customerID, branchID, price, greetingCard, orderDate, expectedDelivery, items);
		this.deliveryID = deliveryID;
		orderID = orderID2;
		this.recieverName = recieverName;
		price = price2;
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
