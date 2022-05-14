package entities_catalog;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

public class Cart {
	private ImageView imgSrc;
	private double price;
	private double quantity;
	private String Description;
	private String name;
	private ObservableList<ProductInOrder> cartList;
	/**
	 * @param name
	 * @param object
	 * @param price
	 * @param quantity
	 * @param cartList
	 */
 	
	public Cart(String name, ImageView object, double price, Double quantity,ObservableList<ProductInOrder> cartList,String Description) {
		this.name=name;
		this.imgSrc = object;
		this.price = price;
		this.quantity = quantity;
		this.cartList = cartList;
		this.Description=Description;
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

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


	public ObservableList<ProductInOrder> getCartList() {
		return cartList;
	}

	public void setCartList(ObservableList<ProductInOrder> cartList) {
		this.cartList = cartList;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}