package entities_catalog;

import java.io.Serializable;
import java.util.Objects;

public class Product  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String imgSrc;
	private double price;
	private String backGroundColor;
	private String ID;
	private double quantity;
	private String itemType;
	private String dominateColor;
	private boolean isOnSale;
	private double fixPrice;
	
	public Product(String ID,String name, double price, String backGroundColor, String imgSrc,double quantity,
			String itemType , String dominateColor,boolean isOnSale,double fixPrice ) {
		this.ID=ID;
		this.name = name;
		this.imgSrc = imgSrc;
		this.price = price;
		this.backGroundColor = backGroundColor; // for image
		this.quantity=quantity;
		this.itemType=itemType;
		this.dominateColor=dominateColor;
		this.isOnSale=isOnSale;
		this.fixPrice=fixPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getbackGroundColor() {
		return backGroundColor;
	}

	public void setColor(String color) {
		this.backGroundColor = color;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getQuantity() {
		return quantity;
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getBackGroundColor() {
		return backGroundColor;
	}

	public void setBackGroundColor(String backGroundColor) {
		this.backGroundColor = backGroundColor;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getDominateColor() {
		return dominateColor;
	}

	public void setDominateColor(String dominateColor) {
		this.dominateColor = dominateColor;
	}

	public boolean getIsOnSale() {
		return isOnSale;
	}

	public void setOnSale(boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	public double getFixPrice() {
		return fixPrice;
	}

	public void setFixPrice(double fixPrice) {
		this.fixPrice = fixPrice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(ID, other.ID);
	}

	
}
