package entities_catalog;

public class ProductInCart extends Product{
	
	private String cartID;
	private int productQuantityInCart;
		
	public ProductInCart(String ID, String name, double price, String backGroundColor, String imgSrc, String quantity) {
		super(ID, name, price, backGroundColor, imgSrc, quantity);
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public int getProductQuantityInCart() {
		return productQuantityInCart;
	}

	public void setProductQuantityInCart(int productQuantityInCart) {
		this.productQuantityInCart = productQuantityInCart;
	}
	
}
