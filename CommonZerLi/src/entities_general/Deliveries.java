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
	private String deliveryID, recieverName, arrivedDate;
	private ComboBox<DeliveryStatus> deliveryStatus = new ComboBox<>();

	public Deliveries(String deliveryID, String recieverName, String arrivedDate,
			ComboBox<DeliveryStatus> deliveryStatus, String orderID, String customerID, String branchID, double price,
			String greetingCard, String orderDate, String expectedDelivery, Map<String, List<ProductInOrder>> items) {
		super(orderID, customerID, branchID, price, greetingCard, orderDate, expectedDelivery, items);
		this.deliveryID = deliveryID;
		this.recieverName = recieverName;
		this.arrivedDate = arrivedDate;
		ObservableList<DeliveryStatus> list = FXCollections.observableArrayList(DeliveryStatus.READY_TO_GO,
				DeliveryStatus.ON_THE_WAY, DeliveryStatus.CANCELED, DeliveryStatus.ARRIVED);
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}

	public String getRecieverName() {
		return recieverName;
	}

	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
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
		int result = super.hashCode();
		result = prime * result + ((deliveryID == null) ? 0 : deliveryID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deliveries other = (Deliveries) obj;
		if (deliveryID == null) {
			if (other.deliveryID != null)
				return false;
		} else if (!deliveryID.equals(other.deliveryID))
			return false;
		return true;
	}

}
