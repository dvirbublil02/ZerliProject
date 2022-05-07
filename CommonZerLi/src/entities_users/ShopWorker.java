package entities_users;

import enums.AccountStatus;

@SuppressWarnings("serial")
public class ShopWorker extends User {
	/**
	 * the branch that the worker works in.
	 */
	private String branchID;

	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param accountStatus
	 * @param isLoggedIn
	 * @param branchID
	 */
	public ShopWorker(String iD, String firstName, String lastName, String email, String phoneNumber,
			AccountStatus accountStatus, boolean isLoggedIn, String branchID) {
		super(iD, firstName, lastName, email, phoneNumber, accountStatus, isLoggedIn);
		this.branchID = branchID;
	}

	/**
	 * returns the branch ID of the shop of the shop worker
	 * @return BranchID
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

	@Override
	public String toString() {
		return "Shop Worker " + FirstName + LastName + " of branch: " + branchID;
	}

}
