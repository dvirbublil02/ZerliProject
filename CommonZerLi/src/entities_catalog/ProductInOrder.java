package entities_catalog;

public class ProductInOrder extends Product {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cartID;
	private double productQuantityInOrder;
	private boolean isOnSale;
	private double fixPrice;
	private String nameOfproduct;
	

	public ProductInOrder(String ID, String nameOfproduct, double price, String backGroundColor, String imgSrc, double quantity,
			String itemType, String dominateColor , String cartID ,Double productQuantityInOrder,boolean isOnSale,double fixPrice,String name ) {
		super(ID, name, price, backGroundColor, imgSrc, quantity, itemType, dominateColor, isOnSale, fixPrice);
		this.cartID=cartID;
		this.productQuantityInOrder=productQuantityInOrder;
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}


	public double getProductQuantityInOrder() {
		return productQuantityInOrder;
	}

	
	public void setProductQuantityInOrder(double productQuantityInCart) {
		this.productQuantityInOrder = productQuantityInCart;
	}
	
	
	public boolean isOnSale() {
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
	


	public String getNameOfproduct() {
		return nameOfproduct;
	}
	
	public void setNameOfproduct(String nameOfproduct) {
		this.nameOfproduct = nameOfproduct;
	}

	@Override
	public String toString() {
		return "ProductInOrder [getName()=" + getName() + "getQuantity()="+ getQuantity() + ", productQuantityInOrder=" + getProductQuantityInOrder();
		
	}


}
