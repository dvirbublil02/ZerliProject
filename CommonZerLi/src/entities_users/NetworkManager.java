package entities_users;

import entities_general.Login;

@SuppressWarnings("serial")
public class NetworkManager extends Login {
	private String networkManagerID, FirstName, LastName, email, phoneNumber, isLoggedIn;

	public NetworkManager(String networkManagerID, String firstName, String lastName, String email, String phoneNumber,
			String isLoggedIn, String userName, String password) {
		super(userName, password);
		this.networkManagerID = networkManagerID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isLoggedIn = isLoggedIn;
	}

	public String getNetworkManagerID() {
		return networkManagerID;
	}

	public void setNetworkManagerID(String networkManagerID) {
		this.networkManagerID = networkManagerID;
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
		result = prime * result + ((networkManagerID == null) ? 0 : networkManagerID.hashCode());
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
		NetworkManager other = (NetworkManager) obj;
		if (networkManagerID == null) {
			if (other.networkManagerID != null)
				return false;
		} else if (!networkManagerID.equals(other.networkManagerID))
			return false;
		return true;
	}

}
