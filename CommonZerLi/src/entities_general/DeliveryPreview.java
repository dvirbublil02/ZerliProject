package entities_general;

import java.util.List;

import entities_catalog.ProductInOrder;
import enums.DeliveryStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class DeliveryPreview extends Deliveries {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboBox<DeliveryStatus> deliveryStatus = new ComboBox<>();

	public DeliveryPreview(int deliveryID, String orderID, String branchID, String customerID, double price,
			String orderDate, String expectedDelivery, String arrivedDate, String receiverName, String phoneNumber,
			DeliveryStatus deliveryStatus, List<ProductInOrder> orderProducts) {
		super(deliveryID, orderID, branchID, customerID, price, orderDate, expectedDelivery, arrivedDate, receiverName,
				phoneNumber, deliveryStatus, orderProducts);
		// set combo box values
		ObservableList<DeliveryStatus> list = FXCollections.observableArrayList(DeliveryStatus.READY_TO_GO,
				DeliveryStatus.ON_THE_WAY, DeliveryStatus.CANCELED, DeliveryStatus.ARRIVED);
		this.deliveryStatus.setItems(list);
		this.deliveryStatus.setValue(deliveryStatus);
	}

	public void setDeliveryStatusComboBox(ComboBox<DeliveryStatus> deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public ComboBox<DeliveryStatus> getDeliveryStatusComboBox() {
		return deliveryStatus;
	}
	
	

}
