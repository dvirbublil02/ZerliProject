package entities_catalog;

public class ProductInOrder extends Product {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cartID;
	private Double productQuantityInOrder;
	
	public ProductInOrder(String ID, String name, double price, String backGroundColor, String imgSrc, double quantity,
			String itemType, String dominateColor , String cartID ,Double productQuantityInOrder,boolean isOnSale,double fixPrice ) {
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


	public Double getProductQuantityInCart() {
		return productQuantityInOrder;
	}

	
	public void setProductQuantityInCart(Double productQuantityInCart) {
		this.productQuantityInOrder = productQuantityInCart;
	}

	@Override
	public String toString() {
		return "ProductInOrder [getName()=" + getName() + "getQuantity()="+ getQuantity() + ", productQuantityInOrder=" + getProductQuantityInCart();
				
	}
	


}
