package entities_catalog;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Order implements Serializable{
	private String orderNumber,price,greetingCard,color,dorder,shop,date,orderDate;

	public Order() {
		
	}
	
	public Order(String orderNumber, String price, String greetingCard, String color, String dorder,
			String shop, String date, String orderDate) {
		this.orderNumber = orderNumber;
		this.price = price;
		this.greetingCard = greetingCard;
		this.color = color;
		this.dorder = dorder;
		this.shop = shop;
		this.date = date;
		this.orderDate = orderDate;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setGreetingCard(String greetingCard) {
		this.greetingCard = greetingCard;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDorder(String dorder) {
		this.dorder = dorder;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public String getPrice() {
		return price;
	}

	public String getGreetingCard() {
		return greetingCard;
	}

	public String getColor() {
		return color;
	}

	public String getDorder() {
		return dorder;
	}

	public String getShop() {
		return shop;
	}

	public String getDate() {
		return date;
	}

	public String getOrderDate() {
		return orderDate;
	}

}