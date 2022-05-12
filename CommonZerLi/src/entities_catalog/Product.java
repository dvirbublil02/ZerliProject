package entities_catalog;

import java.io.Serializable;

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
	
	public Product(String ID,String name, double price, String backGroundColor, String imgSrc,double quantity,
			String itemType , String dominateColor ) {
		this.ID=ID;
		this.name = name;
		this.imgSrc = imgSrc;
		this.price = price;
		this.backGroundColor = backGroundColor; // for image
		this.quantity=quantity;
		this.itemType=itemType;
		this.dominateColor=dominateColor;
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
}
