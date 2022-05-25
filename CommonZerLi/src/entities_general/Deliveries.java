package entities_general;

import java.util.List;
import java.util.Map;

import entities_catalog.ProductInOrder;
import enums.DeliveryStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class Deliveries extends Order {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	String deliveryID, orderID, recieverName, arrivedDate;
	double price;
	private	ComboBox<DeliveryStatus> deliveryStatus = new ComboBox<>();
	

	public Deliveries(String orderID, String customerID, String branchID, double price, String greetingCard,
			String orderDate, String expectedDelivery, Map<String,List<ProductInOrder>> items, String deliveryID, String orderID2,
			String recieverName, double price2, String arrivedDate, ComboBox<DeliveryStatus> deliveryStatus) {
		super(orderID, customerID, branchID, price, greetingCard, orderDate, expectedDelivery, items);
		this.deliveryID = deliveryID;
		this.orderID = orderID2;
		this.recieverName = recieverName;
		this.price = price2;
		this.arrivedDate = arrivedDate;
		ObservableList<DeliveryStatus> list=FXCollections.observableArrayList(DeliveryStatus.READY_TO_GO, DeliveryStatus.ON_THE_WAY, DeliveryStatus.CANCELED , DeliveryStatus.ARRIVED);
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getArrivedDate() {
		return arrivedDate;
	}

	public void setArrivedDate(String arrivedDate) {
		this.arrivedDate = arrivedDate;
	}

	public ComboBox<DeliveryStatus> getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(ComboBox<DeliveryStatus> deliveryStatus) {
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
