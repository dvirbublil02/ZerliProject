package entities_general;


import entities_catalog.Product;
import javafx.scene.control.CheckBox;

public class ProductPreview extends Product{
	
	private static final long serialVersionUID = 1L;
	private CheckBox isOnSaleCB;
	//private TextField priceAfterSale= new TextField();

	
	public ProductPreview(String productID, String name, double price, String backGroundColor, String imgSrc,
			int quantity, String itemType, String dominateColor, boolean isOnSale, double fixPrice) {
		super(productID, name, price, backGroundColor, imgSrc, quantity, itemType, dominateColor, isOnSale, fixPrice);
		
		this.isOnSaleCB=new CheckBox();
		this.isOnSaleCB.setSelected(isOnSale);
		/*if(isOnSale==false)
			priceAfterSale.setVisible(false);*/
		
	}
//	public TextField getPriceAfterSale() {
//		return priceAfterSale;
//	}
//
//	public void setPriceAfterSale(TextField priceAfterSale) {
//		this.priceAfterSale = priceAfterSale;
//	}

	public CheckBox getIsOnSaleCB() {
		return isOnSaleCB;
	}

	public void setIsOnSaleCB(CheckBox isOnSaleCB) {
		this.isOnSaleCB = isOnSaleCB;
	}

}






