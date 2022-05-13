package entities_general;

import java.util.List;

import entities_catalog.ProductInOrder;
import enums.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class OrderPrivew extends Order {

	/**
	 * 
	 */
	
	private ComboBox<OrderStatus> status;
	private static final long serialVersionUID = 1L;

	public OrderPrivew(String orderID, String customerID, String branchID, String price, String greetingCard,
			String orderDate, String expectedDelivery, List<ProductInOrder> items) {
		super(orderID, customerID, branchID, price, greetingCard, orderDate, expectedDelivery, items);
		ObservableList<OrderStatus> list1=FXCollections.observableArrayList(OrderStatus.APPROVE,OrderStatus.CANCEL,OrderStatus.PENDING);
		this.status.setItems(list1);
	}

}
