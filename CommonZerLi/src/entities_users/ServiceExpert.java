package entities_users;

import enums.AccountStatus;

/**
 * @author User Omri Shalev
 */
@SuppressWarnings("serial")
public class ServiceExpert extends User {
	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param accountStatus
	 * @param isLoggedIn
	 */
	public ServiceExpert(String iD, String firstName, String lastName, String email, String phoneNumber,
			AccountStatus accountStatus, boolean isLoggedIn) {
		super(iD, firstName, lastName, email, phoneNumber, accountStatus, isLoggedIn);
	}

	@Override
	public String toString() {
		return "Service Expert: " + FirstName + " " + LastName;
	}
}
