package entities_catalog;

import java.io.Serializable;

/* Product In Branch 
 * @Author Almog Madar
 */

public class ProductInBranch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String branchID;
	private  String productID;
	private int quantity;
	
	public ProductInBranch(String branchID, String productID, int quantity) {
		this.branchID = branchID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: "+getBranchID()+" ProductID :"+getProductID()+" Quantity :"+getQuantity();
	}
	
	
	
	
}
