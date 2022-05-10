package entities_general;

import java.util.List;

import entities_catalog.Product;
import enums.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
/**
 * @author Omri Shalev
 */
public class Order {
	/**
	 * Every order has its own ID.
	 */
	private String orderID;
	/**
	 * Every order connected to a customer 
	 * customer ID is the connection.
	 */
	private String customerID;
	/*
	 * Every order belongs to one branch with this ID.
	 */
	private String branchID;
	/**
	 * Every order has a price.
	 */
	private String price; 
	/**
	 * Every order can have a greeting card if the customer wants.
	 */
	private String greetingCard;
	/**
	 * Every order has a status: ready, on the way, arrived.
	 */
	private ComboBox<OrderStatus> status;
	/**
	 * Every order save the date and time it was created.
	 */
	private String orderDate;
	/**
	 * Every order has expected time to arrival.
	 */
	private String expectedDelivery;
	/**
	 * The list of items in the order
	 */
	private List<Product> items;
	/**
	 * @param orderID
	 * @param customerID
	 * @param branchID
	 * @param price
	 * @param greetingCard
	 * @param status
	 * @param orderDate
	 * @param expectedDelivery
	 * @param items
	 */
	public Order(String orderID, String customerID, String branchID, String price, String greetingCard,
			String orderDate, String expectedDelivery, List<Product> items) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.branchID = branchID;
		this.price = price;
		this.greetingCard = greetingCard;
		this.status = new ComboBox<>();
		ObservableList<OrderStatus> list1=FXCollections.observableArrayList(OrderStatus.READY,OrderStatus.NOT_READY,OrderStatus.ON_THE_WAY);
		this.status.setItems(list1);
		this.orderDate = orderDate;
		this.expectedDelivery = expectedDelivery;
		this.items = items;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGreetingCard() {
		return greetingCard;
	}

	public void setGreetingCard(String greetingCard) {
		this.greetingCard = greetingCard;
	}

	public ComboBox<OrderStatus> getStatus() {
		return status;
	}

	public void setStatus(ComboBox<OrderStatus> status) {
		this.status = status;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getExpectedDelivery() {
		return expectedDelivery;
	}

	public void setExpectedDelivery(String expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchID == null) ? 0 : branchID.hashCode());
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
		Order other = (Order) obj;
		if (branchID == null) {
			if (other.branchID != null)
				return false;
		} else if (!branchID.equals(other.branchID))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return true;
	}

}
