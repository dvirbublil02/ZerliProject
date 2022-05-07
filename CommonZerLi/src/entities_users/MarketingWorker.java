package entities_users;

import enums.AccountStatus;

/**
 * @author User Omri Shalev
 */
@SuppressWarnings("serial")
public class MarketingWorker extends User {
	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param accountStatus
	 * @param isLoggedIn
	 */
	public MarketingWorker(String iD, String firstName, String lastName, String email, String phoneNumber,
			AccountStatus accountStatus, boolean isLoggedIn) {
		super(iD, firstName, lastName, email, phoneNumber, accountStatus, isLoggedIn);
	}

	@Override
	public String toString() {
		return "Marketing Worker: " + FirstName + " " + LastName;
	}
}
