package entities_general;

import java.util.List;

import entities_catalog.ProductInOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

public class OrderCartPreview {
	private ImageView imgSrc;
	private String name;
	private int quantity;
	private double price;
	private ProductInOrder product;
	
	public OrderCartPreview(ImageView imgSrc, String name, int quantity, double price,
			ProductInOrder product) {
		this.imgSrc = imgSrc;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.product=product;
	}

	public ImageView getImgSrc() {
		return imgSrc;
	}


	public void setImgSrc(ImageView imgSrc) {
		this.imgSrc = imgSrc;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public ProductInOrder getProduct() {
		return product;
	}

	public void setProduct(ProductInOrder product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName().toString();
	}

}
