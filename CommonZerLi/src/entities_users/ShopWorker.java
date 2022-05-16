package entities_users;

import java.io.Serializable;

import enums.AccountStatus;
import enums.ShopWorkerActivity;

@SuppressWarnings("serial")
public class ShopWorker extends User implements Serializable{
	/**
	 * the branch that the worker works in.
	 */
	private String branchID;
	private ShopWorkerActivity activityStatus;

	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param workerActivity
	 * @param isLoggedIn
	 * @param branchID
	 */
	public ShopWorker(String iD, String firstName, String lastName, String email, String phoneNumber,
			AccountStatus workerActivity, boolean isLoggedIn, String branchID,ShopWorkerActivity activityStatus) {
		super(iD, firstName, lastName, email, phoneNumber, workerActivity, isLoggedIn);
		this.branchID = branchID;
		this.setActivityStatus(activityStatus);
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
		return "Shop Worker";
	}


	public ShopWorkerActivity getActivityStatus() {
		return activityStatus;
	}


	public void setActivityStatus(ShopWorkerActivity activityStatus) {
		this.activityStatus = activityStatus;
	}

}
