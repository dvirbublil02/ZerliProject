package entities;

import javafx.scene.image.ImageView;

public class ItemInCart {
	private ImageView imgSrc;
	private double price;
	private int quantity;
	private String name;
	
	public ItemInCart(String name, ImageView object, double price, int quantity) {
	
		this.name = name;
		this.imgSrc = object;
		this.price = price;
		this.quantity = quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImageView getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(ImageView imgSrc) {
		this.imgSrc = imgSrc;
	}
	public double getPrice() {
		return price;
	}
	
}