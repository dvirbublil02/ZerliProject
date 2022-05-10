package entities_users;

import java.io.Serializable;
import java.util.List;


import enums.AccountStatus;

/**
 * @author User Omri Shalev
 */
@SuppressWarnings("serial")
public class DeliveryAgent extends User implements Serializable{
	/**
	 * Delivery agents has their main branch
	 */
	private String branchID;
	/**
	 * Every delivery agent has a list of orders to send
	 */
	private List<String> orders;

	/**
	 * 
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param accountStatus
	 * @param isLoggedIn
	 * @param branchID
	 * @param orders
	 */
	public DeliveryAgent(String iD, String firstName, String lastName, String email, String phoneNumber,
			AccountStatus accountStatus, boolean isLoggedIn, String branchID, List<String> orders) {
		super(iD, firstName, lastName, email, phoneNumber, accountStatus, isLoggedIn);
		this.branchID = branchID;
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Delivery Agent";
	}

	/**
	 * returns the branch ID
	 * 
	 * @return branchID
	 */
	public String getBranchID() {
		return branchID;
	}

	/**
	 * @param branchID
	 */
	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	/**
	 * returns the list of the orders that need to be sent
	 * 
	 * @return
	 */
	public List<String> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 */
	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

}
