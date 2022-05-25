package entities_catalog;

public class ProductInOrder extends Product {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderID;
	private String nameOfProduct;
	private String nameOfItem;
	private int productQuantityInOrder;

	//productID, orderID, nameOfproduct, price, backGroundColor, picture, quantity, itemType, dominateColor, productQuantityInOrder, nameOfItem
	public ProductInOrder(String productID ,String orderID ,String nameOfproduct, double price, String backGroundColor, String imgSrc, int quantity,
			String itemType, String dominateColor,int productQuantityInOrder,String nameOfItem,boolean isOnSale,double fixPrice ) {
		super(productID, nameOfItem, price, backGroundColor, imgSrc, quantity, itemType, dominateColor, isOnSale, fixPrice);
		this.orderID=orderID;
		this.nameOfItem=nameOfItem;
		this.productQuantityInOrder=productQuantityInOrder;
	}

	public int getProductQuantityInCart() {
		return productQuantityInOrder;
	}

	
	public void setProductQuantityInCart(int productQuantityInCart) {
		this.productQuantityInOrder = productQuantityInCart;
	}
		
	
	public String getNameOfProduct() {
		return nameOfProduct;
	}

	public void setNameOfProduct(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}

	public String getNameOfItem() {
		return nameOfItem;
	}

	public void setNameOfItem(String nameOfItem) {
		this.nameOfItem = nameOfItem;
	}
	
	

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	@Override
	public boolean equals(Object obj) {
		ProductInOrder p=(ProductInOrder) obj;
		return this.getID() != p.getID() ? false : this.getName() != p.getName() ? false:true; 
	}

	@Override
	public String toString() {
		return "ProductInOrder [getName()=" + getName() + "getQuantity()="+ getQuantity() + ", productQuantityInOrder=" + getProductQuantityInCart();
				
	}
	




}
