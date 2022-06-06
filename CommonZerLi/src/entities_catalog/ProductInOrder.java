package entities_catalog;

/**
 * this class represent a product in order
 */
public class ProductInOrder extends Product {

	private static final long serialVersionUID = 1L;

	private String orderID;
	private String nameOfProduct;
	private String nameOfItem;
	private int productQuantityInOrder;

	/**
	 * 
	 * @param productID
	 * @param orderID
	 * @param nameOfproduct
	 * @param price
	 * @param backGroundColor
	 * @param imgSrc
	 * @param quantity
	 * @param itemType
	 * @param dominateColor
	 * @param productQuantityInOrder
	 * @param nameOfItem
	 * @param isOnSale
	 * @param fixPrice
	 */
	public ProductInOrder(String productID, String orderID, String nameOfproduct, double price, String backGroundColor,
			String imgSrc, int quantity, String itemType, String dominateColor, int productQuantityInOrder,
			String nameOfItem, boolean isOnSale, double fixPrice) {
		super(productID, nameOfItem, price, backGroundColor, imgSrc, quantity, itemType, dominateColor, isOnSale,
				fixPrice);
		this.orderID = orderID;
		this.nameOfItem = nameOfItem;
		this.productQuantityInOrder = productQuantityInOrder;
	}

	public int getProductQuantityInCart() {

		return productQuantityInOrder;
	}

	public void setProductQuantityInCart(int productQuantityInCart) {

		this.productQuantityInOrder = productQuantityInCart;
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
		ProductInOrder p = (ProductInOrder) obj;
		return this.getID() != p.getID() ? false : this.getName() != p.getName() ? false : true;
	}

	public String getNameOfproduct() {
		return nameOfProduct;
	}

	public void setNameOfproduct(String nameOfproduct) {
		this.nameOfProduct = nameOfproduct;
	}

	@Override
	public String toString() {
		return "ProductInOrder("+super.getID()+") [getName()=" + getName() + "getQuantity()=" + getQuantity() + ", productQuantityInOrder="
				+ getProductQuantityInCart();

	}

}
