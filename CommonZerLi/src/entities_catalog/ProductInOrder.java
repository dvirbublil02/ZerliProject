package entities_catalog;

public class ProductInOrder extends Product {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cartID;
	private String productQuantityInOrder;
	
	public ProductInOrder(String ID, String name, double price, String backGroundColor, String imgSrc, double quantity,
			String itemType, String dominateColor , String cartID ,String productQuantityInOrder ) {
		super(ID, name, price, backGroundColor, imgSrc, quantity, itemType, dominateColor);
		this.cartID=cartID;
		this.productQuantityInOrder=productQuantityInOrder;
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}


	public String getProductQuantityInCart() {
		return productQuantityInOrder;
	}

	
	public void setProductQuantityInCart(String productQuantityInCart) {
		this.productQuantityInOrder = productQuantityInCart;
	}
	
}
