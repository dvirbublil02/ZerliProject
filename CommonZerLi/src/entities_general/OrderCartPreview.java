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
	private double totalprice;
	private ProductInOrder product;
	
	public OrderCartPreview(ImageView imgSrc, String name, int quantity, double totalprice,
			ProductInOrder product) {
		this.imgSrc = imgSrc;
		this.name = name;
		this.quantity = quantity;
		this.totalprice = totalprice;
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


	public double getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
	public ProductInOrder getProduct() {
		return product;
	}

	public void setProduct(ProductInOrder product) {
		this.product = product;
	}

}
