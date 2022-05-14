package entities_general;

import java.util.List;

import entities_catalog.ProductInOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;


//show total custom product on cart section 
public class OrderCustomCartPreview {
	private ImageView imgSrc;
	private String name;
	private int quantity;
	private double totalprice;
	private ObservableList<ProductInOrder> cartList=FXCollections.observableArrayList();
	
	
	public OrderCustomCartPreview(ImageView imgSrc, String name, int quantity, double totalprice,
			List<ProductInOrder> cartList) {
		this.imgSrc = imgSrc;
		this.name = name;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.cartList.addAll(cartList);
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


	public ObservableList<ProductInOrder> getCartList() {
		return cartList;
	}


	public void setCartList(ObservableList<ProductInOrder> cartList) {
		this.cartList = cartList;
	}
	
	
	
	
	
}
