package entities_catalog;

import java.util.List;

import javafx.scene.image.ImageView;

public class Cart {
	private ImageView imgSrc;
	private double price;
	private int quantity;
	private String cartID;
	private List<ProductInCart> cartList;
	/**
	 * @param name
	 * @param object
	 * @param price
	 * @param quantity
	 * @param cartList
	 */
 	public Cart(String name, ImageView object, double price, int quantity,List<ProductInCart> cartList) {
		this.imgSrc = object;
		this.price = price;
		this.quantity = quantity;
		this.cartList = cartList;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public List<ProductInCart> getCartList() {
		return cartList;
	}

	public void setCartList(List<ProductInCart> cartList) {
		this.cartList = cartList;
	}

	

}