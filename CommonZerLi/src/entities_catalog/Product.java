package entities_catalog;

public class Product {
	private String name;
	private String imgSrc;
	private double price;
	private String backGroundColor;
	private String ID;
	private String quantity;
	
	public Product(String ID,String name, double price, String backGroundColor, String imgSrc,String quantity) {
		this.ID=ID;
		this.name = name;
		this.imgSrc = imgSrc;
		this.price = price;
		this.backGroundColor = backGroundColor;
		this.quantity=quantity;
		
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
