package entities_users;

import entities_general.Login;

@SuppressWarnings("serial")
public class MarketingWorker extends Login {
	private String marketingWorkerID, FirstName, LastName, email, phoneNumber, isLoggedIn;

	public MarketingWorker(String marketingWorkerID, String firstName, String lastName, String email,
			String phoneNumber, String isLoggedIn, String userName, String password) {
		super(userName, password);
		this.marketingWorkerID = marketingWorkerID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isLoggedIn = isLoggedIn;
	}

	public String getMarketingWorkerID() {
		return marketingWorkerID;
	}

	public void setMarketingWorkerID(String marketingWorkerID) {
		this.marketingWorkerID = marketingWorkerID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marketingWorkerID == null) ? 0 : marketingWorkerID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarketingWorker other = (MarketingWorker) obj;
		if (marketingWorkerID == null) {
			if (other.marketingWorkerID != null)
				return false;
		} else if (!marketingWorkerID.equals(other.marketingWorkerID))
			return false;
		return true;
	}

}
